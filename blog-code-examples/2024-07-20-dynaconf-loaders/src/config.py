import boto3
from botocore.exceptions import ClientError, BotoCoreError
from dynaconf import Dynaconf, LazySettings
import logging

# Configure logging
logger = logging.getLogger(__name__)


def _aws_parameter_store_loader(ssm_client, parameters_prefix="/my-application/") -> dict:
    paginator = ssm_client.get_paginator("get_parameters_by_path")
    parameters_from_aws = {}

    for page in paginator.paginate(Path=parameters_prefix, Recursive=True, WithDecryption=True):
        for param in page["Parameters"]:
            param_name_full = param["Name"]
            param_value = param["Value"]

            try:
                *_, param_name = param_name_full.split("/")
            except ValueError:
                logger.warning('Parameter name pattern outside of expected format, skipping: "{param_name_full}"')
                continue

            parameters_from_aws[param_name] = param_value

    return parameters_from_aws


def load(obj: LazySettings, env: str, silent: bool = True, key: str = None, filename: str = None) -> None:
    global parameters_from_aws

    logger.debug(f"Parameters loaded from AWS Parameter Store: {list(parameters_from_aws)}")
    obj.update(parameters_from_aws)


# Attempt to load parameters from AWS Parameter Store and update Dynaconf loaders
try:
    ssm_client = boto3.client('ssm')
    parameters_from_aws = _aws_parameter_store_loader(ssm_client)
except (BotoCoreError, ClientError) as e:
    LOADERS_FOR_DYNACONF = ["dynaconf.loaders.env_loader"]
    logger.warning("AWS active session not detected, skipping load parameters from AWS Parameter Store")
else:
    LOADERS_FOR_DYNACONF = [__name__, "dynaconf.loaders.env_loader"]

# Initialize Dynaconf settings with specified files and loaders
settings = Dynaconf(
    settings_files=["settings.toml", ".secrets.toml"],
    envvar_prefix="MY_APP",
    LOADERS_FOR_DYNACONF=LOADERS_FOR_DYNACONF,
)

import boto3
from botocore.exceptions import ClientError, BotoCoreError
from dynaconf import Dynaconf, LazySettings
import logging

logger = logging.getLogger(__name__)
PARAMETERS_PREFIX = "/my-application/"


# Retrieve parameters from AWS Parameter Store recursively by prefix
def _aws_parameter_store_loader(parameters_prefix: str) -> dict:
    ssm_client = boto3.client('ssm')

    paginator = ssm_client.get_paginator("get_parameters_by_path")
    pages = paginator.paginate(Path=parameters_prefix, Recursive=True, WithDecryption=True)

    parameters_from_aws_raw = {}

    for page in pages:
        for param in page["Parameters"]:
            name_full = param["Name"]
            value = param["Value"]
            parameters_from_aws_raw[name_full] = value

    parameters_from_aws = {}

    for name_full, value in parameters_from_aws_raw.items():
        try:
            *_, name = name_full.split("/")
        except ValueError:
            logger.warning(f'Parameter name pattern outside of expected format, skipping: "{name_full}"')
        else:
            parameters_from_aws[name] = value

    return parameters_from_aws


# Dynaconf callback - used in this case for retrieve parameters from AWS Parameter Store
def load(obj: LazySettings, env: str, silent: bool = True, key: str = None, filename: str = None) -> None:
    global parameters_from_aws

    logger.debug(f"Parameters loaded from AWS Parameter Store: {list(parameters_from_aws)}")
    obj.update(parameters_from_aws)


# Attempt to load parameters from AWS Parameter Store and update Dynaconf loaders
try:
    parameters_from_aws = _aws_parameter_store_loader(PARAMETERS_PREFIX)
except (BotoCoreError, ClientError) as e:
    LOADERS_FOR_DYNACONF = ["dynaconf.loaders.env_loader"]
    logger.warning("AWS active session not detected, skipping load parameters from AWS Parameter Store")
else:
    # __name__ is module name that have "load()" callback. It could be another module...
    LOADERS_FOR_DYNACONF = [__name__, "dynaconf.loaders.env_loader"]


# Initialize Dynaconf settings with specified files and loaders
settings = Dynaconf(
    settings_files=["settings.yaml", ".secrets.yaml"],
    envvar_prefix="MY_APP",
    LOADERS_FOR_DYNACONF=LOADERS_FOR_DYNACONF,
)

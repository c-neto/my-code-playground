import boto3
from botocore.exceptions import ClientError, BotoCoreError
from dynaconf import Dynaconf, LazySettings
import logging

# Initialize the logger
logger = logging.getLogger(__name__)


def check_aws_environment():
    """
    Checks if the AWS environment is set up correctly by calling STS to get the caller identity.
    Logs the caller identity for debugging purposes.
    """
    sts_client = boto3.client('sts')
    response = sts_client.get_caller_identity()
    logger.debug(f"Caller Identity: {repr(response)}")


def aws_parameter_store_loader(parameters_prefix="/my-application/") -> dict:
    """
    Loads parameters from AWS Systems Manager (SSM) Parameter Store.

    Args:
        parameters_prefix (str): The prefix for the parameters to load.

    Returns:
        dict: A dictionary of parameters loaded from AWS SSM Parameter Store.
    """
    # Configure the boto3 client to use LocalStack
    ssm_client = boto3.client('ssm')

    paginator = ssm_client.get_paginator("get_parameters_by_path")
    parameters_from_aws = {}

    for page in paginator.paginate(Path=parameters_prefix, Recursive=True, WithDecryption=True):
        for param in page["Parameters"]:
            param_name_full = param["Name"]
            param_value = param["Value"]

            try:
                *_, param_name = param_name_full.split("/")
            except Exception:
                logger.warning(f'Parameter name pattern outside of expected format, skipping: "{param_name_full}"')
                continue

            parameters_from_aws.update({param_name: param_value})

    return parameters_from_aws


def load(obj: LazySettings, env: str, silent: bool = True, key: str = None, filename: str = None) -> None:
    """
    Callback used by Dynaconf to load parameters from AWS Parameter Store.

    Args:
        obj (LazySettings): The LazySettings object to update with parameters.
        env (str): The current environment (e.g., development, production).
        silent (bool): If True, suppresses any exceptions raised during the loading process.
        key (str): The key to load (not used in this implementation).
        filename (str): The filename to load (not used in this implementation).
    """
    parameters_from_aws = aws_parameter_store_loader()
    logger.debug(f"Parameters loaded from AWS Parameter Store: {list(parameters_from_aws.keys())}")
    obj.update(parameters_from_aws)


try:
    check_aws_environment()
except (RuntimeError, BotoCoreError, ClientError) as e:
    LOADERS_FOR_DYNACONF = ["dynaconf.loaders.env_loader"]
    logger.warning("AWS active session not detected, skipping load parameters from AWS Parameter Store")
else:
    LOADERS_FOR_DYNACONF = [__name__, "dynaconf.loaders.env_loader"]

# Initialize Dynaconf settings
settings = Dynaconf(
    settings_files=["settings.yaml", ".secrets.yaml"],
    envvar_prefix="MY_APP",
    LOADERS_FOR_DYNACONF=LOADERS_FOR_DYNACONF,
)

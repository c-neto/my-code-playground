import boto3
from botocore.exceptions import ClientError, BotoCoreError
from dynaconf import Dynaconf, LazySettings
import logging

logger = logging.getLogger(__name__)


def __check_aws_environment():
    sts_client = boto3.client('sts')
    response = sts_client.get_caller_identity()
    logger.debug(f"Caller Identity: {repr(response)}")


def __aws_parameter_store_loader(parameters_prefix="/my-application/") -> dict:
    # Configure the boto3 client to use LocalStack
    ssm_client = boto3.client('ssm')

    paginator = ssm_client.get_paginator("get_parameters_by_path")
    parameter_from_aws = {}

    for page in paginator.paginate(Path=parameters_prefix, Recursive=True, WithDecryption=True):
        for param in page["Parameters"]:
            param_name_full = param["Name"]
            param_value = param["Value"]

            try:
                *_, param_name = param_name_full.split("/")
            except (Exception,):
                logger.warning(f'parameter name pattern outside of pattern, skipping: "{param_name_full}"')
                continue

            parameter_from_aws.update({param_name: param_value})

    return parameter_from_aws


# callback used by parameter dynaconf to retrieve values from AWS Parameter Store
def load(obj: LazySettings, env: str, silent: bool = True, key: str = None, filename: str = None) -> None:
    parameter_from_aws = __aws_parameter_store_loader()
    logger.debug(f"parameters loaded from AWS Parameter Store: {list(parameter_from_aws)}")
    obj.update(parameter_from_aws)


try:
    __check_aws_environment()
except (RuntimeError, BotoCoreError, ClientError) as e:
    _loaders_for_dynaconf = ["dynaconf.loaders.env_loader"]
    logger.warning("not detected AWS active session, skipping load parameters from AWS parameter store")
else:
    _loaders_for_dynaconf = [__name__, "dynaconf.loaders.env_loader"]


settings = Dynaconf(
    settings_files=["settings.yaml", ".secrets.yaml"],
    envvar_prefix="MY_APP",
    LOADERS_FOR_DYNACONF=_loaders_for_dynaconf,
)

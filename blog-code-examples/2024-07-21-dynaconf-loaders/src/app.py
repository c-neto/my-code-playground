from config import settings

settings_inspect = f"""
>>> settings retrieved from dyanconf"
{settings['PARAMETER_FROM_SETTINGS_YAML_FILE']=}
{settings['PARAMETER_FROM_SECRETS_YAML_FILE']=}
{settings.get('PARAMETER_FROM_AWS_PARAMETER_STORE_1')=}
{settings.get('PARAMETER_FROM_AWS_PARAMETER_STORE_2')=}
"""


def main():
    print(settings_inspect)


if __name__ == "__main__":
    main()

import docker
from loguru import logger
from json import tool
import argparse


try:
    docker_client = docker.from_env()
except Exception as e:
    logger.critical('Docker Enginge is not acessible')
    raise


def watchdog() -> None:
    global docker_client

    for container in docker_client.containers.list():
        logger.info('Container: {} | State: {}'.format(container.name, container.attrs['State']['Health']['Status']))
        if container.attrs['State']['Health']['Status'] == 'unhealthy':
            logger.warning('Restart | {} | {}'.format(container.name, container.attrs['State']['Health']['Status']))
            try:
                container.restart()
                logger.success('Container restart with successful | {}'.format(container.name))
            except Exception as e:
                logger.trace(e)
                logger.error('It was not possible restart container | {}'.format(container.name))


if __name__ == "__main__":
    parser = argparse.ArgumentParser(
        prog='python3 -m py-watchdog', 
        description='A simple toolbox to watchdog Docker containers'
    )

    parser.parse_args()

    watchdog()
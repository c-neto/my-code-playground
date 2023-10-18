from dynaconf import settings
from utils import log
from loguru import logger
from time import sleep


if __name__ == '__main__':
    try:
        log.configure_log(**settings.get('LOG'))
    except Exception as e:
        logger.error(e)
        logger.warning('utilizando as configurações de log padrão')
        log.configure_log()

    while True:
        logger.trace('trace')
        logger.info('info')
        logger.debug("debug")
        logger.critical("warning")
        logger.warning("warning")
        
        sleep(1)

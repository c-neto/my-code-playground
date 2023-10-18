from dynaconf import settings
from loguru import logger
from pathlib import Path
import sys


class MyFilter:
    def __call__(self, record):
        try:
            level_no = logger.level(settings.get('LOG', fresh=True).get('level', 'TRACE')).no
        except Exception as ignored:
            level_no = 0

        return record["level"].no >= level_no


def configure_log(level: str = 'TRACE', datetime_rotation: str = '00:00', directory: str = '_log',
                  persisted: bool = True):

    log_levels = ['TRACE', 'DEBUG', 'INFO', 'SUCCESS', 'WARNING', 'ERROR', 'CRITICAL']

    my_filter = MyFilter()
    logger.remove()
    logger.add(
        sys.stderr,
        level=level,
        filter=my_filter,
        format='<fg #A8A8A8>{time:YYYY-MM-DD : HH:mm:sss}</fg #A8A8A8> | {thread.name} | <lvl>{level}</lvl> | <green>{message}</green>'
    )

    if persisted:
        log_directory = Path(directory)
        try:
            log_directory.mkdir(parents=True, exist_ok=True)
            for nivel_no, log_nivel in enumerate(log_levels):
                log_file = '{}_{}.log'.format(nivel_no, log_nivel)
                log_file_abspath = Path.joinpath(log_directory, log_file)
                logger.add(
                    log_file_abspath,
                    format='<fg #A8A8A8>{time:YYYY-MM-DD : HH:mm:sss}</fg #A8A8A8> | {file} - {module}:{name}:{function}:{line} | {thread.name} | <lvl>{level}</lvl> | <green>{message}</green>',
                    level=log_nivel,
                    rotation=datetime_rotation,
                    compression="tar.gz"
                )
        except Exception as e:
            logger.trace(e)
            logger.warning('Não foi possivel peristir arquivos de log | {}'.format(log_directory))

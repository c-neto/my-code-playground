import pysftp
from os import getenv
from pathlib import Path
import logging
from time import sleep
from loguru import logger


def delete_file(credentials: dict, remote_file: str) -> None:
    with pysftp.Connection(**credentials) as sftp:
        logging.debug("Connection succesfully stablished")
        sftp.remove(remote_file)


def upload_file(credentials: dict, local_file: str, remote_file: str) -> None:
    with pysftp.Connection(**credentials) as sftp:
        logging.debug("Connection succesfully stablished")
        sftp.put(local_file, remote_file)


def download(credentials: dict, local_to_save_file: str, remote_file: str) -> None:
    with pysftp.Connection(**credentials) as sftp:
        logging.debug("Connection succesfully stablished")
        sftp.get(remote_file, local_to_save_file)


def list_files(credentials: dict, path: str) -> list:
    with pysftp.Connection(**credentials) as sftp:
        logging.debug("Connection succesfully stablished")

        sftp.cwd(path)                                 # Switch to a remote directory
        directory_structure = sftp.listdir_attr()      # Obtain structure of the remote directory `path`

        remote_files = []

        for attr in directory_structure:
            remote_files.append(attr.filename + attr)

        return remote_files


if __name__ == '__main__':
    cnopts = pysftp.CnOpts()
    cnopts.hostkeys = None

    sftp_credentials = {
        'host': getenv('SFTP-HOST', '127.0.0.1'),
        'port': getenv('SFTP-PORT', 2222),
        'username': getenv('SFTP-USERNAME', 'carlosneto'),
        'password': getenv('SFTP-PASSWORD', 'augustoliks'),
        'cnopts': cnopts
    }

    count = 0

    while True:
        count += 1
        logger.info(list_files(sftp_credentials, '/upload'))

        file_to_upload = Path('../volumes/client/carlos.txt')
        file_remote = '/upload/file-id-{}'.format(count)

        logger.success('Upload successful | local file: {} | remote file: {}'.format(
            str(file_to_upload.absolute()), file_remote)
        )

        upload_file(sftp_credentials, str(file_to_upload.absolute()), file_remote)

        sleep(3)

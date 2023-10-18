import json
import etcd3
import logging
from time import sleep
import os


client = etcd3.client(host=os.getenv('ETCD_CONTAINER_NAME', '127.0.0.1'), port=2379)
counter = 0


while True:
    counter += 1
    value = {'test': counter}
    print(f'write: {value}')

    try:
        client.put('/test', json.dumps(value))
    except Exception as e:
        logging.exception(e)

    sleep(1)

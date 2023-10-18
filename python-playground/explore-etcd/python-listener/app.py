import json
import etcd3
import logging
from time import sleep
import os


client = etcd3.client(host=os.getenv('ETCD_CONTAINER_NAME', '127.0.0.1'), port=2379)


while True:
    try:
        value, _kvm_metadata = client.get('/test')
        print(json.loads(value))
    except Exception as e:
        logging.exception(e)
    sleep(1)

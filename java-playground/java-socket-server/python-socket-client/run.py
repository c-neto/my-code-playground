import socket
import time
import logging
from datetime import datetime
import os


logging.basicConfig(
    level=os.getenv('LOG_LEVEL', 'DEBUG'),
    format='%(asctime)-15s | %(message)s'
)

socket_server = os.getenv("SOCKET_SERVER_ADDRESS", "127.0.0.1")
socket_port = int(os.getenv("SOCKET_SERVER_PORT", 9090))

socket_bind = (socket_server, socket_port)

while True:
    message = f"{datetime.now().isoformat()} - get commit-hash\n"

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as socket_client:
        try:
            socket_client.connect(socket_bind)
        except Exception as e:
            logging.warning(f"is not possible connect to socket server | {e}")
            time.sleep(5)
            continue

        try:
            socket_client.send(message.encode())
        except Exception as e:
            logging.warning(f"is not possible send message to socket server | {e}")
            time.sleep(5)
            continue
        else:
            logging.debug(
                f'>>> SENT:           '
                f'"{message.strip()}" | socket server: {socket_server}:{socket_port}'
            )

        try:
            reply_message = socket_client.recv(1024)
        except Exception as e:
            logging.warning(
                "is not possible receive message from socket server"
                f" | socket server: {socket_server}:{socket_port} | {e}"
            )
            time.sleep(5)
        else:
            logging.info(
                '<<< RECEIVED:       '
                f'"{reply_message.decode().strip()}"'
            )

        time.sleep(1)

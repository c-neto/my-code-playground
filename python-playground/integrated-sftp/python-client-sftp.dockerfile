FROM python:3.7

COPY ./python-client-sftp /app
WORKDIR /app
RUN pip3.7 install -r requirements.txt
VOLUME [ "/data" ]
CMD [ "python3", "app.py" ]

FROM python:alpine3.7
WORKDIR /app
COPY . .
RUN pip3.7 install -r requirements.txt
EXPOSE 5000
HEALTHCHECK --interval=5s --timeout=5s --retries=2 CMD sh healthcheck.sh
CMD python3 run.py

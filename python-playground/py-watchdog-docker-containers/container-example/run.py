from flask import Flask


app = Flask(__name__)


@app.route('/')
def root():
    return 'ok'


@app.route('/healthcheck')
def health_check():
    return 'health-ok', 200


app.run(host='0.0.0.0', port=5000)

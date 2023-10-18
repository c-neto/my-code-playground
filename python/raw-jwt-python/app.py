"""
créditos: https://gist.github.com/gustavolopess/e61a33deee8ee0a4f1c1e085ead0add5
"""

import base64
import datetime
import hashlib
import hmac
import json
from time import sleep
from loguru import logger


secret_key = '52d3f853c19f8b63c0918c126422aa2d99b1aef33ec63d41dea4fadf19406e54'


def create_jwt(payload: dict):
    payload_text = json.dumps(payload).encode()

    header = json.dumps({
        'typ': 'JWT',
        'alg': 'HS256'
    }).encode()

    b64_header = base64.urlsafe_b64encode(header).decode()
    b64_payload = base64.urlsafe_b64encode(payload_text).decode()

    signature = hmac.new(
        key=secret_key.encode(),
        msg=f'{b64_header}.{b64_payload}'.encode(),
        digestmod=hashlib.sha256
    ).digest()

    b64_signature = base64.urlsafe_b64encode(signature).decode()

    jwt = '{header}.{payload}.{signature}'.format(
        header=b64_header,
        payload=b64_payload,
        signature=b64_signature
    )

    return jwt


def verify_jwt(jwt: str) -> None:
    b64_header, b64_payload, b64_signature = jwt.split('.')

    signature_to_verify = hmac.new(
        key=secret_key.encode(),
        msg=f'{b64_header}.{b64_payload}'.encode(),
        digestmod=hashlib.sha256
    ).digest()

    b64_signature_to_verify = base64.urlsafe_b64encode(
        signature_to_verify
    ).decode()

    # payload extraido antes para checar o campo 'exp'
    payload = json.loads(base64.urlsafe_b64decode(b64_payload))

    unix_time_now = datetime.datetime.now().timestamp()

    if payload.get('exp') and payload['exp'] < unix_time_now:
        raise RuntimeError('Token expirado')

    if b64_signature_to_verify != b64_signature:
        raise RuntimeError('Assinatura inválida')


def test_token_valid():
    logger.warning('TESTE DE TOKEN VALIDO')

    payload = {
        'userId': '1',
        'exp': (datetime.datetime.now() + datetime.timedelta(seconds=5)).timestamp(),
    }
    jwt_created = create_jwt(payload)

    logger.info(f'token criado: {jwt_created}')
    sleep(1)

    logger.info('verificando token...')
    sleep(1)

    try:
        verify_jwt(jwt_created)
    except RuntimeError as e:
        logger.error(str(e))
    else:
        logger.success('token válido')


def test_token_time_expire():
    logger.warning('TESTE DE INVALIDEZ DE TOKEN POR TEMPO DE EXPIRAÇAO')

    payload = {
        'userId': '1',
        'exp': (datetime.datetime.now() + datetime.timedelta(seconds=5)).timestamp(),
    }
    jwt_created = create_jwt(payload)

    logger.info('token criado com tempo de expiração fixado em 5 segundos')
    logger.info(f'token: {jwt_created}')
    sleep(1)

    logger.info('aguardando 6 segundos para que o token não seja mais válido')
    sleep(6)

    logger.info('verificando token...')
    sleep(1)

    try:
        verify_jwt(jwt_created)
    except RuntimeError as e:
        logger.error(str(e))
    else:
        logger.success('token válido')


def test_modified_token():
    logger.warning('TESTE DE MODIFICAÇÃO DE TOKEN')

    payload_base = {
        'userId': '1',
        'exp': (datetime.datetime.now() + datetime.timedelta(minutes=5)).timestamp(),
    }
    jwt_created = create_jwt(payload_base)

    logger.info('token criado com tempo de expiração fixado em 5 minutos')
    logger.info(f'token: {jwt_created}')

    sleep(1)

    try:
        verify_jwt(jwt_created)
    except RuntimeError as e:
        logger.error(str(e))
    else:
        logger.success('token válido')

    logger.info('modificando o token')

    b64_header, b64_payload, b64_signature = jwt_created.split('.')
    header = json.loads(base64.b64decode(b64_header).decode())
    payload = json.loads(base64.b64decode(b64_payload).decode())
    signature = b64_signature

    logger.info('token decodificado: '
          f'header={header} |'
          f'payload={payload} |'
          f'signature={signature}')
    sleep(1)

    payload['userId'] = '6661'

    logger.info('conteudo modificado: '
          f'header="{header}" | '
          f'payload="{payload}" | '
          f'signature="{signature}"')

    b64_payload_modified = base64.urlsafe_b64encode(json.dumps(payload).encode()).decode()
    new_token = f'{b64_header}.{b64_payload_modified}.{b64_signature}'

    logger.info(f'token alterado: {b64_payload_modified}')

    try:
        verify_jwt(new_token)
    except RuntimeError as e:
        logger.error(str(e))
    else:
        logger.info('token válido')


if __name__ == '__main__':
    test_token_valid()
    logger.info('\n')

    test_token_time_expire()
    logger.info('\n')

    test_modified_token()
    logger.info('\n')

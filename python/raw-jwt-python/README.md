# raw-jwt-python

- __Data__: 08/10/2020
- __Autor__: [@augustoliks](https://github.com/augustoliks) | <carlos.santos110@fatec.sp.gov.br>
- __Créditos__: [@gustavolopess](https://github.com/gustavolopess)

- __Objetivo__: Explorar o JWT, criando e manipulando Tokens, e testando sua integridade em devidas ocasiões.

## Como Executar

```shell
git clone https://github.com/augustoliks/raw-jwt-python
cd raw-jwt-python/
virtualenv --python=$(which python3) venv
source venv/bin/activate
pip3 install -r requirements.txt
python3 app.py
```

## Saída dos testes:

```
23:23:59.473 | WARNING  | test_token_valid:71 - TESTE DE TOKEN VALIDO
23:23:59.474 | INFO     | test_token_valid:79 - token criado: eyJ0eXAiOiAiSldUIiwgImFsZyI6ICJIUzI1NiJ9.eyJ1c2VySWQiOiAiMSIsICJleHAiOiAxNjAyMjEwMjQ0LjQ3NDIxNn0=.AHI5TOZQBJniNlA-CLGO6QujF1MMQkrgCYaDUrqCOmY=
23:24:00.475 | INFO     | test_token_valid:82 - verificando token...
23:24:01.477 | SUCCESS  | test_token_valid:90 - token válido

23:24:01.478 | WARNING  | test_token_time_expire:94 - TESTE DE INVALIDEZ DE TOKEN POR TEMPO DE EXPIRAÇAO
23:24:01.478 | INFO     | test_token_time_expire:102 - token criado com tempo de expiração fixado em 5 segundos
23:24:01.479 | INFO     | test_token_time_expire:103 - token: eyJ0eXAiOiAiSldUIiwgImFsZyI6ICJIUzI1NiJ9.eyJ1c2VySWQiOiAiMSIsICJleHAiOiAxNjAyMjEwMjQ2LjQ3ODY3MX0=.b158innv9KCO90Q7i0bHgaVm6vuygmlbCxxoO0oKMhU=
23:24:02.481 | INFO     | test_token_time_expire:106 - aguardando 6 segundos para que o token não seja mais válido
23:24:08.483 | INFO     | test_token_time_expire:109 - verificando token...
23:24:09.485 | ERROR    | test_token_time_expire:115 - Token expirado

23:24:09.487 | WARNING  | test_modified_token:121 - TESTE DE MODIFICAÇÃO DE TOKEN
23:24:09.487 | INFO     | test_modified_token:129 - token criado com tempo de expiração fixado em 5 minutos
23:24:09.488 | INFO     | test_modified_token:130 - token: eyJ0eXAiOiAiSldUIiwgImFsZyI6ICJIUzI1NiJ9.eyJ1c2VySWQiOiAiMSIsICJleHAiOiAxNjAyMjEwNTQ5LjQ4NzU2OH0=.wPdOKL272uxjHrZhgUJftMT_pSGjmiyRXRjMG_n_ao0=
23:24:10.490 | SUCCESS  | test_modified_token:139 - token válido
23:24:10.490 | INFO     | test_modified_token:141 - modificando o token
23:24:10.490 | INFO     | test_modified_token:148 - token decodificado: header={'typ': 'JWT', 'alg': 'HS256'} |payload={'userId': '1', 'exp': 1602210549.487568} |signature=wPdOKL272uxjHrZhgUJftMT_pSGjmiyRXRjMG_n_ao0=
23:24:11.492 | INFO     | test_modified_token:156 - conteudo modificado: header="{'typ': 'JWT', 'alg': 'HS256'}" | payload="{'userId': '6661', 'exp': 1602210549.487568}" | signature="wPdOKL272uxjHrZhgUJftMT_pSGjmiyRXRjMG_n_ao0="
23:24:11.492 | INFO     | test_modified_token:164 - token alterado: eyJ1c2VySWQiOiAiNjY2MSIsICJleHAiOiAxNjAyMjEwNTQ5LjQ4NzU2OH0=
23:24:11.493 | ERROR    | test_modified_token:169 - Assinatura inválida
```

# Referências

- https://medium.com/@gustavolpss/json-web-tokens-jwt-em-python-c76fb34d8d9
- https://pt.wikipedia.org/wiki/JSON_Web_Token
- https://tools.ietf.org/html/rfc7519#section-4.1
# fastapi-websocket

- __Data__: 27/09/2020
- __Objetivo__: Multiplos WebSockets utilizando apenas uma porta do servidor web.
- __Autor__: [@augustoliks](https://github.com/augustoliks) | <carlos.santos110@fatec.sp.gov.br>

Implementação envio de imagens do Backend para o Frontend, via WebSocket utilizando o micro-framework [Fast API](https://fastapi.tiangolo.com/).

No exemplo, há dois web-sockets:

- `/ws-images`: Envio de um JSON que simula imagens;
- `/ws-logs`: Envio de um JSON que simula mesagens de log.

A aplicação utiliza apenas uma única porta, pois os Web Sockets são definidos por rotas. 

# Execução 

```bash
docker-compose up --build -d
```

Com o container operando, acessar: http://127.0.0.1:8000

# Resultado

A cada 1 segundos, o WebSocket `/ws-logs`, é atualizado pelo Backend, eviando mensagens de logs simulados.


![](.images/img-1.png)

A cada 2 segundos, o WebSocket `/ws-image`, é atualizado pelo Backend, eviando imagens.

![](.images/img-2.png)
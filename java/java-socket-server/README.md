# java-socket-server

Ambiente em docker-compose, composto por um cliente em python, que faz requisições para um servidor em Java. A conexão, é feita com socket, com o protocolo TCP. Ao receber a requisição, o servidor lê o conteúdo do arquivo [commit-hash.txt](./commit-hash.txt), e retorna para o cliente.

## Execução

Para provisionar o ambiente, executar:

```shell
$ docker-compose up --build -d
```

Verificando o conteúdo do arquivo [commit-hash.txt](./commit-hash.txt)

```shell
$ cat commit-hash.txt

 12345def33347890a526a857dbb4cdb434bf8acc954fe
```

Verificando o log do container cliente:

```shell
$ docker logs socket-client-python
    
 message sent: "2021-05-22T02:55:15.630995 - get commit-hash" | socket server: java-socket-server:9090
 commit hash receive from server: "1234533347890a526a857dbb4cdb434bf8acc954fe"
```

Verificando o log do container servidor:

```shell
$ docker logs socket-server-java

 wait connections...
 received: "2021-05-22T02:55:15.630995 - get commit-hash"
 reply: 1234533347890a526a857dbb4cdb434bf8acc954fe
```

Alterando o arquivo [commit-hash.txt](./commit-hash.txt):

```shell
echo "abcdef33347890a526a857dbb4cdb434bf8acc954fe" > commit-hash.txt
```

Verificando o log do container cliente:

```shell
$ docker logs socket-client-python
    
 message sent: "2021-05-22T02:58:13.077073 - get commit-hash" | socket server: java-socket-server:9090
 commit hash receive from server: abcdef33347890a526a857dbb4cdb434bf8acc954fe
```

Verificando o log do container servidor:

```shell
$ docker logs socket-server-java
    
 wait connections...
 received: "2021-05-22T02:58:13.077073 - get commit-hash"
 reply: abcdef33347890a526a857dbb4cdb434bf8acc954fe
```

---

Testando comunicação com o servidor com o [telnet](https://en.wikipedia.org/wiki/Telnet);

```shell
$ telnet 127.0.0.1 9090                                                      

 Trying 127.0.0.1...
 Connected to 127.0.0.1.
 Escape character is '^]'.
 get commit hash... 
 abcdef33347890a526a857dbb4cdb434bf8acc954fe
 Connection closed by foreign host.
```

> :warning: A mensagem do cliente só será enviada para servidor se estiver terminada com `\n`

# Estagio de build do jar
FROM maven:3-jdk-11-slim as builder

WORKDIR /app

# Definindo o diretorio de operacao do projeto, para instalacao das dependencias
COPY . .

# Instalando as dependencias
RUN mvn -DskipTests=true clean
RUN mvn verify
RUN mvn -DskipTests install

# Criando diretorio "/app-jar-output", e copiando o ".jar" deste projeto, com as dependencias inclusas
RUN mkdir /app-jar-output
RUN cp /app/target/*jar-with-dependencies.jar /app-jar-output


# Estagio de criacao de imagem para producao
FROM openjdk:11-jre-slim-buster

# Definindo o diretorio de operacao do projeto
WORKDIR /app

# atualizar a base de timezone e atualizar os pacotes do sistema
RUN apt-get update -y \
    && apt-get upgrade -y \
    && apt-get --only-upgrade install tzdata -y \
    && apt-get autoremove -y \
    && apt-get autoclean -y \
    && rm -rf /var/lib/apt/lists/*

# Copiando o ".jar" do estagio de builder da aplicação
COPY --from=builder /app-jar-output/ .
# COPY commit-hash.txt /etc/commit-hash.txt

# Executando a aplicacao. Foi adotado o "*", para que este Dockerfile seja reaproveitado em outras aplicacoes uma vez que não há valores fixados.
CMD /usr/local/openjdk-11/bin/java $JAVA_OPTS -jar $(ls *jar-with-dependencies.jar)

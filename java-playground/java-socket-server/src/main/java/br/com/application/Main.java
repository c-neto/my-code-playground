package br.com.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class.getName());

    final static String SOCKET_SERVER_PORT = System.getenv("SOCKET_SERVER_PORT");
    final static String COMMIT_FILE_PATH = System.getenv("COMMIT_FILE_PATH");
    final static String VERSION = System.getenv("VERSION");

    public static void main(String[] args) throws IOException {
        logger.debug("environment variable SOCKET_SERVER_PORT: " + SOCKET_SERVER_PORT);
        logger.debug("environment variable COMMIT_FILE_PATH: " + COMMIT_FILE_PATH);
        logger.debug("environment variable VERSION: " + VERSION);

        Integer socketPort = Integer.parseInt(SOCKET_SERVER_PORT);

        ReadFile readFile = new ReadFile(COMMIT_FILE_PATH);
        SocketServer socketServer = new SocketServer(socketPort, readFile, VERSION);

        socketServer.starts();
    }
}

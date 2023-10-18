package br.com.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer {
    static final Logger logger = LogManager.getLogger(SocketServer.class.getName());

    private final ServerSocket socketServer;
    private final ReadFile readFile;
    private final String version;

    public SocketServer(Integer port, ReadFile readFile, String version) throws IOException {
        this.socketServer = new ServerSocket(port);
        this.readFile = readFile;
        this.version = version;
    }

    public void starts() throws IOException {
        while (true) {
            logger.debug("wait connections ...");

            Socket socketConnection = this.socketServer.accept();
            InputStreamReader inputStreamReader = new InputStreamReader(socketConnection.getInputStream());

            PrintWriter outputStream = new PrintWriter(socketConnection.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(inputStreamReader);
            String receivedText = reader.readLine();
            logger.info("received: " + receivedText);

            String commitFileContent = this.readFile.read();
            String messageReply = "VERSION: " + this.version + " | COMMIT-HASH: " + commitFileContent;

            outputStream.println(messageReply);
            outputStream.flush();

            logger.info("reply: " + messageReply);

            outputStream.close();
            reader.close();

        }
    }
}
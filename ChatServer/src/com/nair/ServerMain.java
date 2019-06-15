package com.nair;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerMain {
    public static void main(String args[]) {
        int port = 8818;
        try {
            ServerSocket serverSocket = new ServerSocket(port); // server with port
            while (true) {
                System.out.println("About to accept the client connection");
                Socket clientSocket = serverSocket.accept(); // socket that establishes connection with server.
                System.out.println("Accepting connection from " + clientSocket);
                ServerHandler serverHandler = new ServerHandler(clientSocket);
                serverHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

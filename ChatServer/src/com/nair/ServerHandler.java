package com.nair;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ServerHandler extends Thread{

    private final Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    private void handleClientSocket() throws IOException, InterruptedException {
        InputStream inputStream = this.clientSocket.getInputStream();
        OutputStream outputStream = this.clientSocket.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            if ("quite".equalsIgnoreCase(line)) {
                break;
            }
            String msg = "You typed: " + line + "\n";
            outputStream.write(msg.getBytes());
        }

        this.clientSocket.close();
    }

    @Override
    public void run(){
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

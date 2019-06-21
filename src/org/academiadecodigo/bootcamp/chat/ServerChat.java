package org.academiadecodigo.bootcamp.chat;

/**
 * @author Pedro Lima
 * @version  1 Jun 20, 2019
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {

    public static void main(String[] args) throws IOException {

        int portNumber = 8080;
        String messageIn = " ";
        String messageOut = " ";


        /**
         * Declare and instantiate a Server Socket
         * Server Socket will wait for conection of client
         * Socket is our client and method Accpept() listen for a connection and accept if any found.
         * Accept() blocks all the client that is made, it is waiting for someone to connect.
         */

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();

        /**
         * DataInputStream - read data
         * DataOutputStream - write data
         */

        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

        /**
         * BufferedReader - read text from a character-input stream
         * InputStreamReader is a bridge from byte streams to character streams
         */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (!messageIn.equalsIgnoreCase("Bye")){

            messageIn = dataInputStream.readUTF();
            // Print client message
            System.out.println(messageIn); 
            messageOut = bufferedReader.readLine();
            dataOutputStream.writeUTF(messageOut);
        }

        /**
         * Close() - Terminate a communications between 2 machines
         */

        clientSocket.close();
        dataInputStream.close();
        dataOutputStream.close();
        bufferedReader.close();
    }

}

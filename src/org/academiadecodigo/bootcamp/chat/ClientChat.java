package org.academiadecodigo.bootcamp.chat;

/**
 * @author Pedro Lima
 * @version 1 Jun 20, 2019
 */

import java.io.*;
import java.net.Socket;

public class ClientChat {

    public static void main(String[] args) throws IOException {

        int portNumber = 8080;
        String hostName = "127.0.0.1";
        String messageIn = " ";
        String messageOut = " ";


        /**
         * Socket is our client
         */

        Socket clientSocket = new Socket(hostName, portNumber);

        /**
         * DataInputStream - read data
         * DataOutputStream - write data
         */

        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

        /**
         * BufferedReader - read text from a character-input stream
         */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (!messageIn.equalsIgnoreCase("Bye")){

          messageOut = bufferedReader.readLine();
          dataOutputStream.writeUTF(messageOut);
          messageIn =  dataInputStream.readUTF();
          // Print server message
          System.out.println(messageIn);

         }

        /**
         * Close() - Terminate a communications between 2 machines
         */

        clientSocket.close();

    }
}
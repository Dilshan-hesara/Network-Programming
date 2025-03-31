package lk.cw;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) {
        System.out.println("sever connected");

        try {

            //sever socket

            ServerSocket serverSocket = new ServerSocket(4000);

            //local socket
            Socket socket = serverSocket.accept();
            System.out.println("client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String msg = in.readUTF();

            System.out.println(msg);

            socket.close();


        } catch (IOException e) {
            throw new RuntimeException();

        }

    }
}
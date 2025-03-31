package lk.cw;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sever {
    public static void main(String[] args) {
        System.out.println("sever connected");

        System.out.println("Server started...");
        Scanner sc = new Scanner(System.in);

        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");


            //get client msg
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String clMsg = in.readUTF();
            System.out.println("Client msg : " + clMsg);

            // Send client msg
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.print("Enter msg s : ");
            String response = sc.nextLine();
            out.writeUTF(response);
            out.flush();

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException();

        }

    }
}
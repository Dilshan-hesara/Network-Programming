package lk.cw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sever {
    public static void main(String[] args) {
        System.out.println("Server started...");
        Scanner sc = new Scanner(System.in);

        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                // get client msg
                String clMsg = in.readUTF();
                System.out.println("Client msg: " + clMsg);


                // Send msg client
                System.out.print("Enter msg s: ");
                String response = sc.nextLine();
                out.writeUTF(response);
                out.flush();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

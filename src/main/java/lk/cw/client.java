package lk.cw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 4000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            while (true) {
                // Send msg sever
                System.out.print("Enter Msg c: ");
                String msg = sc.nextLine();
                out.writeUTF(msg);
                out.flush();



                // get msg sever
                String serverResponse = in.readUTF();
                System.out.println("Server Msg: " + serverResponse);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

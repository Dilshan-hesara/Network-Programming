package lk.cw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {

        //remote socket

        Scanner sc = new Scanner(System.in);

        try {

            //send msg sever
            Socket socket = new Socket("localhost", 4000 );
            String msg;

            System.out.print("Enter Msg c  :");
            msg = sc.nextLine();

            DataOutputStream out =new DataOutputStream(socket.getOutputStream());
            out.writeUTF(msg);
            out.flush();//msg send


            //get sever msg
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String serverResponse = in.readUTF();
            System.out.println("Server: " + serverResponse);


            socket.close();
        }
        catch (IOException e) {
            throw new RuntimeException();

        }
    }
}

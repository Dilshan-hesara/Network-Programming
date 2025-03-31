package lk.cw;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) {

        //remote socket

        try {
            Socket socket = new Socket("localhost", 4000 );
            String msg ="whtyggyy";
            DataOutputStream out =new DataOutputStream(socket.getOutputStream());
            out.writeUTF(msg);
            out.flush();//msg send
            socket.close();

        }
        catch (IOException e) {
            throw new RuntimeException();

        }
    }
}

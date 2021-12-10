package ibf2021;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ser {
    public static void main(String[] args) throws IOException {
        
        Socket socket;
        ServerSocket serverSocket;

        System.out.println("Server listening at port 3000...");
        serverSocket = new ServerSocket(2427);
        socket = serverSocket.accept();

        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream()); 
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream()); 
            
            BufferedReader br = new BufferedReader(isr); 
            BufferedWriter bw = new BufferedWriter(osw);
            
        
            //InputStream is = socket.getInputStream();
            //BufferedInputStream bis = new BufferedInputStream(is);
            //DataInputStream dis = new DataInputStream(bis);
            String line = "";

            while (!line.equals("exit")) {
                
                try {
                    line = br.readLine();
                    System.out.println("Your fortune: " + line);

                    bw.write("Msg receveied");
                    bw.newLine();
                    bw.flush();

                } catch (Exception e) {
                    serverSocket.close();
                    socket.close();
                    break;
                } 
            }

        } catch (EOFException eofe) {
            serverSocket.close();
            socket.close();
        }

        serverSocket.close();
        socket.close();
    }
}

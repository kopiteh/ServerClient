package ibf2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class cli {
    public static void main(String[] args) throws IOException {
        Socket socket;
        System.out.println("Creating client socket..");
        socket = new Socket("localhost", 2427);

        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream()); 
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream()); 
            
            BufferedReader br = new BufferedReader(isr); 
            BufferedWriter bw = new BufferedWriter(osw);
            Cookie cookie = new Cookie();
            //Scanner scan = new Scanner(System.in);
            //String user_input =  scan.nextLine();
            
            //OutputStream os = socket.getOutputStream();
            //BufferedOutputStream bos = new BufferedOutputStream(os);
            //DataOutputStream dos = new DataOutputStream(bos);
            //BufferedReader reader;
            
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            
            System.out.println("Connected to localhost:2424!");

            while (!line.equals("exit")) {
                if (line.equals("get-cookie")){
                    line = cookie.get_cookie(); 
                    bw.write(line);
                    bw.newLine();
                    bw.flush(); 
                }
                line = scan.nextLine();

            }
            
            socket.close();

        }

        catch (IOException e){
            e.printStackTrace();
        }

    
    }


    }
    


package com.iwenwu.day0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length>0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                //TODO
            }
            Socket socket = null;
            BufferedReader in = null;
            PrintWriter  out = null;
            try{
                socket = new Socket("127.0.0.1",port);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);
                out.println("Query time order");
                System.out.println("send order 2 server succeed.");
                String resp = in.readLine();
                System.out.println("Now is :"+ resp);
            }catch (IOException e2){
                //e2.printStackTrace();
            }finally {
                if (out != null){
                    out.close();
                    out = null;
                }
                if (in !=null){
                    try{
                        in.close();
                    }catch (IOException e3){
                        e3.printStackTrace();
                    }
                    in = null;
                }
                if (socket != null){
                    try{
                        socket.close();
                    }catch (IOException e4){
                        e4.printStackTrace();
                    }
                    socket = null;
                }
            }

        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FFadd
 */
public class EchoServer {

    public static void main(String[] args) {
        
        System.out.println("Echo Server");
        
        try (ServerSocket serverSocket = new ServerSocket(6000))
        {
            System.out.println("Waiting for connection to client.....");
            
            //Create new socket for the client socket and set it equal to the socket that the server is accepting
            Socket clientSocket = serverSocket.accept();
            
            //Display message once server is successfully connected to client
            System.out.println("Connected to client");
            
            //Try statement initializes the buffered reader with a new input stream reader
            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            //Declare a new print writer object called out with the client socket output stream        
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) 
            {
                String inputLine;
                
                //Start a loop that runs until the buffered reader is empty
                while ((inputLine = br.readLine()) != null) 
                    {
                        System.out.println("Server: " + inputLine);
                        out.println(inputLine);   
                    }     
            }
        }
        
        
        catch (IOException ex) {
            //Handle Exceptions
        }
        
        
            
                  
                 
        }
}

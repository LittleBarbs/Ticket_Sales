package com.tickets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Kreator 11/7/2019
 * TicketServer is responsible to set up a server
 *
 */

public class TicketServer {

	/***** TCP SERVER ******/
	public static void main(String[] args) throws UnknownHostException,
    ClassNotFoundException, ClassCastException, NotSerializableException {
		
		System.out.println("*****TCP SERVER******");
		//declare a TCP socket object and initialize it to null
		ServerSocket serverSocket = null;
		
		//create the port number
		int port = 3306;
		
		try {
			//create the TCP socket server
			serverSocket = new ServerSocket(port);
			System.out.println("TCP Server created on port = " + port);
			
		} catch(IOException e) {
			//will be executed when the server cannot be created and it throws an error
			System.out.println("Could not listen on port: " + port + ", " + e);
            System.exit(1);
		}
		
		while(true) {
			//connection
			Socket clientSocket = null; 
			try {
				//start listening to incoming client request (blocking function)
				//starting with the handshake process, 3-way handshake process 2. accept the connection 3. process request
				System.out.println("[TCP Server] waiting for the incoming request...");
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.out.println("Error: cannot accept client request. Exit program.");
				return;
			}
//			output = sending the message
//			input = reading the message
			try {
				processClientRequest(clientSocket);
			} catch (IOException e) {
				//log exception and go on to the next request
			}
		}
	}
	
	
	public static void processClientRequest(Socket clientSocket) throws IOException{
		System.out.println("[TCP Server] is processing incoming request");
		
		try {
			OutputStream output = clientSocket.getOutputStream();
			InputStream input = clientSocket.getInputStream();
			
			// difference between buffered reader and input stream 
			// https://www.quora.com/What-is-the-difference-between-BufferedReader-and-InputStreamReader-in-Java
			
			PrintStream printStream = new PrintStream(output);
			InputStreamReader inputStream = new InputStreamReader(input);
			
			ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
			ShopMaker test = (ShopMaker) (ois.readObject());
			test.displayEvents();
			//read the received message
			BufferedReader bufferedReader = new BufferedReader(inputStream);
			String message = null; 
			message = bufferedReader.readLine(); //readLine() is available in buffered reader class 
			
			System.out.println("Message received from client: \n\t " + message);
			
			/** Send the response back*/
			//Prepare the String. WARNING: add \n to make sure that the message is closed!
			//String messageSend = "[TCP Server] I am a TCP Server, ahoy there mighty explorer!\n";
			//printStream.println(messageSend);
			//printStream.close();
		} catch (Exception e) {
			System.out.println("[TCP Server] The server cannot send message");
			e.printStackTrace();
		}
	}
}

package com.tickets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Kreator 11/7/2019
 * 
 * ClientBuyer is responsible to setup client 
 *
 */
public class ClientBuyer {

	public static void main(String[] args) throws IOException{
		System.out.println("*******TCP CLIENT*******");
		
		Socket clientSocket = null;
		String serverHostName = /* "localhost" */"172.16.56.189" ;
		
		int port = 3306;
		
		try {
			System.out.println("[TCP Client] attempting to connect to the TCP Server. It is attempt, it may not work!");
			clientSocket = new Socket(serverHostName, port);//three-way handshake in here
			
			ShopMaker test = new ShopMaker();
			
			
			ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
			//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("test.doc")));
			oos.writeObject(test);
			System.out.println("success"); 
			//We need input/output readers
			PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
			InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());
			
			Scanner scan = new Scanner(System.in);
//			System.out.println("Press a key to send a message...");
			scan.next();
			
			
			//Prepare a String, WARNING: do not forget about \n to close it!!
			String message = "Hello from TCP CLient!\n";
			printStream.print(message);
			
			/** Getting the response from server */
			BufferedReader bufferedReader = new BufferedReader(inputStream);
			String receivedMessage = bufferedReader.readLine();
			System.out.println("message received from server: \n\t" + receivedMessage);

		} catch (IOException e) {
			System.out.println("[TCP Client] cannot open the socket with the server");
			e.printStackTrace();
			
		}		
	}
}

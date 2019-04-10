package klient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import support.ChattErrors;

public class Client {

	// globale variabler
	private String serverIP;
	private int serverPortNumber;
	private Socket toServerSocket;
	private InputStreamReader fromUserStreamReader;
	private BufferedReader fromUserBufferedReader;
	private OutputStream toServerStream;
	private OutputStreamWriter toServerStreamWriter;
	private BufferedWriter toServerBufferedWriter;
	private InputStream fromServerStream;
	private InputStreamReader fromServerStreamReader;
	private BufferedReader fromServerBufferedReader;
	
	
	// konstruktør
	public Client(String serverIP, int serverPortNumber) {
		this.serverIP = serverIP;
		this.serverPortNumber = serverPortNumber;
		
		// starte klient
		start();
	}

	// start-metode
	private void start() {
		try {
			// koble til server via socket
			toServerSocket = new Socket(serverIP, serverPortNumber);
			
			// skriv ut tilkobling vellykket
			printConnectionInfo();
			
			// lytte etter input fra bruker
			userInputListener();
			
		} catch (UnknownHostException e) {
			System.out.println(ChattErrors.UNKNOWN_HOST);
		} catch (IOException e) {
			System.out.println(ChattErrors.IO_ERROR);
		}	
	}

	// skriv ut tilkoblingsinformasjon
	private void printConnectionInfo() {
		System.out.println("Connected to server: " + toServerSocket.getInetAddress() 
				+ ":" + toServerSocket.getPort());
		System.out.println("Message from Server: HAI ");
	}

	// vent på svar fra server
	private void serverResponseListener() throws IOException {
		// initialiserer strøm og lesere
		fromServerStream = toServerSocket.getInputStream();
		fromServerStreamReader = new InputStreamReader(fromServerStream);
		fromServerBufferedReader = new BufferedReader(fromServerStreamReader);
		
		String responseFromServer;
		
		//vent på respons fra server
		while( (responseFromServer = fromServerBufferedReader.readLine()) != null){
			// skriv ut respons fra server til konsoll
			printServerResponse(responseFromServer);
			// bryt ut av løkke etter respons fra server
			break;
		}
		
	}

	// skriver ut ekko fra server
	private void printServerResponse(String responseFromServer) {
		System.out.println(responseFromServer);
	}

	// vent på input fra bruker
	private void userInputListener() throws IOException {
		// initialiserer strøm, leser og skriver for brukerdata og data til server 
		fromUserStreamReader = new InputStreamReader(System.in);
		fromUserBufferedReader = new BufferedReader(fromUserStreamReader);
		toServerStream = toServerSocket.getOutputStream();
		toServerStreamWriter = new OutputStreamWriter(toServerStream);
		toServerBufferedWriter = new BufferedWriter(toServerStreamWriter);
		
		String messageFromUser;
		
		// vent på input fra bruker
		while( (messageFromUser = fromUserBufferedReader.readLine()) != null ){
			// send beskjed fra bruker til server
			sendMessageToServer(messageFromUser);
			
			//lytte etter svar fra server
			serverResponseListener();
			// sjekker om man mottar strengen KTHXBYE og lukker tilkoblingen
						if(messageFromUser.equals("KTHXBYE")){
							
							System.out.println(ChattErrors.Connection_lost);
							break;
						}
		}
	}

	// sender beskjeder fra bruker til server
	private void sendMessageToServer(String messageFromUser) throws IOException {
		// skriv beskjed til buffer
		toServerBufferedWriter.write(messageFromUser);
		
		// skriv ny linje for å tvinge sending
		toServerBufferedWriter.newLine();
		
		// tøm bufferen
		toServerBufferedWriter.flush();
	}	
}

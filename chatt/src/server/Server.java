package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import support.ChattErrors;

public class Server {
	
	private int portNumber;
	private ServerSocket serverSocket;
	private Socket ClientSocket;
	private InputStream fromClientStream;
	private InputStreamReader fromClientStreamReader;
	private BufferedReader fromClientBufferdReader;
	private OutputStream toClientStream;
	private OutputStreamWriter toClientStreamWriter;
	private BufferedWriter toClientBufferdWriter;

	// Konstruktør
	public Server(int portNumber) {
		this.portNumber = portNumber;
		
		
		// Start server
		
		start();
	}

	// Start-metode
	private void start() {
		// opretter serversocket
		try {
			serverSocket = new ServerSocket(portNumber);
			
			// Lytt etter tilkoblingsforsøk
			connectionListener();
			
			
			
		} catch (IOException e) {
			System.out.println(ChattErrors.IO_ERROR);
		
		}
		
	}
	
	// tilkoblingsLytter
	private void connectionListener() throws IOException {
		ClientSocket =  serverSocket.accept();
		fromClientStream = ClientSocket.getInputStream();
		toClientStream = ClientSocket.getOutputStream();
		
		// skrive ut hvem som kobler seg til
		System.out.println("Connection established to: " + ClientSocket.getInetAddress() + 
				":" + ClientSocket.getPort());
		
		
		// sender beskjed til klienten når den er logget på 
		
		
		
		// lytte etter beskjeder fra klient
		messageListener();
		close();
		
		
	}

	private void messageListener() throws IOException {
		fromClientStreamReader = new InputStreamReader(fromClientStream);
		fromClientBufferdReader = new BufferedReader(fromClientStreamReader);
		toClientStreamWriter = new OutputStreamWriter(toClientStream);
		toClientBufferdWriter = new BufferedWriter(toClientStreamWriter);
		
		
		// Vetner på at beskjeder skal dukke opp i bufferreader
		
		String messageFromClient;
		
		// henter beskjeder
		while( (messageFromClient = fromClientBufferdReader.readLine()) != null){
			// retunerer beskjed til client
			returnEcho(messageFromClient);
			System.out.println("Message from client: " +  messageFromClient);
			
			
			// sjekker om man mottar strengen KTHXBYE og lukker tilkoblingen
			if(messageFromClient.equals("KTHXBYE")){
				close();
				break;
			}
			
		}
	}

	// metode for returnering av ekko
	private void returnEcho(String messageFromClient) throws IOException {
		toClientBufferdWriter.write("Echo from server: " + messageFromClient );
		toClientBufferdWriter.newLine();
		toClientBufferdWriter.flush();
		
	}
	//metode for returnering av HAI

	
	
	// Metod for lukking av tilkobling
	private void close() throws IOException{
		ClientSocket.close();
		fromClientStream.close();
		toClientStream.close();
		
		
	}
	
	

}

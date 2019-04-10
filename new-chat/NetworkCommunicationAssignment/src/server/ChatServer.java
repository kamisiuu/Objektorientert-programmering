/**
 * 
 */
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

import errorhandler.ErrorHandler;

/**
 * @author Jonas Nordstrom
 * @date 6. apr. 2014
 *
 * Listen to specified port and wait for clients to connect. When messages are received they
 * will be responed directly by server 
 */
public class ChatServer {
	// Fields
	private int port;
	// Sockets
	private ServerSocket serverSocket;
	private Socket clientSocket;
	// Input
	private InputStream inputStream;
	private InputStreamReader inputReader;
	private BufferedReader bufferedReader;
	// Output
	private OutputStream outputStream;
	private OutputStreamWriter outputWriter;
	private BufferedWriter bufferedWriter;
	

	/**
	 * Starts server on specified port
	 * @param port
	 */
	public ChatServer(int port) {
		// Set port
		this.port = port;
		
		// Start up the server
		startServer();
	}

	/**
	 * Starts up server by setting up a socket listening to specified port
	 */
	private void startServer() {
		try {
			// Setup server with specified port
			serverSocket = new ServerSocket(port);
			System.out.println("Server is up and running on port " + port);
			
			// Listen to connections from client
			connectionListener();
			
		} catch (IOException e) {
			// Print appropriate error message
			ErrorHandler.IOError(e);
		} finally {
			closeConnection();
		}
	}

	/** 
	 * Closes both connection to client and server's own socket
	 * @throws IOException 
	 */
	private void closeConnection() {
		closeClientSocket();
		closeServerSocket();
	}

	/**
	 * Closes the server's socket
	 */
	private void closeServerSocket() {
		// Checks if the socket is already closed
		if (!serverSocket.isClosed()) {
			try {
				bufferedWriter.close();
				outputStream.close();
				serverSocket.close();
			} catch (IOException e) {
				// Print user friendly error message
				ErrorHandler.IOError(e);
			}
		}
		
		// Print info about the closing to user
		System.out.println("The server's socket is closed.");
		
	}

	/**
	 * Closes the connection to client
	 */
	private void closeClientSocket() {
		// Checks if the socket is already closed
		if (!clientSocket.isClosed()) {
			try {
				bufferedReader.close();
				inputStream.close();
				clientSocket.close();
			} catch (IOException e) {
				// Print user friendly error message
				ErrorHandler.IOError(e);
			}
		}
		
		// Print info about the closing to user
		System.out.println("The client's socket is closed.");
	}

	/**
	 * Listens to specified port
	 * @throws IOException 
	 */
	private void connectionListener() throws IOException {
		System.out.println("Server is waiting for connection to be established...");
		// Accept all clients which tries to connect to this server
		clientSocket = serverSocket.accept();
		
		// Print info about new connection
		printConnectionInfo();
		
		// Open up a stream to be able read messages from client
		inputStream = clientSocket.getInputStream();
		// Open up a stream to be able to send messages to client
		outputStream = clientSocket.getOutputStream();
		
		// Start listen for message from client
		messageListener();
	}

	/**
	 * Prints info about the clients address and port number to console
	 */
	private void printConnectionInfo() {
		System.out.println("Connection is established to " + 
				clientSocket.getInetAddress() + ":" + clientSocket.getPort());
		
	}

	/**
	 * Waits and listen for messages from client
	 * @throws IOException 
	 */
	private void messageListener() throws IOException {
		String message;
		
		inputReader = new InputStreamReader(inputStream);
		bufferedReader = new BufferedReader(inputReader);
		outputWriter = new OutputStreamWriter(outputStream);
		bufferedWriter = new BufferedWriter(outputWriter);
		
		// Loop and wait for message coming in from client
		while ( (message = bufferedReader.readLine()) != null) {
			// Print message to server console aswell
			System.out.println("Message from client: " + message);
			
			// If the message if KTHXBYE it should close the connection
			if (message.equals("KTHXBYE")) {
				// Inform client that connection will be closed
				sendMessageToClient("Connection will be closed");
				// Close connection
				break;
			}
			// Answer back to client
			sendMessageToClient(message);
		}
	}

	/**
	 * Sending message to client
	 * @param message
	 * @throws IOException 
	 */
	private void sendMessageToClient(String message) throws IOException {
		// Write message to client
		bufferedWriter.write("Echo from server: " + message);
		// Make sure message will be sent
		bufferedWriter.newLine();
		bufferedWriter.flush();
	}	
}

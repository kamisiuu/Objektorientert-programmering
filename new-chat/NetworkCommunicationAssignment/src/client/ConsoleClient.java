/**
 * 
 */
package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import errorhandler.ErrorHandler;

/**
 * @author Jonas Nordstrom
 * @date 6. apr. 2014
 *
 */
public class ConsoleClient {
	// Fields
	private String serverIp;
	private int serverPort;
	// Sockets
	private Socket socket;
	// User Input
	private InputStreamReader userInputReader;
	private BufferedReader userBufferedReader;
	// Output
	private OutputStream outputStream;
	private OutputStreamWriter outputWriter;
	private BufferedWriter bufferedWriter;
	// Server Input
	private InputStream serverInputStream;
	private InputStreamReader serverInputReader;
	private BufferedReader serverBufferedReader;
	
	/**
	 * @param serverIP
	 * @param serverPort
	 * 
	 * Starts up client and trying to connect to server
	 */
	public ConsoleClient(String serverIP, int serverPort) {
		this.serverIp = serverIP;
		this.serverPort = serverPort;
		
		// Start up client trying to connect to specified ip and address
		startClient();
	}

	/**
	 * Starts up client by trying to connect to specified ip and port
	 */
	private void startClient() {
		// Establish connection to specified address and port
		try {
			socket = new Socket(serverIp, serverPort);
			
			// Print info about connection
			printConnectionInfo();
			
			// Listen for response from server
			Thread serverListenerThread = new Thread(new ServerListener());
			serverListenerThread.start();
			
			// Listen to input from user
			userInputListener();
			
		} catch (UnknownHostException e) {
			ErrorHandler.UnknownHostError(e);
		} catch (IOException e) {
			ErrorHandler.IOError(e);
		} finally {
			// Stop server listener thread
			
		}
		
	}

	/**
	 * Prints info about the connection
	 */
	private void printConnectionInfo() {
		System.out.println("Connection is established to " + 
			socket.getInetAddress() + ":" + socket.getPort());
		
	}

	/**
	 * Listens to input from user
	 * @throws IOException 
	 */
	private void userInputListener() throws IOException {
		// Sets input to console
		userInputReader = new InputStreamReader(System.in);
		userBufferedReader = new BufferedReader(userInputReader);
		
		outputStream = socket.getOutputStream();
		outputWriter = new OutputStreamWriter(outputStream);
		bufferedWriter = new BufferedWriter(outputWriter);
		
		String message;
		
		while (!socket.isClosed()) {
		//while ( (message = userBufferedReader.readLine()) != null) {
			message = userBufferedReader.readLine();
			sendToServer(message);
		}
		
		System.out.println("The socket is closed");
	}

	/**
	 * Sends a message to server
	 * @param message
	 * @throws IOException 
	 */
	private void sendToServer(String message) throws IOException {
		bufferedWriter.write(message);
		bufferedWriter.newLine();
		bufferedWriter.flush();
	}
	
	/**
	 * Listens to server for response
	 */
	private class ServerListener implements Runnable {		
		@Override
		public void run() {
			try {
				serverListener();
			} catch (IOException e) {
				// Prints user friendly error message
				ErrorHandler.IOError(e);
			}
		}
		
		/**
		 * Listen for message from server
		 * @throws IOException 
		 */
		private void serverListener() throws IOException {			
			serverInputStream = socket.getInputStream();
			serverInputReader = new InputStreamReader(serverInputStream);
			serverBufferedReader = new BufferedReader(serverInputReader);
			
			String message;
			
			while ( (message = serverBufferedReader.readLine()) != null) {
				// Print message to user
				System.out.println(message);

			}
		}		
	}
	
	
}

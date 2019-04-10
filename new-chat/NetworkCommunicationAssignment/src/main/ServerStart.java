/**
 * 
 */
package main;

import server.ChatServer;

/**
 * @author Jonas Nordstrom
 * @date 6. apr. 2014
 *
 */
public class ServerStart {

	/**
	 * Starts up server
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ChatServer(2345);
	}

}

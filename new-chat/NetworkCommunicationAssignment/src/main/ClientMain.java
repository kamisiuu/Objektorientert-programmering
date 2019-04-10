/**
 * 
 */
package main;

import client.ConsoleClient;

/**
 * @author Jonas Nordstrom
 * @date 6. apr. 2014
 *
 */
public class ClientMain {

	/**
	 * Starts up the client
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ConsoleClient("localhost", 2345);

	}

}

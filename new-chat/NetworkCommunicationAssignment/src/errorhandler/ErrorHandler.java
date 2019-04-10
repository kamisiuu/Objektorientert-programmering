/**
 * 
 */
package errorhandler;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * @author Jonas Nordstrom
 * @date 6. apr. 2014
 *
 * Prints out appropriate error message to user depending on error
 */
public class ErrorHandler {

	public static void IOError(IOException e) {
		System.out.println("You got a error regarding the input output: " 
				+ e.toString());
	}
	public static void UnknownHostError(UnknownHostException e) {
		System.out.println("You got a error regarding unknown host: "
				+ e.toString());
	}
}

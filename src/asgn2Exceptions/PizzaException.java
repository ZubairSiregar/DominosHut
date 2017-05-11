package asgn2Exceptions;

/**
 * A class that represents exceptions related to the construction and handling of Pizza objects.
 * @author Alan Woodley
 *
 */
public class PizzaException extends Exception {

	/**
	 * Produces a PizzaException
	 */
	public PizzaException() {
	}

	/**
	 * Produces a PizzaException with the specified message
	 * @param message - The exception's message
	 */
	public PizzaException(String message) {
		super(message);
	}

	/**
	 * Produces a PizzaException with the specified cause
     * @param cause - The exception's cause
	 */
	public PizzaException(Throwable cause) {
		super(cause);
	}

	/**
	 * Produces a PizzaException with the specified message and cause
     * @param cause - The exception's cause
	 * @param message - The exception's message
	 */
	public PizzaException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Produces a PizzaException with the specified message and cause and flags to enable suppression and make the stack trace writable
     * @param cause - The exception's cause
	 * @param message - The exception's message
	 * @param enableSuppression - A flag to indicate if suppression should be enabled or disabled
	 * @param writableStackTrace - A flag to indicate if the stacktrace should be writable or not    
	 */
	public PizzaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}







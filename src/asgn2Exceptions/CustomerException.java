package asgn2Exceptions;

/**
 * A class that represents exceptions related to the construction and handling of Customer objects.
 * @author Alan Woodley
 *
 */
public class CustomerException extends Exception {

	/**
	 * Produces a CustomerException
	 */
	public CustomerException() {
	}

	/**
	 * Produces a CustomerException with the specified message
	 * @param message - The exception's message
	 */
	public CustomerException(String message) {
		super(message);
	}

	/**
	 * Produces a CustomerException with the specified cause
	 * @param cause - The exception's cause
	 */
	public CustomerException(Throwable cause) {
		super(cause);
	}

	/**
	 * Produces a CustomerException with the specified message and cause
	 * @param cause - The exception's cause
 	 * @param message - The exception's message
	 */
	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Produces a CustomerException with the specified message, cause and flags to enable suppression and make the stack trace writable
	 * @param cause - The exception's cause
 	 * @param message - The exception's message
 	 * @param enableSuppression - A flag to indicate if suppression should be enabled or disabled
 	 * @param writableStackTrace - A flag to indicate if the stacktrace should be writable or not
	 */
	public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

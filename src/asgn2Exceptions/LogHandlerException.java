package asgn2Exceptions;

/**
 * A class that represents exceptions related to reading in the log file
 * such as incorrect format or exceptions related to input/output.
 */
public class LogHandlerException extends Exception {

	/**
	 * Produces a LogHandlerException
	 */
	public LogHandlerException() {
	}

	/**
	 * Produces a LogHandlerException with the specified message
	 * @param message - The exception's message
	 */
	public LogHandlerException(String message) {
		super(message);
	}

	/**
	 * Produces a LogHandlerException with the specified cause
	 * @param cause - The exception's cause
	 */
	public LogHandlerException(Throwable cause) {
		super(cause);
	}

	/**
	 * Produces a LogHandlerException with the specified message and cause
	 * @param cause - The exception's cause
 	 * @param message - The exception's message
	 */
	public LogHandlerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Produces a LogHandlerException with the specified message and cause and flags to enable suppression and make the stack trace writable
	 * @param cause - The exception's cause
 	 * @param message - The exception's message
 	 * @param enableSuppression - A flag to indicate if suppression should be enabled or disabled
 	 * @param writableStackTrace - A flag to indicate if the stacktrace should be writable or not    
	 */	
	public LogHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	
	
}

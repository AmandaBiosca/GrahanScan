

public class DequeEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

	public DequeEmptyException() {
	}

	public DequeEmptyException(String message) {
		super(message);
	}

	public DequeEmptyException(Throwable cause) {
		super(cause);
	}

	public DequeEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public DequeEmptyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
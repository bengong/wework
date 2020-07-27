package wework;

public class WeException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8310159703463860482L;

	public WeException() {
		super();
	}

	public WeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WeException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeException(String message) {
		super(message);
	}

	public WeException(Throwable cause) {
		super(cause);
	}
}

package main.exceptions;

public class DiscountException extends GameStoreException {

	public DiscountException(ExceptionMessage messageType) {
		super(messageType);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -6980533924203131179L;

	public DiscountException() {
		super();
	}

	public DiscountException(String message, Throwable cause) {
		super(message, cause);
	}

	public DiscountException(String message) {
		super(message);
	}

	public DiscountException(Throwable cause) {
		super(cause);
	}

}

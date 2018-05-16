package main.exceptions;

public class IllegalRequestGameStoreException extends GameStoreException {

	private static final long serialVersionUID = -713465581030037278L;

	public IllegalRequestGameStoreException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalRequestGameStoreException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalRequestGameStoreException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalRequestGameStoreException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalRequestGameStoreException(ExceptionMessage messagetype) {
		super(messagetype);
		// TODO Auto-generated constructor stub
	}

	public IllegalRequestGameStoreException(ExceptionMessage messagetype, String name) {
		super(messagetype, name);
		// TODO Auto-generated constructor stub
	}

}

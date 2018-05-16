package main.exceptions;

public class GameStoreIOException extends GameStoreException {

	private static final long serialVersionUID = 5751356105577599358L;

	public GameStoreIOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameStoreIOException(ExceptionMessage messageType, String messageName) {
		super(messageType, messageName);
		// TODO Auto-generated constructor stub
	}

	public GameStoreIOException(ExceptionMessage messageType) {
		super(messageType);
		// TODO Auto-generated constructor stub
	}

	public GameStoreIOException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public GameStoreIOException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public GameStoreIOException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}

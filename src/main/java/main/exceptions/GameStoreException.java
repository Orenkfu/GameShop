package main.exceptions;

public class GameStoreException extends Exception {

	private static final long serialVersionUID = -4690695672042540504L;

	public GameStoreException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameStoreException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public GameStoreException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public GameStoreException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public GameStoreException(ExceptionMessage messageType) {
		super(messageType.getValue());
		// TODO Auto-generated constructor stub
	}

	public GameStoreException(ExceptionMessage messageType, String messageName) {
		super(messageType.getValue(messageName));
	}

}

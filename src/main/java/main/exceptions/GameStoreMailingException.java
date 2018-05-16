package main.exceptions;

public class GameStoreMailingException extends GameStoreException {

	private static final long serialVersionUID = 6817080099860844577L;

	public GameStoreMailingException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameStoreMailingException(ExceptionMessage messageType, String messageName) {
		super(messageType, messageName);
		// TODO Auto-generated constructor stub
	}

	public GameStoreMailingException(ExceptionMessage messageType) {
		super(messageType);
		// TODO Auto-generated constructor stub
	}

	public GameStoreMailingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public GameStoreMailingException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public GameStoreMailingException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}

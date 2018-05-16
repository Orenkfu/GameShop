package main.exceptions;

public class EmptyFieldException extends GameStoreException {

	public EmptyFieldException(ExceptionMessage messagetype) {
		super(messagetype);
		// TODO Auto-generated constructor stub
	}

	public EmptyFieldException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyFieldException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmptyFieldException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmptyFieldException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 8350017775119052294L;

}

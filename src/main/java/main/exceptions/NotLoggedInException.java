package main.exceptions;

public class NotLoggedInException extends GameStoreException {

	public NotLoggedInException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotLoggedInException(ExceptionMessage messageType) {
		super(messageType);
		// TODO Auto-generated constructor stub
	}

	public NotLoggedInException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public NotLoggedInException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotLoggedInException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotLoggedInException(ExceptionMessage messagetype, String messageName) {
		super(messagetype.getValue(messageName));
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 4886415029695145692L;

}

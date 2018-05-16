package main.exceptions;

public class EntityNotFoundException extends GameStoreException {


	public EntityNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityNotFoundException(ExceptionMessage messageType, String messageName) {
		super(messageType, messageName);
		// TODO Auto-generated constructor stub
	}

	public EntityNotFoundException(ExceptionMessage messageType) {
		super(messageType);
		// TODO Auto-generated constructor stub
	}

	public EntityNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public EntityNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public EntityNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}

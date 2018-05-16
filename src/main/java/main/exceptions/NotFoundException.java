package main.exceptions;

public class NotFoundException extends GameStoreException {

	private static final long serialVersionUID = -456726464675179305L;

	public NotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(ExceptionMessage messageType, String messageName) {
		super(messageType, messageName);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(ExceptionMessage messageType) {
		super(messageType);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}

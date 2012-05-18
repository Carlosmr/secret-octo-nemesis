package isw2.excepciones;

public class InvalidStateException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidStateException() {
	}

	public InvalidStateException(String arg0) {
		super(arg0);
	}

	public InvalidStateException(Throwable arg0) {
		super(arg0);
	}

	public InvalidStateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}

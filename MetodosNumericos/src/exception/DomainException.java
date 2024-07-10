package exception;

public class DomainException extends NumberFormatException{

	private static final long serialVersionUID = 1L;
	
	public DomainException(String message) {
		super(message);
	}

}

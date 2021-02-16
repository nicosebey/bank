package exceptions;

@SuppressWarnings("serial")
public class InsufficientFunds extends RuntimeException{
	
	public InsufficientFunds() {
		super();
	}
	
	public InsufficientFunds(String message) {
		super(message);
	}

}

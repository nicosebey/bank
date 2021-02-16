package exceptions;

public class InsufficientAccountParams  extends RuntimeException{

	public InsufficientAccountParams() {
		super();
	}
	
	public InsufficientAccountParams(String msg) {
		super(msg);
	}
}

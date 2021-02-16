package exceptions;

public class IlegalAccountDelete  extends RuntimeException{
	
	public IlegalAccountDelete() {
		super();
	}
	
	public IlegalAccountDelete(String msg) {
		super(msg);
	}
}

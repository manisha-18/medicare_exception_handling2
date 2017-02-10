package exceptionHandler;

public class UpdationFailedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3030880351786090677L;

	public UpdationFailedException(String msg){
		super(msg);
	}
}

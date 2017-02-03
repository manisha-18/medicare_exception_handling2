package exceptionHandler;

public class NoContentFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4867940330387597920L;

	public NoContentFoundException(String message){
		super(message);
	}
	
}

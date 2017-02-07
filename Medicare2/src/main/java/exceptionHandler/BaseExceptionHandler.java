package exceptionHandler;

import model.ErrorMessage;

public class BaseExceptionHandler extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3136787083186316191L;

	public BaseExceptionHandler (String msg){
		
		super(msg);
	}
	
	
	
}

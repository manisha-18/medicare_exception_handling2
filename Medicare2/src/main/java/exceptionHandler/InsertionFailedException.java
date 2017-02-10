package exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InsertionFailedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7116490348900013005L;

	public InsertionFailedException(String message){
		super(message);
	}
	
	
	
}

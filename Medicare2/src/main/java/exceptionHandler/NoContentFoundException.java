package exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NoContentFoundException extends BaseExceptionHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4867940330387597920L;

	public NoContentFoundException(String message){
		
		super(message);
	}
	
}

package exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class DataNotFoundException extends BaseExceptionHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6863205537295188348L;
	
	public DataNotFoundException(String message){
		super(message);
	}
}

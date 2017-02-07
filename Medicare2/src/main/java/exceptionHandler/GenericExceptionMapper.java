package exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.ErrorMessage;

@ControllerAdvice
@RestController
public class GenericExceptionMapper {
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(value = NoContentFoundException.class)
	public ErrorMessage handleNoContentFoundException(NoContentFoundException e) {

		ErrorMessage error = new ErrorMessage(HttpStatus.NO_CONTENT, "No content found");

		return error;
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = DataNotFoundException.class)
	public ErrorMessage handleDataNotFoundException(DataNotFoundException e) {
		
		ErrorMessage error=new ErrorMessage(HttpStatus.NOT_FOUND,"Record not found");
		  return error; 
	}

	//////////////////////////////////////////////////////////////////

	

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = InsertionFailedException.class)
	public ErrorMessage handleInsertionFailedExceptionException(InsertionFailedException e) {

		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Insertion Failed");

		return error;
	}
	
	/////////////////////////////////// by default///////////////////////////////

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = Throwable.class)
	public ErrorMessage handleInvalidUriException(Throwable e) {

		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Resource not found");

		return error;
	}
	
}

package exceptionHandler;

import javax.ws.rs.ext.Provider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.ErrorMessage;

@ControllerAdvice
@RestController

public class GenericExceptionMapper {
	

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = InsertionFailedException.class)
	public ErrorMessage handleInsertionFailedException(InsertionFailedException e) {

		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Insertion Failed");

		return error;
	}
	
	

	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//for get request failure
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = DataNotFoundException.class)
	public  ErrorMessage handleDataNotFoundException(DataNotFoundException e) {
		ErrorMessage error= new ErrorMessage(HttpStatus.NOT_FOUND,"Record not found");
		return error;
		
	
	}

	//////////////////////////////////////////////////////////////////

	//for failure of update request
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(value = UpdationFailedException.class)
		public  ErrorMessage handleUpdationFailedException(UpdationFailedException e) {
			ErrorMessage error= new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Could not update the record");
			return error;
			
		
		}

	
	/////////////////////////////////// by default///////////////////////////////

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Throwable.class)
	public ErrorMessage handleInternalServerErrorException(Throwable e) {

		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Internal server error");

		return error;
	}


	
}

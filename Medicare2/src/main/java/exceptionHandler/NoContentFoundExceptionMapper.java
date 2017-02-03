package exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.ErrorMessage;


@RestController
public class NoContentFoundExceptionMapper {

	@ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(value = NoContentFoundException.class)
    public ErrorMessage handleNoContentFoundException(NoContentFoundException e){
    	
			ErrorMessage error=new ErrorMessage(204,"No Content Found");	
        return error;
    }
	
}

package exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.ErrorMessage;



@ControllerAdvice
@RestController
public class GenericExceptionMapper{

    
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Throwable.class)
    public ErrorMessage handleInvalidUriException(Throwable e){
    	
    	ErrorMessage error=new ErrorMessage(500,"INTERNAL_SERVER_ERROR");
    	
        return error;
    }
}

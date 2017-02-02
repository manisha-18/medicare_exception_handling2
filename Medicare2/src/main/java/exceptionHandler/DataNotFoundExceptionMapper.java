package exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.ErrorMessage;

import javax.ws.rs.ext.Provider;

import org.springframework.http.HttpStatus;


@ControllerAdvice
@RestController
public class DataNotFoundExceptionMapper{

    
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DataNotFoundException.class)
    public ErrorMessage handleDataNotFoundException(DataNotFoundException e){
    	
    	ErrorMessage error=new ErrorMessage(404,"NOT_FOUND");
    	
        return error;
    }
   
}
package exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.ErrorMessage;

@RestController
public class DataNotFoundExceptionMapper {
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DataNotFoundException.class)
    public ErrorMessage handleDataNotFoundException(DataNotFoundException e){
    	
    	ErrorMessage error=new ErrorMessage(404,"Record Not Found");
    	
        return error;
    }
}

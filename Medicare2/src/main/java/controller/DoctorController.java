package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exceptionHandler.DataNotFoundException;
import exceptionHandler.InsertionFailedException;
import exceptionHandler.NoContentFoundException;
import model.Doctor;
import model.ErrorMessage;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import service.DoctorService;

@RestController
@RequestMapping(value="medicare/api/doctors")
public class DoctorController {


	@Autowired
	private DoctorService doctorService;
	
		//save doctor entity using POST
		@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public JSONObject insert(@RequestBody Doctor doctor){
		
			return (JSONObject) doctorService.insert(doctor);
		
		}
	
	
		//get all doctors using GET
		@RequestMapping(method=RequestMethod.GET)
		@ResponseBody
		public JSONArray getAllDoctors(){
		
			return doctorService.getAllDoctors();
		
		}
	
	
		//get doctor by id using GET
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		@ResponseBody
		public JSONObject getDoctorById(@PathVariable("id") int id){
		
			return doctorService.getDoctorById(id);
		
		}
		
	
		//update doctor by id using PUT
		@RequestMapping(value="/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
		public void updateDoctor(@RequestBody Doctor doctor){
			
			doctorService.updateDoctor(doctor);
			
		}
		
		//delete a doctor
		@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
		public void deleteDoctor(@PathVariable int id) {
			doctorService.deleteDoctor(id);
		}
		
		//delete all doctors
		@RequestMapping(method=RequestMethod.DELETE)
		public void deleteAllDoctor() {
			doctorService.deleteAllDoctor();
		}
			
//////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(value = InsertionFailedException.class)
	    public ErrorMessage handleInsertionFaliedException(InsertionFailedException e){
	    	
				ErrorMessage error=new ErrorMessage(500,"Insertion Failed");	
	        return error;
	    }
		@ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler(value = DataNotFoundException.class)
	    public ErrorMessage handleDataNotFoundException(DataNotFoundException e){
	    	
	    	ErrorMessage error=new ErrorMessage(404,"Record Not Found");
	    	
	        return error;
	    }
		@ResponseStatus(HttpStatus.NO_CONTENT)
	    @ExceptionHandler(value = NoContentFoundException.class)
	    public ErrorMessage handleNoContentFoundException(NoContentFoundException e){
	    	
				ErrorMessage error=new ErrorMessage(204,"No Content Found");	
	        return error;
	    }
	    
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(value = Throwable.class)
	    public ErrorMessage handleInvalidUriException(Throwable e){
	    	
	    	ErrorMessage error=new ErrorMessage(500,"Internal Server Error");
	    	
	        return error;
	    }
}
	


package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Doctor;
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
		public JSONObject insert(@RequestBody Doctor doctor, HttpServletResponse response){
		
			return (JSONObject) doctorService.insert(doctor, response);
		
		}
	
	
		//get all doctors using GET
		@RequestMapping(method=RequestMethod.GET)
		@ResponseBody
		public JSONArray getAllDoctors(HttpServletResponse response){
		
			return doctorService.getAllDoctors(response);
		
		}
	
	
		//get doctor by id using GET
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		@ResponseBody
		public JSONObject getDoctorById(@PathVariable("id") int id, HttpServletResponse response){
		
			return doctorService.getDoctorById(id, response);
		
		}
		
	
		//update doctor by id using PUT
		@RequestMapping(value="/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public JSONObject updateDoctor(@RequestBody Doctor doctor,@PathVariable("id") int id, HttpServletResponse response){
			
			return doctorService.updateDoctor(doctor,id,response);
			
		}
		
		//delete a doctor
		@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
		public void deleteDoctor(@PathVariable int id, HttpServletResponse response) {
			doctorService.deleteDoctor(id, response);
		}
		
		
		//delete all doctors
		@RequestMapping(method=RequestMethod.DELETE)
		public void deleteAllDoctor(HttpServletResponse response) {
			doctorService.deleteAllDoctor(response);
		}
			


		
		
	   
}
	


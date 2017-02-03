package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.DoctorDao;
import exceptionHandler.DataNotFoundException;
import exceptionHandler.InsertionFailedException;
import exceptionHandler.NoContentFoundException;
import model.Doctor;
import model.ErrorMessage;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service
public class DoctorService {

	
	
	@Autowired
	private DoctorDao doctorDao;

	// insert record of a doctor
	public JSONObject insert(Doctor doctor) {

		JSONObject doc = this.doctorDao.insert(doctor);
		// if insertion is successful
		if (doc.isEmpty()) {
			throw new InsertionFailedException("Insertion failed");
		
		}
		// if insertion was not successful
		else {

			return doc;

		}
	}

	
	
	
	// get all doctors
	public JSONArray getAllDoctors() {

		JSONArray doctors=this.doctorDao.getAllDoctors();
		
		if(doctors.isEmpty()){
			throw new NoContentFoundException("No Content Found");
		}
		
		return doctors;

	}
	
	
	

	// get doctor by id
	public JSONObject getDoctorById(int id) {

		JSONObject doc = doctorDao.getDoctorById(id);

		if (doc.isEmpty()) {
			throw new DataNotFoundException("Record with id " + id + " not found.");
		}

		return doctorDao.getDoctorById(id);

	}
	
	
	

	// update doctor by id using PUT
	public void updateDoctor(Doctor doctor) {

		doctorDao.updateDoctor(doctor);

	}
	
	
	

	// delete a doctor
	public void deleteDoctor(int id) {
		doctorDao.deleteDoctor(id);
	}

	
	
	
	// delete all doctors
	public void deleteAllDoctor() {
		doctorDao.deleteAllDoctor();
	}
}

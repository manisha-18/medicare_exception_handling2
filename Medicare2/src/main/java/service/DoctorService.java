package service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import dao.DoctorDao;
import exceptionHandler.*;
import model.Doctor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service
public class DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	// insert record of a doctor
	public JSONObject insert(Doctor doctor, HttpServletResponse response) {

		JSONObject doc = this.doctorDao.insert(doctor);
		// if insertion is not successful
		if (doc.isEmpty()) {
			response.setStatus(500);
			throw new InsertionFailedException("Insertion failed");

		}
		// if insertion was successful
		else {
			response.setStatus(201);
			return doc;

		}
	}

	// get all doctors
	public JSONArray getAllDoctors(HttpServletResponse response) {

		JSONArray doctors = this.doctorDao.getAllDoctors();

		if (doctors.isEmpty()) {
			response.setStatus(404);
			throw new DataNotFoundException("Not found");
		}
		response.setStatus(200);
		return doctors;

	}

	// get doctor by id
	public JSONObject getDoctorById(int id, HttpServletResponse response) {

		JSONObject doc = doctorDao.getDoctorById(id);

		if (doc.isEmpty()) {
			response.setStatus(404);
			throw new DataNotFoundException("Record not found");
		}
		response.setStatus(200);
		return doctorDao.getDoctorById(id);

	}

	// update doctor by id using PUT
	public JSONObject updateDoctor(Doctor doctor, int id, HttpServletResponse response) {

		int updated = doctorDao.updateDoctor(doctor, id);
		// if updated already existing record
		if (updated == 1) {
			JSONObject job = new JSONObject();
			job.put("statuscode", HttpStatus.OK);
			response.setStatus(200);
			return job;
		}

		// if new record created
		else if (updated == 0) {
			JSONObject job = new JSONObject();
			job.put("statuscode", HttpStatus.CREATED);
			response.setStatus(201);
			return job;
		}

		// operation failed
		else if (updated == -1) {
			response.setStatus(500);
			throw new UpdationFailedException("Could not update the record");

		}
		return null;

	}

	// delete a doctor
	public void deleteDoctor(int id, HttpServletResponse response) {
		boolean deleted = doctorDao.deleteDoctor(id);
		// success
		if (deleted == true)
			response.setStatus(200);
		//if failed
		else
			response.setStatus(500);

	}

	// delete all doctors
	public void deleteAllDoctor(HttpServletResponse response) {
		boolean deleted = doctorDao.deleteAllDoctor();

		// success
		if (deleted == true)
			response.setStatus(200);
		//if failed
		else
			response.setStatus(500);

	}
}

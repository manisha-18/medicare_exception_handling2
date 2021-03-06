package dao;

import org.springframework.stereotype.Component;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import model.Doctor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Component
public class DoctorDao {

	// insert record of a doctor
	public JSONObject insert(Doctor doctor) {

		DBCollection coll = MongoUtil.mongoInit();
		BasicDBObject object = new BasicDBObject();
		object.put("id", doctor.getId());
		object.put("name", doctor.getName());
		object.put("email", doctor.getEmail());
		object.put("specialisation", doctor.getSpecialisation());
		object.put("timeslot", doctor.getTimeslot());
		object.put("experience", doctor.getExperience());
		object.put("contactno", doctor.getContactno());

		JSONObject jobj = new JSONObject();

		// if insertion is successful
		if (coll.insert(object).wasAcknowledged()) {

			jobj.put("id", doctor.getId());
			jobj.put("name", doctor.getName());
			jobj.put("email", doctor.getEmail());
			jobj.put("specialisation", doctor.getSpecialisation());
			jobj.put("timeslot", doctor.getTimeslot());
			jobj.put("experience", doctor.getExperience());
			jobj.put("contactno", doctor.getContactno());

			return jobj;
		}

		// if insertion failed
		else {

			return jobj;
		}

	}

	// get all doctors
	public JSONArray getAllDoctors() {

		DBCollection coll = MongoUtil.mongoInit();
		DBCursor cursor = coll.find();
		JSONArray jsonarray = new JSONArray();

		// if any record is present to show
		if (cursor.next() != null && cursor.count() != 0) {

			while (cursor.hasNext()) {
				BasicDBObject bobj = (BasicDBObject) cursor.next();
				JSONObject jobj = new JSONObject();
				jobj.put("id", bobj.get("id"));
				jobj.put("name", bobj.get("name"));
				jobj.put("email", bobj.get("email"));
				jobj.put("specialisation", bobj.get("specialisation"));
				jobj.put("timeslot", bobj.get("timeslot"));
				jobj.put("experience", bobj.get("experience"));
				jobj.put("contactno", bobj.get("contactno"));
				jsonarray.add(jobj);
			}
			return jsonarray;
		}

		// or else return empty array
		return jsonarray;
	}

	// get doctor by id
	public JSONObject getDoctorById(int id) {

		DBCollection coll = MongoUtil.mongoInit();
		BasicDBObject bobj1 = new BasicDBObject();
		bobj1.append("id", id);
		DBCursor cursor = coll.find(bobj1);

		// if object with given id is not found
		if (cursor == null && cursor.count() == 0) {
			return null;
		}

		// else return the found record
		JSONObject jobj = new JSONObject();

		while (cursor.hasNext()) {
			BasicDBObject bobj2 = (BasicDBObject) cursor.next();
			jobj.put("id", bobj2.get("id"));
			jobj.put("name", bobj2.get("name"));
			jobj.put("email", bobj2.get("email"));
			jobj.put("specialisation", bobj2.get("specialisation"));
			jobj.put("timeslot", bobj2.get("timeslot"));
			jobj.put("experience", bobj2.get("experience"));
			jobj.put("contactno", bobj2.get("contactno"));

		}

		return jobj;

	}

	// update doctor by id
	public int updateDoctor(Doctor doctor, int id) {

	
		DBCollection coll = MongoUtil.mongoInit();
		BasicDBObject queryobj = new BasicDBObject();
		queryobj.put("id", id);
		DBCursor cursor = (DBCursor) coll.find(queryobj);

		// if already a record is present with this id
		// then modify the record
		if (cursor != null && cursor.count() != 0) {

			while (cursor.hasNext()) {
				BasicDBObject bobj = (BasicDBObject) cursor.next();
				bobj.put("name", doctor.getName());
				bobj.put("email", doctor.getEmail());
				bobj.put("specialisation", doctor.getSpecialisation());
				bobj.put("timeslot", doctor.getTimeslot());
				bobj.put("experience", doctor.getExperience());
				bobj.put("contactno", doctor.getContactno());

				// if operation gets completed
				if (coll.update(queryobj, bobj).wasAcknowledged()) {
					return 1;
				}
			}
			// if operation fails
			return -1;
		}

		// if it is a new record then insert it
		else {
			BasicDBObject object = new BasicDBObject();
			object.put("id", id);
			object.put("name", doctor.getName());
			object.put("email", doctor.getEmail());
			object.put("specialisation", doctor.getSpecialisation());
			object.put("timeslot", doctor.getTimeslot());
			object.put("experience", doctor.getExperience());
			object.put("contactno", doctor.getContactno());
			coll.insert(object);

			return 0;
		}
		
	}

	
	
	
	
	// delete a doctor
	public boolean deleteDoctor(int id) {

		DBCollection coll = MongoUtil.mongoInit();
		BasicDBObject queryobj = new BasicDBObject();
		queryobj.put("id", id);
		DBCursor cursor = (DBCursor) coll.find(queryobj);

		while (cursor.hasNext()) {
			BasicDBObject bobj = (BasicDBObject) cursor.next();
			//if deletion was successful
			if(coll.remove(bobj).wasAcknowledged()){
				return true;
			}
		}
		//if deletion failed
		return false;

	}

	
	
	// delete all doctors
	public boolean deleteAllDoctor() {
		DBCollection coll = MongoUtil.mongoInit();
		BasicDBObject bobj = new BasicDBObject();
		
		//if deletion was successful
		if(coll.remove(bobj).wasAcknowledged()){
			return true;
		}
		//if deletion failed
		return false;
	}

}

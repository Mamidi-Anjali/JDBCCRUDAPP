package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	String save(Student student); //Creating a record
	Student findById(Integer sid); //Reading a record
	String updateById(Integer sid,String var,  String value);// Updating a record
	String updatesById(Student student);// Updateing multiple attributes of a single record
	String deleteById(Integer sid); //Deleting a record	
}

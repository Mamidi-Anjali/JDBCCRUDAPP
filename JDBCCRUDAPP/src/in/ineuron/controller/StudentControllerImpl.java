package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	IStudentService stdService;
	
	@Override
	public String save(Student student) {
		stdService  = StudentServiceFactory.getStudentService();
		return stdService.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		stdService  = StudentServiceFactory.getStudentService();
		return stdService.findById(sid);
	}

	@Override
	public String updateById(Integer sid, String var,  String value) {
		stdService  = StudentServiceFactory.getStudentService();
		return stdService.updateById(sid,var,value);
	}

	@Override
	public String deleteById(Integer sid) {
		stdService  = StudentServiceFactory.getStudentService();
		return stdService.deleteById(sid);
	}

	@Override
	public String updatesById(Student student) {
		stdService  = StudentServiceFactory.getStudentService();
		return stdService.updatesById(student);
	}

}

package in.ineuron.factory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static IStudentService studentService = null;
	
	//private because no one should create object from an outside world
	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentService() {
		if(studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;		
	}
}

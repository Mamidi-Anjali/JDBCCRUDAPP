package in.ineuron.factory;

import in.ineuron.controller.IStudentController;
import in.ineuron.controller.StudentControllerImpl;

public class StudentControllerFactory {
	
	private static IStudentController studentController = null;
	//I don't want object of the class to be created directly
	//I don't want object of the class to be created outside
	//only one object should be created.. so singleton
	private StudentControllerFactory() {
		
	}
	
	public static IStudentController getStudentController() {
		if(studentController   == null ) {
			studentController = new StudentControllerImpl();
			
		}
		return studentController;
	}
		
	
}

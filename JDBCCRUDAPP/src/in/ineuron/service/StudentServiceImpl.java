package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {

	IStudentDao stdDao;
	@Override
	public String save(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.findById(sid);
	}

	@Override
	public String updateById(Integer sid,String var,  String value) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateById(sid,var,value);
	}

	@Override
	public String deleteById(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteById(sid);
	}

	@Override
	public String updatesById(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updatesById(student);
	}

}

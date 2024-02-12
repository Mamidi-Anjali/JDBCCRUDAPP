package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	Connection con = null;
	
	@Override
	public String save(Student student) {
		
		String sqlInsertQuery = "insert into student(`name`,`email`,`city`,`country`)values(?,?,?,?)";
		PreparedStatement pstmt=null;
		String status = null;
		try {
			con = JdbcUtil.getConnection();
			
			if(con!=null)
				pstmt =  con.prepareStatement(sqlInsertQuery);
			if(pstmt!=null) {
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getEmail());
				pstmt.setString(3, student.getCity());
				pstmt.setString(4, student.getCountry());
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected ==1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
			
		} catch (SQLException |IOException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		String sqlInsertQuery = "select sid,name,email,city,country from student where sid=?";
		PreparedStatement pstmt=null;
		ResultSet rs = null; 
		Student std = null;
		try {
			con = JdbcUtil.getConnection();
			
			if(con!=null)
				pstmt =  con.prepareStatement(sqlInsertQuery);
			if(pstmt!=null) {
				pstmt.setInt(1, sid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					//copy the resultset data to StudentDTO and transfer to the view
					std = new Student();
					std.setSid(rs.getInt(1));
					std.setName(rs.getString(2));
					std.setEmail(rs.getString(3));
					std.setCity(rs.getString(4));
					std.setCountry(rs.getString(5));
					
				}
			}
			
		} catch (SQLException |IOException e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String updateById(Integer sid,String var,  String value) {
		String sqlUpdateQuery = "update student set "+var+"=? where sid=?";
		PreparedStatement pstmt=null;
		String status = null;
		try {
			con = JdbcUtil.getConnection();
			if(con!=null)
				pstmt =  con.prepareStatement(sqlUpdateQuery);
			if(pstmt!=null) {
				pstmt.setString(1, value);
				pstmt.setInt(2, sid);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected ==1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
		} 
		catch (SQLException |IOException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		String sqlDeleteQuery = "delete from student where sid=?";
		PreparedStatement pstmt=null;
		String status = null;
		try {
			Student std = findById(sid);
			if(std !=null) {
				con = JdbcUtil.getConnection();
				if(con!=null)
					pstmt =  con.prepareStatement(sqlDeleteQuery);
				if(pstmt!=null) {
					pstmt.setInt(1, sid);
					int rowsAffected = pstmt.executeUpdate();
					if(rowsAffected ==1) {
						status = "success";
					}
					else {
						status = "failure";
					}
				}
			}
			else {
				status="not available";
			}
			
		} catch (SQLException |IOException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public String updatesById(Student student) {
		String sqlUpdateQuery = "update student set name=?,email=?,city=?,country=? where sid = ?";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			con = JdbcUtil.getConnection();
			if(con!=null)
				pstmt =  con.prepareStatement(sqlUpdateQuery);
			if(pstmt!=null) {
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getEmail());
				pstmt.setString(3, student.getCity());
				pstmt.setString(4, student.getCountry());
				pstmt.setInt(5, student.getSid());
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected ==1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}	
		} 
		catch (SQLException |IOException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

}

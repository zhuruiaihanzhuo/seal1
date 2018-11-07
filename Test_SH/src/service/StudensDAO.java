package service;

import java.util.List;

import entity.Students;

public interface StudensDAO {
	
	public List<Students> queryAllStudents();
	public Students queryStudentsBySid(String Sid);
	public boolean addStudents(Students s);
	public boolean updateStudent(Students s);
	public boolean deleteStudents(String sid); 
	public String  getNewSid();
}

package service.impl;

import java.util.List;

import org.junit.Test;

import entity.Students;
import service.StudensDAO;

public class TestStudentsDAOImpl {
	
	@Test
	public void testStudents(){
		StudensDAO studensDAO=new StudensDAOImpl();
		List<Students> list =studensDAO.queryAllStudents();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testNewSid(){
		StudensDAO s=new StudensDAOImpl();
		System.out.println(s.getNewSid());
	}
	@Test
	public void testaddStudent(){
		
		
	}
}

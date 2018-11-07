package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;

import service.StudensDAO;
import service.impl.StudensDAOImpl;
import entity.Students;

public class StudentsAction extends SuperAction{

	public String query(){
		
		StudensDAO studensDAO=new StudensDAOImpl();
		List<Students> list =studensDAO.queryAllStudents();
		if(list!=null){
			session.setAttribute("students_list", list);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
		return "Students_query_success";
	}
	public String delete(){
		StudensDAO sDao=new StudensDAOImpl();
		String sid=request.getParameter("sid");
		sDao.deleteStudents(sid);
		return "delete_success";
		
	}
	public String add() throws Exception{
		Students s=new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		s.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		StudensDAO sdao=new StudensDAOImpl();
		sdao.addStudents(s);
		return "add_success";
		
				
	}
	public String modify(){
		Students s=new Students();
		StudensDAO sdao=new StudensDAOImpl();
		String sid=request.getParameter("sid");
		s=sdao.queryStudentsBySid(sid);
		session.setAttribute("modify_students", s);
		
		return "modify_success";
	}
	public String save() throws Exception{
		Students s=new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		s.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		StudensDAO sdao=new StudensDAOImpl();
		sdao.updateStudent(s);
		return "save_success";
	}
	
}

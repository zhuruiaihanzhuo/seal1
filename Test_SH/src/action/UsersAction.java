package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UserDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import freemarker.core.ReturnInstruction.Return;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Users user=new Users();
	public String login(){
	
		UsersDAO udao=new UserDAOImpl();
		System.out.println(user.getPassword());
		if (udao.usersLogin(user)) {
			session.setAttribute("loginUserName", user.getUsername());
			System.out.println(user.getUsername());
			return "login_success";
			
		} else {
				return "failure";
		}
	}
	@SkipValidation
	//用户注销
	public String logout(){
		if (session.getAttribute("loginUserName")!=null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	public Users getModel() {
		
		return this.user;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if ("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if (user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码不能小于6位");
		}
	}



}

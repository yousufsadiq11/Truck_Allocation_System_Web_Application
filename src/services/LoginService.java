package services;

import bean.Login;
import dao.LoginDAO;

public class LoginService {
	public int checkLogin(Login obj) {
		LoginDAO ld = new LoginDAO();
		return ld.checkLogin(obj);
	}
}

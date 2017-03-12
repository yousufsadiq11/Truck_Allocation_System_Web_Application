package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.LoginService;
import bean.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Login lg = new Login();
		lg.setUserId(request.getParameter("userId"));
		lg.setPassword(request.getParameter("password"));
		LoginService obj = new LoginService();
		int rs = obj.checkLogin(lg);// TODO Auto-generated method stub
		HttpSession sess = request.getSession(true);
		sess.setAttribute("obj", lg);
		if (rs == -1) {
			response.sendRedirect("home.jsp");
		} else {
			if (((Login) sess.getAttribute("obj")).getRole().equals("unithead"))
				response.sendRedirect("UnitHeadController");
			if (((Login) sess.getAttribute("obj")).getRole().equals("storestaff")) {
				response.sendRedirect("StoreStaff");
			}
			if (((Login) sess.getAttribute("obj")).getRole().equals("dcstaff")) {
				response.sendRedirect("DCStaff");
			}
			if (((Login) sess.getAttribute("obj")).getRole().equals("postaff")) {
				sess.setAttribute("poStaff", sess.getAttribute("obj"));
				sess.removeAttribute("obj");
				response.sendRedirect("POStaffController");
			}
		}
	}

}

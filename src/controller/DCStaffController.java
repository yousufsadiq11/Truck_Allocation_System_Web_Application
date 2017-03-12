package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.DCStaffService;
import bean.DCStaff;
import bean.Login;

/**
 * Servlet implementation class DCStaff
 */
@WebServlet("/DCStaff")
public class DCStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DCStaffController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
		if (sess.getAttribute("obj") != null) {
			DCStaff ss = new DCStaff();
			Login lg = (Login) sess.getAttribute("obj");
			ss.setId(lg.getUserId());
			DCStaffService sss = new DCStaffService();
			int rs = sss.checkStaffDC(ss);
			if (rs == 1) {
				System.out.println("DC Staff");
				sess.removeAttribute("obj");
				sess.setAttribute("dcStaff", ss);
				response.sendRedirect("DCController");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.StoreStaffService;
import bean.Login;
import bean.StoreStaff;

/**
 * Servlet implementation class StoreStaff
 */
@WebServlet("/StoreStaff")
public class StoreStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreStaffController() {
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
			StoreStaff ss = new StoreStaff();
			Login lg = (Login) sess.getAttribute("obj");
			ss.setId(lg.getUserId());
			StoreStaffService sss = new StoreStaffService();
			int rs = sss.checkStaffStore(ss);
			if (rs == 1) {
				System.out.println("Store Staff");
				sess.removeAttribute("obj");
				sess.setAttribute("storeStaff", ss);
				response.sendRedirect("StoreController");
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

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.UnitHeadService;
import bean.Login;
import bean.UnitHead;

/**
 * Servlet implementation class UnitHeadController
 */
@WebServlet("/UnitHeadController")
public class UnitHeadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UnitHeadController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("UNIT HEAD PAGE");

		HttpSession sess = request.getSession(true);

		if (sess.getAttribute("obj") != null) {
			UnitHead uh1 = new UnitHead();
			Login login = (Login) sess.getAttribute("obj");
			System.out.println("first if");
			uh1.setuId(login.getUserId());
			UnitHeadService uhs = new UnitHeadService();

			uh1 = uhs.checkUnitHead(uh1);
			if (uh1 != null) {
				System.out.println("Unit Head");
				sess.removeAttribute("obj");
				sess.setAttribute("unitHead", uh1);
				response.sendRedirect("aaa");
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

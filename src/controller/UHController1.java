package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DCDetail;
import bean.DCStore;
import bean.UnitHead;
import bean.UnitHeadProduct;
import bean.Vendor;
import services.UHService;

/**
 * Servlet implementation class UHController
 */
public class UHController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UHController1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Hello");
		HttpSession sess = request.getSession(true);
		UHService uhs1 = new UHService();
		if (sess.getAttribute("unitHead") != null) {
			UnitHead obj = (UnitHead) sess.getAttribute("unitHead");
			String action = request.getParameter("action");
			if (action == null) {
				UnitHead uh2 = uhs1.getUHDetail(obj.getuId());
				request.setAttribute("unit", uh2);
				RequestDispatcher rd = request.getRequestDispatcher("UnitHeadHome.jsp");
				rd.forward(request, response);
			} else if (action.equals("viewDCs")) {
				ArrayList<DCDetail> dc1 = uhs1.getDCDetail();
				request.setAttribute("DCs", dc1);
				RequestDispatcher rd1 = request.getRequestDispatcher("ViewDCs.jsp");
				rd1.forward(request, response);
			} else if (action.equals("viewStores")) {
				ArrayList<DCStore> st1 = uhs1.getStoreDetails();
				request.setAttribute("Stores", st1);
				RequestDispatcher rd1 = request.getRequestDispatcher("ViewStores.jsp");
				rd1.forward(request, response);
			} else if (action.equals("viewProducts")) {
				ArrayList<UnitHeadProduct> p1 = uhs1.getProductDetails();
				request.setAttribute("Products", p1);
				RequestDispatcher rd1 = request.getRequestDispatcher("ViewProducts.jsp");
				rd1.forward(request, response);
			} else if (action.equals("viewVendors")) {
				ArrayList<Vendor> va = uhs1.getVendorDetails();
				request.setAttribute("Vendors", va);
				RequestDispatcher rd1 = request.getRequestDispatcher("ViewVendors.jsp");
				rd1.forward(request, response);
			} else if (action.equals("viewPOs")) {
				// ArrayList<PurchaseOrder> poa=uhs1.getPODetails();
				// request.setAttribute("POs",poa);
				RequestDispatcher rd1 = request.getRequestDispatcher("ViewPOs.jsp");
				rd1.forward(request, response);
			} else if (action.equals("logout")) {
				sess.removeAttribute("unitHead");
				response.sendRedirect("home.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
		UHService uhs2 = new UHService();
		if (sess.getAttribute("unitHead") != null) {
			UnitHead obj = (UnitHead) sess.getAttribute("unitHead");
			String action = request.getParameter("action");
			if (action.equals("addProducts")) {
				UnitHeadProduct uhp = new UnitHeadProduct();
				uhp.setpId(request.getParameter("pId"));
				uhp.setpName(request.getParameter("pName"));
				uhp.setpDetail(request.getParameter("pDesc"));

				int rs = uhs2.addProducts(uhp);
				if (rs == 1) {
					sess.setAttribute("msg", "Successfully added new product");
					response.sendRedirect("UHController1");
				} else {
					sess.setAttribute("error", "Product is not added");
					response.sendRedirect("AddProducts.jsp");
				}
			} else if (action.equals("addVendors")) {
				Vendor v = new Vendor();
				v.setVid(request.getParameter("vId"));
				v.setVname(request.getParameter("vName"));
				v.setVadd(request.getParameter("vAdd"));

				int rs = uhs2.addVendors(v);
				if (rs == 1) {
					sess.setAttribute("msg", "Successfully added new vendor");
					response.sendRedirect("UHController1");
				} else {
					sess.setAttribute("error", "Vendor is not added");
					response.sendRedirect("AddVendors.jsp");
				}

			}

		}
	}

}

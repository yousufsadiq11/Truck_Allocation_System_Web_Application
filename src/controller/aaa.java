package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.DCDetail;
import bean.DCStore;
import bean.POProduct;
import bean.PurchaseOrder;
import bean.UnitHead;
import bean.UnitHeadProduct;
import bean.Vendor;
import services.UHService;

/**
 * Servlet implementation class aaa
 */
@WebServlet("/aaa")
public class aaa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public aaa() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("a;lsfklafasldkf");// TODO Auto-generated method stub
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
			} else if (action.equals("ViewNewPOS")) {
				ArrayList<PurchaseOrder> poa = uhs1.getPODetails();
				sess.setAttribute("POs", poa);
				response.sendRedirect("NewPOs.jsp");
			} else if (action.equals("approvedPOS")) {
				ArrayList<PurchaseOrder> poa = uhs1.getPODetails();
				sess.setAttribute("POs", poa);
				response.sendRedirect("ApprovedPOs.jsp");
			} else if (action.equals("logout")) {
				sess.removeAttribute("unitHead");
				response.sendRedirect("home.jsp");
			} else if (action.equals("showPOProduct")) {
				String poid = request.getParameter("poid");
				System.out.println(poid);
				ArrayList<POProduct> pobj = uhs1.showPOProductById(poid);
				request.setAttribute("product", pobj);
				RequestDispatcher rd = request.getRequestDispatcher("ViewPOProducts.jsp");
				rd.forward(request, response);
			} else if (action.equals("approvePO")) {
				String poid = request.getParameter("poid");
				String msg = uhs1.approvePO(poid);
				sess.setAttribute("msg", msg);
				response.sendRedirect("NewPOs.jsp");
			} else if (action.equals("addNewProductId")) {
				System.out.println("ee");
				String pid = uhs1.getUniqueProductId();
				System.out.println("en " + pid);
				request.setAttribute("pid", pid);
				RequestDispatcher rd = request.getRequestDispatcher("AddProducts1.jsp");
				rd.forward(request, response);
			} else if (action.equals("addNewVendorId")) {
				String vid = uhs1.getUniqueVendorId();
				request.setAttribute("vid", vid);
				RequestDispatcher rd = request.getRequestDispatcher("AddVendors.jsp");
				rd.forward(request, response);
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
					response.sendRedirect("aaa");
				} else {
					sess.setAttribute("error", "Product is not added");
					response.sendRedirect("AddProducts1.jsp");
				}
			} else if (action.equals("addVendors")) {
				Vendor v = new Vendor();
				v.setVid(request.getParameter("vId"));
				v.setVname(request.getParameter("vName"));
				v.setVadd(request.getParameter("vAdd"));

				int rs = uhs2.addVendors(v);
				if (rs == 1) {
					sess.setAttribute("msg", "Successfully added new vendor");
					response.sendRedirect("aaa");
				} else {
					sess.setAttribute("error", "Vendor is not added");
					response.sendRedirect("AddVendors.jsp");
				}

			}

		}
	}

}

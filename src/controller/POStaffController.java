package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.DCService;
import services.POService;
import services.UHService;
import bean.DCDetail;
import bean.DCStore;
import bean.Login;
import bean.PO;
import bean.POProduct;
import bean.Product;
import bean.PurchaseOrder;
import bean.Vendor;

import java.beans.*;

/**
 * Servlet implementation class POStaffController
 */
@WebServlet("/POStaffController")
public class POStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public POStaffController() {
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
		DCService ds = new DCService();
		UHService uhs1 = new UHService();
		if (sess.getAttribute("poStaff") != null) {
			Login lg = (Login) sess.getAttribute("poStaff");
			String action = request.getParameter("action");
			if (action == null) {
				System.out.println("ppp");
				response.sendRedirect("POStaffPage.jsp");
			} else if (action.equals("logout")) {
				sess.removeAttribute("poStaff");
				response.sendRedirect("home.jsp");
			} else if (action.equals("viewPOs")) {
				ArrayList<PurchaseOrder> poa = uhs1.getPODetails();
				sess.setAttribute("POs", poa);
				response.sendRedirect("ViewPOPagePOStaff.jsp");
			} else if (action.equals("viewDC")) {
				ArrayList<DCDetail> dc1 = uhs1.getDCDetail();
				request.setAttribute("DCs", dc1);
				RequestDispatcher rd1 = request.getRequestDispatcher("ViewDCPagePOStaff.jsp");
				rd1.forward(request, response);
			} else if (action.equals("viewStore")) {
				ArrayList<DCStore> st1 = uhs1.getStoreDetails();
				request.setAttribute("Stores", st1);
				RequestDispatcher rd1 = request.getRequestDispatcher("ViewStorePagePOStaff.jsp");
				rd1.forward(request, response);
			} else if (action.equals("generatePO")) {
				ArrayList<DCDetail> dc1 = uhs1.getDCDetail();
				request.setAttribute("DCs", dc1);
				RequestDispatcher rd1 = request.getRequestDispatcher("POGenerationPOStaff.jsp");
				rd1.forward(request, response);
			} else if (action.equals("generateSPO")) {
				ArrayList<DCStore> st1 = uhs1.getStoreDetails();
				request.setAttribute("Stores", st1);
				RequestDispatcher rd1 = request.getRequestDispatcher("StorePOGenerationPOStaff.jsp");
				rd1.forward(request, response);
			} else if (action.equals("DCID")) {
				String dcid = request.getParameter("dcid");
				ArrayList<Vendor> vobj = ds.getAllVendor();
				ArrayList<Product> pp = ds.getProductDetail(dcid);
				request.setAttribute("dcid", dcid);
				request.setAttribute("vendor", vobj);
				request.setAttribute("product", pp);
				request.setAttribute("pid", ds.getUniquePOID());
				RequestDispatcher rd = request.getRequestDispatcher("POGenerationPage11.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("POStaffPage.jsp");
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
		DCService ds = new DCService();
		UHService uhs1 = new UHService();
		if (sess.getAttribute("poStaff") != null) {
			Login lg = (Login) sess.getAttribute("poStaff");
			String action = request.getParameter("action");
			if (action == null) {
				System.out.println("ppp");
				response.sendRedirect("POStaffPage.jsp");
			} else if (action.equals("addDCPO")) {
				PO pobj = new PO();
				pobj.setPoid(request.getParameter("poid"));
				String pattern = "12-11-2015";
				pobj.setGdate(new SimpleDateFormat(pattern).format(new Date()).toString());
				pobj.setVid(request.getParameter("vid"));
				pobj.setEdate(request.getParameter("edd") + "-" + request.getParameter("emm") + "-"
						+ request.getParameter("eyyyy"));
				pobj.setDcid(request.getParameter("dcid"));
				pobj.setDts("1");
				pobj.setShid(request.getParameter("dcid"));
				System.out.println(new SimpleDateFormat(pattern).format(new Date()).toString() + "   "
						+ request.getParameter("edd") + request.getParameter("emm") + request.getParameter("eyyyy"));
				ArrayList<POProduct> temp = new ArrayList<POProduct>();
				String check[] = request.getParameterValues("check");

				if (check == null) {
					System.out.println("Please select any product in po");
					sess.setAttribute("msg", "Please select any product in po");
					response.sendRedirect("DCController?action=poGenerate");
				} else {
					for (String ch : check) {
						POProduct poObj = new POProduct();
						poObj.setPid(request.getParameter("pid" + ch));
						poObj.setPoid(request.getParameter("poid"));
						poObj.setOrQuantity(Integer.parseInt(request.getParameter("quantity" + ch)));
						poObj.setUnit(Double.parseDouble(request.getParameter("unit" + ch)));
						poObj.setTotal(Integer.parseInt(request.getParameter("quantity" + ch))
								* Double.parseDouble(request.getParameter("unit" + ch)));
						temp.add(poObj);
					}

					POService ps = new POService();
					if (ps.addPOProduct(temp) == 0) {
						System.out.println("Product not add");
						sess.setAttribute("msg", "Error to add product");
						response.sendRedirect("PSStaffController?action=generatePO");
					}
					pobj.setStatus("g");
					String msg = ps.addPO(pobj);
					if (msg != null) {
						sess.setAttribute("msg", msg);
						response.sendRedirect("POStaffController");
					}
					System.out.println("234");
				}
			}
		}

	}
}

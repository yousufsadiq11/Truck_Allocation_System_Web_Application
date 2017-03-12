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
import services.LoginService;
import services.POService;
import services.StoreService;
import bean.DCStore;
import bean.Login;
import bean.PO;
import bean.POProduct;
import bean.Product;
import bean.StoreStaff;
import bean.Vendor;

/**
 * Servlet implementation class StoreController
 */
@WebServlet("/StoreController")
public class StoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int po = 2340;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
		StoreStaff obj = (StoreStaff) sess.getAttribute("storeStaff");
		DCService ds = new DCService();
		System.out.println(obj.getId() + "   " + obj.getDcid() + "   " + obj.getSid());
		if (sess.getAttribute("storeStaff") != null) {
			String action = request.getParameter("action");
			StoreService ss = new StoreService();
			if (action == null) {
				DCStore detail = ss.getStoreDetail(obj.getSid(), obj.getDcid());
				request.setAttribute("StoreDetail", detail);
				RequestDispatcher rd = request.getRequestDispatcher("StorePage.jsp");
				rd.forward(request, response);
			} else if (action.equals("showProduct")) {
				ArrayList<Product> pp = ss.getAllStoreProductDetail(obj.getSid(), obj.getDcid());
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("StoreProductViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("addNewProduct")) {
				ArrayList<Product> pp = ss.getAllNewProductDetail(obj.getSid(), obj.getDcid());// find
																								// only
																								// those
																								// product
																								// which
																								// are
																								// in
																								// dc
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("AddNewProductStoreViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("addStoreProduct")) {
				Product pobj = new Product();
				pobj.setPid(request.getParameter("pid"));
				pobj.setAvailableQuantity(Integer.parseInt(request.getParameter("q")));
				pobj.setTh(Integer.parseInt(request.getParameter("th")));
				System.out.println("add con");
				String msg = ss.addNewProductToStore(obj.getSid(), obj.getDcid(), pobj);
				System.out.println("add pro");
				sess.setAttribute("msg", msg);
				response.sendRedirect("StoreController?action=addNewProduct");
			} else if (action.equals("updateProductDetail")) {
				ArrayList<Product> pp = ss.getAllStoreProductDetail(obj.getSid(), obj.getDcid());
				System.out.println("up1");
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("UpdateStoreProductViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("updateProductQuantity")) {// left
				String pid = request.getParameter("pid");
				int availableQuantity = Integer.parseInt(request.getParameter("quantity"));
				int th = Integer.parseInt(request.getParameter("th"));
				String msg = ss.updateStoreProductQuantity(obj.getSid(), obj.getDcid(), pid, availableQuantity, th);
				System.out.println(msg);
				sess.setAttribute("msg", msg);
				response.sendRedirect("StoreController");
			} else if (action.equals("showThProduct")) {
				ArrayList<Product> pp = ss.getUnderThProductDetail(obj.getSid(), obj.getDcid());
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("UnderThProductStoreViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("logout")) {
				sess.removeAttribute("StoreStaff");
				response.sendRedirect("home.jsp");
			} else if (action.equals("poGenerate")) {
				ArrayList<Vendor> vobj = ds.getAllVendor();
				ArrayList<Product> pp = ss.getAllStoreProductDetail(obj.getSid(), obj.getDcid());
				request.setAttribute("vendor", vobj);
				request.setAttribute("product", pp);
				request.setAttribute("pid", ds.getUniquePOID());
				RequestDispatcher rd = request.getRequestDispatcher("StorePOGeneration.jsp");
				rd.forward(request, response);
			} else if (action.equals("DeleteDCStorePage")) {
				DCStore detail = ss.getStoreDetail(obj.getSid(), obj.getDcid());
				ArrayList<Product> pp = ss.getAllStoreProductDetail(obj.getSid(), obj.getDcid());
				System.out.println(pp.size());

				request.setAttribute("StoreDeleteDetail", detail);
				RequestDispatcher rd = request.getRequestDispatcher("DeleteStorePage.jsp");
				rd.forward(request, response);

			} else if (action.equals("addNewStoreId")) {
				String sid = ds.getUniqueStoreID(obj.getDcid());
				String id = ds.getUniqueStoreUserID();
				request.setAttribute("sid", sid);
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("AddSStore.jsp");
				rd.forward(request, response);
			}

		} /*
			 * else if (action.equals("updateProductQuantity")) {//left String
			 * pid = request.getParameter("pid"); int availableQuantity =
			 * Integer.parseInt(request .getParameter("quantity")); int th =
			 * Integer.parseInt(request.getParameter("th")); String msg =
			 * ss.updateProductQuantity(pid, availableQuantity, th);
			 * System.out.println(msg); request.setAttribute("msg", msg);
			 * ArrayList<Product> pp = ds.getProductDetail(obj.getDcId());
			 * request.setAttribute("products", pp); RequestDispatcher rd =
			 * request .getRequestDispatcher("UpdateProductViewPage.jsp");
			 * rd.forward(request, response); } else if
			 * (action.equals("showThProduct")) { ArrayList<Product> pp =
			 * ss.getUnderThProductDetail(obj.getSid(),obj .getDcid());
			 * request.setAttribute("products", pp); RequestDispatcher rd =
			 * request .getRequestDispatcher("UnderThProductStoreViewPage.jsp");
			 * rd.forward(request, response); } else if
			 * (action.equals("addNewProduct")) { ArrayList<Product> pp =
			 * ss.getAllDCProductDetail(obj.getDcid());//find only those product
			 * which are in dc request.setAttribute("products", pp);
			 * RequestDispatcher rd = request
			 * .getRequestDispatcher("AddNewProductStoreViewPage.jsp");
			 * rd.forward(request, response); } else if
			 * (action.equals("addDCProduct")) { Product pobj = new Product();
			 * pobj.setPid(request.getParameter("pid"));
			 * pobj.setAvailableQuantity(Integer.parseInt(request
			 * .getParameter("q")));
			 * pobj.setTh(Integer.parseInt(request.getParameter("th"))); String
			 * msg = ss.addNewProduct(obj.getSid(),obj.getDcid(), pobj);
			 * request.setAttribute("msg", msg); ArrayList<Product> pp =
			 * ds.getAllProductDetail(obj.getSid(),obj.getDcId());
			 * request.setAttribute("products", pp); RequestDispatcher rd =
			 * request .getRequestDispatcher("AddNewProductStoreViewPage.jsp");
			 * rd.forward(request, response); } else if
			 * (action.equals("logout")) { sess.removeAttribute("StoreStaff");
			 * response.sendRedirect("home.jsp"); } else if
			 * (action.equals("poGenerate")) { ArrayList<Vendor> vobj =
			 * ds.getAllVendor(); ArrayList<Product> pp =
			 * ss.getProductDetail(obj.getSid(),obj.getDcid());
			 * request.setAttribute("vendor", vobj);
			 * request.setAttribute("product", pp); request.setAttribute("pid",
			 * "po" + po); RequestDispatcher rd = request
			 * .getRequestDispatcher("POGenerateStorePage.jsp");
			 * rd.forward(request, response); } System.out.println(obj.getId() +
			 * "  " + obj.getDcid()); } else {
			 * response.sendRedirect("home.jsp"); }
			 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DCService ds = new DCService();
		HttpSession sess = request.getSession(true);
		LoginService ls = new LoginService();
		StoreService ss1 = new StoreService();
		if (sess.getAttribute("storeStaff") != null) {
			StoreStaff obj = (StoreStaff) sess.getAttribute("storeStaff");
			String action = request.getParameter("action");
			if (action == null) {
				DCStore detail = ss1.getStoreDetail(obj.getSid(), obj.getDcid());
				request.setAttribute("StoreDetail", detail);
				RequestDispatcher rd = request.getRequestDispatcher("StorePage.jsp");
				rd.forward(request, response);
			} else if (action.equals("addStore")) {
				DCStore dcs = new DCStore();
				dcs.setSid(request.getParameter("sId"));
				dcs.setDcId(obj.getDcid());
				dcs.setSphone(request.getParameter("sPhone"));
				dcs.setsManager(request.getParameter("mName"));
				dcs.setAddress1(request.getParameter("add1"));
				dcs.setAddress2(request.getParameter("add2"));
				dcs.setCity(request.getParameter("city"));
				dcs.setPin(request.getParameter("pin"));
				dcs.setState(request.getParameter("state"));
				dcs.setLandmart(request.getParameter("landmark"));
				Login lg = new Login();
				lg.setUserId(request.getParameter("id"));
				lg.setPassword(request.getParameter("pass"));
				lg.setRole("storestaff");
				StoreStaff ss = new StoreStaff();
				ss.setDcid(obj.getDcid());
				ss.setId(request.getParameter("id"));
				ss.setSid(request.getParameter("sId"));
				int rs = ds.addStore(dcs, lg, ss);
				if (rs == 1) {
					sess.setAttribute("msg", "Successfully added new Store");
					response.sendRedirect("StoreController");
				} else {
					sess.setAttribute("error", "Wrong dc staff id or dc id");
					response.sendRedirect("AddSStore.jsp");
				}
			} else if (action.equals("po")) {
				PO pobj = new PO();
				pobj.setPoid(request.getParameter("poid"));
				String pattern = "12-11-2015";
				pobj.setGdate(new SimpleDateFormat(pattern).format(new Date()).toString());
				pobj.setVid(request.getParameter("vid"));
				pobj.setEdate(request.getParameter("edd") + "-" + request.getParameter("emm") + "-"
						+ request.getParameter("eyyyy"));
				pobj.setDcid(obj.getDcid());
				pobj.setDts("1");
				pobj.setShid(obj.getSid());
				System.out.println(new SimpleDateFormat(pattern).format(new Date()).toString() + "   "
						+ request.getParameter("edd") + request.getParameter("emm") + request.getParameter("eyyyy"));
				ArrayList<POProduct> temp = new ArrayList<POProduct>();
				String check[] = request.getParameterValues("check");

				if (check == null) {
					System.out.println("Please select any product in po");
					sess.setAttribute("msg", "Please select any product in po");
					response.sendRedirect("StoreController?action=poGenerate");
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
						response.sendRedirect("StoreController?action=poGenerate");
					}
					po++;
					pobj.setStatus("s");
					String msg = ps.addPO(pobj);
					if (msg != null) {
						sess.setAttribute("msg", msg);
						response.sendRedirect("StoreController");
					}
					System.out.println("234");
				}
			} else if ("DeleteTheStores".equals(action)) {

				StoreStaff dcs = new StoreStaff();
				String Sid = request.getParameter("sid");
				String Dcid = (obj.getDcid());
				Product p = new Product();
				StoreService ssc = new StoreService();
				String msg = ssc.deleteStoreProduct(p, Sid, Dcid);
				if (msg != null) {
					sess.setAttribute("msg", "Deletd done Successfully");
					response.sendRedirect("StorePage.jsp");

				}

				else {
					sess.setAttribute("msg", "Deletd not  done Successfully");
				}

			}
		}
	}

}

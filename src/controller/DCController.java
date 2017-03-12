package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.DCService;
import services.POService;
import bean.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Servlet implementation class DCController
 */
@WebServlet("/DCController")
public class DCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DCController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private static int po = 1000;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
		DCService ds = new DCService();
		if (sess.getAttribute("dcStaff") != null) {
			DCStaff obj = (DCStaff) sess.getAttribute("dcStaff");
			String action = request.getParameter("action");
			if (action == null) {
				DCDetail detail = ds.getDCDetail(obj.getDcId());
				request.setAttribute("dcDetail", detail);
				RequestDispatcher rd = request.getRequestDispatcher("DCPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("showProduct")) {
				ArrayList<Product> pp = ds.getProductDetail(obj.getDcId());
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("DCProductViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("viewStore")) {
				ArrayList<DCStore> dcs = ds.getStoreDetail(obj.getDcId());
				request.setAttribute("stores", dcs);
				RequestDispatcher rd = request.getRequestDispatcher("DCStoreViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("updateProductDetail")) {
				ArrayList<Product> pp = ds.getProductDetail(obj.getDcId());
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("UpdateProductViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("updateProductQuantity")) {
				String pid = request.getParameter("pid");
				int availableQuantity = Integer.parseInt(request.getParameter("quantity"));
				int th = Integer.parseInt(request.getParameter("th"));
				String msg = ds.updateProductQuantity(pid, obj.getDcId(), availableQuantity, th);
				System.out.println(msg);
				request.setAttribute("msg", msg);
				ArrayList<Product> pp = ds.getProductDetail(obj.getDcId());
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("UpdateProductViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("showThProduct")) {
				ArrayList<Product> pp = ds.getUnderThProductDetail(obj.getDcId());
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("UnderThProductViewPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("addNewProduct")) {
				ArrayList<Product> pp = ds.getAllProductDetail(obj.getDcId());
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("AddNewProductViewPage1.jsp");
				rd.forward(request, response);
			} else if (action.equals("addDCProduct")) {
				Product pobj = new Product();
				pobj.setPid(request.getParameter("pid"));
				pobj.setAvailableQuantity(Integer.parseInt(request.getParameter("q")));
				pobj.setTh(Integer.parseInt(request.getParameter("th")));
				String msg = ds.addNewProduct(obj.getDcId(), pobj);
				request.setAttribute("msg", msg);
				ArrayList<Product> pp = ds.getAllProductDetail(obj.getDcId());
				request.setAttribute("products", pp);
				RequestDispatcher rd = request.getRequestDispatcher("AddNewProductViewPage1.jsp");
				rd.forward(request, response);
			} else if (action.equals("logout")) {
				sess.removeAttribute("dcStaff");
				response.sendRedirect("home.jsp");
			} else if (action.equals("poGenerate")) {
				ArrayList<Vendor> vobj = ds.getAllVendor();
				ArrayList<Product> pp = ds.getProductDetail(obj.getDcId());
				request.setAttribute("vendor", vobj);
				request.setAttribute("product", pp);
				request.setAttribute("pid", ds.getUniquePOID());
				RequestDispatcher rd = request.getRequestDispatcher("POGeneratePage.jsp");
				rd.forward(request, response);
			} else if (action.equals("DeleteDCStorePage")) {
				ArrayList<DCStore> details = ds.getStoreDetail(obj.getDcId());
				System.out.println(details.size());
				request.setAttribute("dcDetail", details);
				RequestDispatcher rd = request.getRequestDispatcher("DeleteDCStorePage.jsp");
				rd.forward(request, response);

			} else if (action.equals("Update")) {
				ArrayList<DCStore> details = ds.getStoreDetail(obj.getDcId());
				System.out.println(details.size());
				request.setAttribute("dcDetail", details);
				RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
				rd.forward(request, response);

			} else if (action.equals("storeGeneratedPOs")) {
				ArrayList<PurchaseOrder> pobj = ds.getStoreGenPOs();
				sess.setAttribute("SPOs", pobj);
				RequestDispatcher rd = request.getRequestDispatcher("SGenPOsPage.jsp");
				rd.forward(request, response);
			} else if (action.equals("approvePO")) {
				String poid = request.getParameter("poid");
				String msg = ds.approvePO(poid);
				sess.setAttribute("msg", msg);
				response.sendRedirect("SGenPOsPage.jsp");
			} else if (action.equals("storeApprovedPOs")) {
				ArrayList<PurchaseOrder> pobj = ds.getStoreAppPOs();
				sess.setAttribute("SPOs", pobj);
				response.sendRedirect("SAppPOs.jsp");
			} else if (action.equals("addNewDCID")) {
				String dcid = ds.getUniqueDCID();
				String id = ds.getUniqueDCUserID();
				request.setAttribute("dcid", dcid);
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("AddDC.jsp");
				rd.forward(request, response);
			} else if (action.equals("addNewStoreId")) {
				String sid = ds.getUniqueStoreID(obj.getDcId());
				String id = ds.getUniqueStoreUserID();
				request.setAttribute("sid", sid);
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("AddStore.jsp");
				rd.forward(request, response);
			}
			System.out.println(obj.getId() + "  " + obj.getDcId());
		} else {
			response.sendRedirect("home.jsp");
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
		/*
		 * DCStaffService dss = new DCStaffService(); LoginService ls = new
		 * LoginService();
		 */
		if (sess.getAttribute("dcStaff") != null) {
			DCStaff obj = (DCStaff) sess.getAttribute("dcStaff");
			String action = request.getParameter("action");
			if (action.equals("addDC")) {
				DCDetail dc = new DCDetail();
				dc.setDcId(request.getParameter("dcId"));
				dc.setDcPhone(request.getParameter("dPhone"));
				dc.setAddress1(request.getParameter("add1"));
				dc.setAddress2(request.getParameter("add2"));
				dc.setCity(request.getParameter("city"));
				dc.setPin(request.getParameter("pin"));
				dc.setState(request.getParameter("state"));
				dc.setLandmart(request.getParameter("landmark"));
				Login lg = new Login();
				lg.setUserId(request.getParameter("id"));
				lg.setPassword(request.getParameter("pass"));
				lg.setRole("dcstaff");
				DCStaff dcs = new DCStaff();
				dcs.setId(request.getParameter("id"));
				dcs.setDcId(request.getParameter("dcId"));
				int rs = ds.addDC(dc, lg, dcs);
				if (rs == 1) {
					sess.setAttribute("msg", "Successfully added new DC");
					response.sendRedirect("DCController");
				} else if (rs == -1) {
					sess.setAttribute("error", "Wrong dcid");
					response.sendRedirect("AddDC.jsp");
				} else if (rs == -2) {
					sess.setAttribute("error", "Wrong dc staff id");
					response.sendRedirect("AddDC.jsp");
				} else {
					sess.setAttribute("error", "Wrong dc staff id or dc id");
					response.sendRedirect("AddDC.jsp");
				}
			} else if (action.equals("addStore")) {
				DCStore dcs = new DCStore();
				dcs.setSid(request.getParameter("sId"));
				dcs.setDcId(obj.getDcId());
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
				ss.setDcid(obj.getDcId());
				ss.setId(request.getParameter("id"));
				ss.setSid(request.getParameter("sId"));
				int rs = ds.addStore(dcs, lg, ss);
				if (rs == 1) {
					sess.setAttribute("msg", "Successfully added new Store");
					response.sendRedirect("DCController");
				} else {
					sess.setAttribute("error", "Wrong dc staff id or dc id");
					response.sendRedirect("AddStore.jsp");
				}
			} else if (action.equals("po")) {
				PO pobj = new PO();
				pobj.setPoid(request.getParameter("poid"));
				String pattern = "12-11-2015";
				pobj.setGdate(new SimpleDateFormat(pattern).format(new Date()).toString());
				pobj.setVid(request.getParameter("vid"));
				pobj.setEdate(request.getParameter("edd") + "-" + request.getParameter("emm") + "-"
						+ request.getParameter("eyyyy"));
				pobj.setDcid(obj.getDcId());
				pobj.setDts("1");
				pobj.setShid(obj.getDcId());
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
						response.sendRedirect("DCController?action=poGenerate");
					}
					po++;
					pobj.setStatus("g");
					String msg = ps.addPO(pobj);
					if (msg != null) {
						sess.setAttribute("msg", msg);
						response.sendRedirect("DCPage.jsp");
					}
					System.out.println("234");
				}
			} else if ("DeletedStores".equals(action)) {

				DCStore dcs = new DCStore();
				dcs.setSid(request.getParameter("sid"));
				dcs.setDcId(obj.getDcId());
				DCService dcserv = new DCService();
				String msg = dcserv.deleteDcStore(dcs);
				if (msg != null) {
					sess.setAttribute("msg", "Deletd done Successfully");
					response.sendRedirect("DCPage.jsp");

				}

				else {
					sess.setAttribute("msg", "Deletd not  done Successfully");
				}

			} else if ("UpdateStores".equals(action)) {

				DCStore dcs = new DCStore();
				dcs.setSid(request.getParameter("sid"));
				dcs.setDcId(obj.getDcId());
				DCService dcserv = new DCService();
				dcs = dcserv.getStoreDetailById(dcs);
				if (dcs != null) {
					request.setAttribute("StoreDetails", dcs);
					RequestDispatcher rd = request.getRequestDispatcher("UpdateDCStorePage.jsp");
					rd.forward(request, response);
				}
			} else if ("UpdateDCStorePage".equals(action)) {
				DCStore dcs = new DCStore();
				dcs.setsManager(request.getParameter("mName"));
				dcs.setSphone(request.getParameter("sPhone"));
				dcs.setAddress1(request.getParameter("add1"));
				dcs.setAddress2(request.getParameter("add2"));
				dcs.setPin(request.getParameter("pin"));
				dcs.setCity(request.getParameter("city"));
				dcs.setState(request.getParameter("state"));
				dcs.setLandmart(request.getParameter("landmark"));
				String dcid = obj.getDcId();
				String sid = request.getParameter("sid");
				dcs.setSid(sid);
				dcs.setDcId(dcid);
				DCService dc = new DCService();
				String msg = dc.updateStoreDetails(dcs);
				if (msg != null) {
					sess.setAttribute("msg", "Updated done Successfully");
					response.sendRedirect("DCPage.jsp");

				}

				else {
					sess.setAttribute("msg", "Updated not  done Successfully");
					response.sendRedirect("DCController?action=Update");
				}

			}
		}
	}

}

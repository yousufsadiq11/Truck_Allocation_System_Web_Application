package services;

import java.util.ArrayList;

import bean.DCStore;
import bean.Login;
import bean.Product;
import bean.StoreStaff;
import bean.Vendor;
import dao.DCDAO;
import dao.StoreDAO;

public class StoreService {

	public DCStore getStoreDetail(String sid, String dcId) {
		StoreDAO sd = new StoreDAO();
		return sd.getStoreDetail(sid, dcId);
	}

	public ArrayList<Product> getAllStoreProductDetail(String sid, String dcId) {
		StoreDAO dc = new StoreDAO();
		return dc.getAllStoreProductDetail(sid, dcId);
	}

	public ArrayList<Product> getAllNewProductDetail(String sid, String dcId) {
		StoreDAO sd = new StoreDAO();
		return sd.getAllNewProductDetail(sid, dcId);
	}

	public int addStore(DCStore dcs, Login lg, StoreStaff ss) {
		DCDAO dco = new DCDAO();
		return dco.addStore(dcs, lg, ss);
	}

	public String addNewProductToStore(String sid, String dcid, Product pobj) {
		StoreDAO sd = new StoreDAO();
		return sd.addNewProductToStore(sid, dcid, pobj);
	}

	public String updateStoreProductQuantity(String sid, String dcid, String pid, int avai, int th) {
		StoreDAO sd = new StoreDAO();
		return sd.updateStoreProductQuantity(sid, dcid, pid, avai, th);
	}

	/*
	 * public ArrayList<DCStore> getStoreDetail(String dcid, String string){
	 * DCDAO dc = new DCDAO(); return dc.getStoreDetail(dcid); }
	 */
	public ArrayList<Product> getUnderThProductDetail(String sid, String dcid) {
		StoreDAO dc = new StoreDAO();
		return dc.getUnderThProductDetail(sid, dcid);
	}

	public ArrayList<Product> getAllProductDetail(String dcid) {
		DCDAO dc = new DCDAO();
		return dc.getAllProductDetail(dcid);
	}

	public String addNewProduct(String dcid, Product pobj) {
		DCDAO dc = new DCDAO();
		return dc.addNewProduct(dcid, pobj);
	}

	public ArrayList<Vendor> getAllVendor() {
		DCDAO dc = new DCDAO();
		return dc.getAllVendor();
	}

	public String deleteDcStore(DCStore dcs) {

		DCDAO dc = new DCDAO();
		return dc.deleteDcStore(dcs);

	}

	public String updateStoreDetails(DCStore dc) {
		DCDAO da = new DCDAO();
		return da.updateStoreDetails(dc);

	}

	public DCStore getStoreDetailById(DCStore dcs) {
		DCDAO dc = new DCDAO();
		return dc.getStoreDetailsById(dcs);
	}

	public String deleteStoreProduct(Product p, String sid, String dcid) {

		StoreDAO sdao = new StoreDAO();
		return sdao.deleteStoreProduct(p, sid, dcid);

	}

}

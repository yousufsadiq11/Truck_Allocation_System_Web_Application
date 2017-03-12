package services;

import java.util.ArrayList;

import bean.*;
import dao.DCDAO;
import dao.IDGeneratorDAO;

public class DCService {
	public DCDetail getDCDetail(String dcId) {
		DCDAO dc = new DCDAO();
		return dc.getDCDetail(dcId);
	}

	public ArrayList<Product> getProductDetail(String dcId) {
		DCDAO dc = new DCDAO();
		return dc.getProductDetail(dcId);
	}

	public int addDC(DCDetail dc, Login lg, DCStaff dcs) {
		DCDAO dco = new DCDAO();
		return dco.addDC(dc, lg, dcs);
	}

	public int addStore(DCStore dcs, Login lg, StoreStaff ss) {
		DCDAO dco = new DCDAO();
		return dco.addStore(dcs, lg, ss);
	}

	public ArrayList<DCStore> getStoreDetail(String dcid) {
		DCDAO dc = new DCDAO();
		return dc.getStoreDetail(dcid);
	}

	public String updateProductQuantity(String pid, String dcid, int q, int th) {
		DCDAO dc = new DCDAO();
		return dc.updateProductQuantity(pid, dcid, q, th);
	}

	public ArrayList<Product> getUnderThProductDetail(String dcid) {
		DCDAO dc = new DCDAO();
		return dc.getUnderThProductDetail(dcid);
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

	public ArrayList<PurchaseOrder> getStoreGenPOs() {
		DCDAO dc = new DCDAO();
		return dc.getStoreGenPOs();
	}

	public ArrayList<PurchaseOrder> getStoreAppPOs() {
		DCDAO dc = new DCDAO();
		return dc.getStoreAppPOs();
	}

	public String approvePO(String poid) {
		DCDAO dc = new DCDAO();
		return dc.approvePO(poid);
	}

	public String getUniqueDCID() {
		IDGeneratorDAO gd = new IDGeneratorDAO();
		return gd.uniqueDCIdGenerator();
	}

	public String getUniqueDCUserID() {
		IDGeneratorDAO gd = new IDGeneratorDAO();
		return gd.uniqueDCUserIdGenerator();
	}

	public String getUniqueStoreID(String dcid) {
		IDGeneratorDAO gd = new IDGeneratorDAO();
		return gd.uniqueStoreIdGenerator(dcid);
	}

	public String getUniqueStoreUserID() {
		IDGeneratorDAO gd = new IDGeneratorDAO();
		return gd.uniqueStoreUserIdGenerator();
	}

	public String getUniquePOID() {
		IDGeneratorDAO gd = new IDGeneratorDAO();
		return gd.uniquePOGenerator();
	}
}

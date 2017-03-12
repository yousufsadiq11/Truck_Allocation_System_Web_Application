package services;

import java.util.ArrayList;

import bean.*;
import dao.IDGeneratorDAO;
import dao.UHDAO;

public class UHService {
	public UnitHead getUHDetail(String uId) {
		UHDAO uh = new UHDAO();
		return uh.getUHDetail(uId);
	}

	public ArrayList<DCDetail> getDCDetail() {
		UHDAO uh = new UHDAO();
		return uh.getDCDetail();
	}

	public ArrayList<DCStore> getStoreDetails() {
		UHDAO uh = new UHDAO();
		return uh.getStoreDetails();
	}

	public ArrayList<UnitHeadProduct> getProductDetails() {
		UHDAO uh = new UHDAO();
		return uh.getProductDetails();
	}

	public int addProducts(UnitHeadProduct uhp) {
		UHDAO uh = new UHDAO();
		return uh.addProducts(uhp);
	}

	public int addVendors(Vendor v) {
		UHDAO uh = new UHDAO();
		return uh.addVendors(v);
	}

	public ArrayList<Vendor> getVendorDetails() {
		UHDAO uh = new UHDAO();
		return uh.getVendorDetails();
	}

	public ArrayList<PurchaseOrder> getPODetails() {
		UHDAO uh = new UHDAO();
		return uh.getPODetails();
	}

	public ArrayList<POProduct> showPOProductById(String poid) {
		UHDAO uh = new UHDAO();
		return uh.showPOProductById(poid);
	}

	public String approvePO(String poid) {
		UHDAO uh = new UHDAO();
		return uh.approvePO(poid);
	}

	public String getUniqueProductId() {
		IDGeneratorDAO gd = new IDGeneratorDAO();
		return gd.uniqueProductIdGenerator();
	}

	public String getUniqueVendorId() {
		IDGeneratorDAO gd = new IDGeneratorDAO();
		return gd.uniqueVendorIdGenerator();
	}
}

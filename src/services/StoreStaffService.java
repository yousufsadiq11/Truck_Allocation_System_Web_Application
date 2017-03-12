package services;

import bean.StoreStaff;
import dao.StoreStaffDAO;

public class StoreStaffService {
	public int checkStaffStore(StoreStaff lg) {
		StoreStaffDAO ssd = new StoreStaffDAO();
		return ssd.checkStaffStore(lg);
	}
}

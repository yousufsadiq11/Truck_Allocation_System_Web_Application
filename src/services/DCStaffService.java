package services;

import bean.DCStaff;
import dao.DCStaffDAO;

public class DCStaffService {
	public int checkStaffDC(DCStaff lg) {
		DCStaffDAO ssd = new DCStaffDAO();
		return ssd.checkStaffDC(lg);
	}
}

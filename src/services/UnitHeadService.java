package services;

import bean.UnitHead;
import dao.UnitHeadDAO;

public class UnitHeadService {
	public UnitHead checkUnitHead(UnitHead unithead) {
		UnitHeadDAO uhdao = new UnitHeadDAO();
		return uhdao.checkUnitHead(unithead);
	}

}

package services;

import java.util.*;
import bean.*;
import dao.*;

public class POService {
	public int addPOProduct(ArrayList<POProduct> temp) {
		PODAO po = new PODAO();
		return po.addPOProduct(temp);
	}

	public String addPO(PO temp) {
		PODAO po = new PODAO();
		return po.addPO(temp);
	}
}

package dao;

import java.util.*;
import bean.*;
import java.sql.*;

public class PODAO {
	public int addPOProduct(ArrayList<POProduct> temp) {
		DAOUtil da = new DAOUtil();
		Connection conn = da.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into poproduct99 values(?,?,?,?,?)");
			int i = 1;
			for (POProduct obj : temp) {
				ps.setString(1, obj.getPid());
				ps.setString(2, obj.getPoid());
				ps.setInt(3, obj.getOrQuantity());
				ps.setDouble(4, obj.getUnit());
				ps.setDouble(5, obj.getTotal());
				ps.executeUpdate();
			}
			System.out.println("addp");
			return i;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public String addPO(PO temp) {
		DAOUtil da = new DAOUtil();
		Connection conn = da.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into dcpotable99 values(?,to_date(?,'dd-mm-yyyy'),?,?,to_date(?,'dd-mm-yyyy'),?,?,?)");
			ps.setString(1, temp.getPoid());
			ps.setString(2, temp.getGdate());
			ps.setString(3, temp.getDcid());
			ps.setString(4, temp.getVid());
			ps.setString(5, temp.getEdate());
			ps.setString(6, temp.getDts());
			ps.setString(7, temp.getShid());
			ps.setString(8, temp.getStatus());
			ps.executeUpdate();
			System.out.println("addpo");
			return "PO Successfully generated";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

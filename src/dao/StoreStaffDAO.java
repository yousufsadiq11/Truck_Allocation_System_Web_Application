package dao;

import java.sql.*;
import java.sql.ResultSet;

import bean.StoreStaff;

public class StoreStaffDAO {
	public int checkStaffStore(StoreStaff ss) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from storestaff99 where id = ?");
			ps.setString(1, ss.getId());
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("wrong Store staff id");
				return -1;
			}
			rs.next();
			ss.setSid(rs.getString(2));
			ss.setDcid(rs.getString(3));
			du.closeConnection(conn);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}

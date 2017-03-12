package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.DCStaff;

public class DCStaffDAO {
	public int checkStaffDC(DCStaff ss) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from dcstaff99 where id = ?");
			ps.setString(1, ss.getId());
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("wrong DC staff id");
				return -1;
			}
			rs.next();
			ss.setDcId(rs.getString(2));
			du.closeConnection(conn);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}

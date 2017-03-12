package dao;

import java.sql.*;

import bean.Login;

public class LoginDAO {
	public int checkLogin(Login obj) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from login99 where id = ?");
			ps.setString(1, obj.getUserId());
			System.out.println("log");
			ResultSet rs = ps.executeQuery();
			System.out.println("connect");
			if (!rs.isBeforeFirst()) {
				obj.setRole("Invalid UserID");
				return -1;
			}
			rs.next();
			if (!(rs.getString(2).equals(obj.getPassword()))) {
				obj.setRole("Invalid Password");
				return -1;
			}
			obj.setRole(rs.getString(3));
			du.closeConnection(conn);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}

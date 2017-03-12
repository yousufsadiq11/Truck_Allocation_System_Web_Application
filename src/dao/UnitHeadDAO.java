package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.UnitHead;

public class UnitHeadDAO {

	public UnitHead checkUnitHead(UnitHead unithead) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from UnitHead99 where UH_ID = ?");
			ps.setString(1, unithead.getuId());
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("Wrong Unit Head id");
				return null;
			}
			rs.next();
			unithead.setuId(rs.getString(1));
			unithead.setuName(rs.getString(2));
			unithead.setuPhone(rs.getString(3));
			System.out.println("done");
			du.closeConnection(conn);
			return unithead;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("sdklaklsdf");
		return null;
	}
}

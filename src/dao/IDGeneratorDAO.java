package dao;

import java.sql.*;

public class IDGeneratorDAO {
	public String uniquePOGenerator() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		String poid = "PO2000";
		ResultSet rs = null;
		try {
			do {
				poid = "PO" + String.format("%04d", (int) (Math.random() * 10000));
				PreparedStatement ps = conn.prepareStatement("select * from dcpotable99 where poid = ?");
				ps.setString(1, poid);
				rs = ps.executeQuery();
			} while (rs.next());
			return poid;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return poid;
	}

	public String uniqueDCIdGenerator() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		String dcid = "DC2000";
		ResultSet rs = null;
		try {
			do {
				dcid = "DC" + String.format("%04d", (int) (Math.random() * 10000));
				PreparedStatement ps = conn.prepareStatement("select * from dcdetail99 where dcid = ?");
				ps.setString(1, dcid);
				rs = ps.executeQuery();
			} while (rs.next());
			return dcid;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dcid;
	}

	public String uniqueDCUserIdGenerator() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		String dcid = "DD2000";
		ResultSet rs = null;
		try {
			do {
				dcid = "DC" + String.format("%04d", (int) (Math.random() * 10000));
				PreparedStatement ps = conn.prepareStatement("select * from dcstaff99 where id = ?");
				ps.setString(1, dcid);
				rs = ps.executeQuery();
			} while (rs.next());
			return dcid;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dcid;
	}

	public String uniqueStoreIdGenerator(String dcid) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		String sid = "ST2000";
		ResultSet rs = null;
		try {
			do {
				sid = "ST" + String.format("%04d", (int) (Math.random() * 10000));
				PreparedStatement ps = conn.prepareStatement("select * from dcstore99 where dcid = ? and sid = ?");
				ps.setString(1, dcid);
				ps.setString(2, sid);
				rs = ps.executeQuery();
			} while (rs.next());
			return sid;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sid;
	}

	public String uniqueStoreUserIdGenerator() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		String id = "UU2000";
		ResultSet rs = null;
		try {
			do {
				id = "UU" + String.format("%04d", (int) (Math.random() * 10000));
				PreparedStatement ps = conn.prepareStatement("select * from storestaff99 where id = ?");
				ps.setString(1, id);
				rs = ps.executeQuery();
			} while (rs.next());
			return id;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	public String uniqueProductIdGenerator() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		String pid = "PR2000";
		ResultSet rs = null;
		try {
			do {
				pid = "PR" + String.format("%04d", (int) (Math.random() * 10000));
				PreparedStatement ps = conn.prepareStatement("select * from product99 where pid = ?");
				ps.setString(1, pid);
				rs = ps.executeQuery();
			} while (rs.next());
			System.out.println(pid);
			return pid;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pid;
	}

	public String uniqueVendorIdGenerator() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		String vid = "VV2000";
		ResultSet rs = null;
		try {
			do {
				vid = "VV" + String.format("%04d", (int) (Math.random() * 10000));
				PreparedStatement ps = conn.prepareStatement("select * from vendor99 where vid = ?");
				ps.setString(1, vid);
				rs = ps.executeQuery();
			} while (rs.next());
			System.out.println(vid);
			return vid;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vid;
	}

}

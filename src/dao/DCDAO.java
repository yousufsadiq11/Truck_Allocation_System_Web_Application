package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.*;

public class DCDAO {
	public DCDetail getDCDetail(String dcId) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from dcdetail99 where dcid = ?");
			ps.setString(1, dcId);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				rs.next();
				DCDetail dd = new DCDetail();
				dd.setDcId(rs.getString(1));
				dd.setDcPhone(rs.getString(2));
				dd.setAddress1(rs.getString(3));
				dd.setAddress2(rs.getString(4));
				dd.setPin(rs.getString(5));
				dd.setCity(rs.getString(6));
				dd.setState(rs.getString(7));
				dd.setLandmart(rs.getString(8));
				return dd;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<Product> getProductDetail(String dcId) {
		DAOUtil obj = new DAOUtil();
		ArrayList<Product> pp = new ArrayList<Product>();
		Connection conn = obj.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from dcproduct99 where dcid = ?");
			ps.setString(1, dcId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pobj = new Product();
				pobj.setPid(rs.getString(2));
				pobj.setAvailableQuantity(rs.getInt(3));
				pobj.setTh(rs.getInt(4));
				PreparedStatement ps1 = conn.prepareStatement("select * from product99 where pid = ?");
				ps1.setString(1, rs.getString(2));
				ResultSet rs1 = ps1.executeQuery();
				rs1.next();
				pobj.setPname(rs1.getString(2));
				pobj.setPdetail(rs.getString(3));
				pp.add(pobj);
			}
			obj.closeConnection(conn);
			return pp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pp;
	}

	public int addDC(DCDetail dc, Login lg, DCStaff ds) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into dcdetail99 values(?,?,?,?,?,?,?,?)");
			ps.setString(1, dc.getDcId());
			ps.setString(2, dc.getDcPhone());
			ps.setString(3, dc.getAddress1());
			ps.setString(4, dc.getAddress2());
			ps.setString(5, dc.getPin());
			ps.setString(6, dc.getCity());
			ps.setString(7, dc.getState());
			ps.setString(8, dc.getLandmart());
			int rs = ps.executeUpdate();
			if (rs == 0) {
				return -1;
			}
			System.out.println("dc detail done");
			ps = conn.prepareStatement("insert into login99 values(?,?,?)");
			ps.setString(1, lg.getUserId());
			ps.setString(2, lg.getPassword());
			ps.setString(3, lg.getRole());
			rs = ps.executeUpdate();
			if (rs == 0) {
				return -2;
			}
			System.out.println("login done");
			ps = conn.prepareStatement("insert into dcstaff99 values(?,?)");
			ps.setString(1, ds.getId());
			ps.setString(2, ds.getDcId());
			rs = ps.executeUpdate();
			if (rs == 0) {
				return -3;
			}
			System.out.println("total done");
			du.closeConnection(conn);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public int addStore(DCStore dcs, Login lg, StoreStaff ss) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into dcstore99 values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, dcs.getSid());
			ps.setString(2, dcs.getDcId());
			ps.setString(3, dcs.getsManager());
			ps.setString(4, dcs.getSphone());
			ps.setString(5, dcs.getAddress1());
			ps.setString(6, dcs.getAddress2());
			ps.setString(7, dcs.getPin());
			ps.setString(8, dcs.getCity());
			ps.setString(9, dcs.getState());
			ps.setString(10, dcs.getLandmart());
			int rs = ps.executeUpdate();
			if (rs == 0) {
				return -1;
			}
			System.out.println("dc store detail done");
			ps = conn.prepareStatement("insert into login99 values(?,?,?)");
			ps.setString(1, lg.getUserId());
			ps.setString(2, lg.getPassword());
			ps.setString(3, lg.getRole());
			rs = ps.executeUpdate();
			if (rs == 0) {
				return -2;
			}
			System.out.println("login done");
			ps = conn.prepareStatement("insert into storestaff99 values(?,?,?)");
			ps.setString(1, ss.getId());
			ps.setString(2, ss.getSid());
			ps.setString(3, ss.getDcid());
			rs = ps.executeUpdate();
			if (rs == 0) {
				return -3;
			}
			System.out.println("total done");
			du.closeConnection(conn);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public ArrayList<DCStore> getStoreDetail(String dcId) {
		DAOUtil obj = new DAOUtil();
		ArrayList<DCStore> pp = new ArrayList<DCStore>();
		Connection conn = obj.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from dcstore99 where dcid = ?");
			ps.setString(1, dcId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DCStore dobj = new DCStore();
				dobj.setSid(rs.getString(1));
				dobj.setDcId(rs.getString(2));
				dobj.setsManager(rs.getString(3));
				dobj.setSphone(rs.getString(4));
				dobj.setAddress1(rs.getString(5));
				dobj.setAddress2(rs.getString(6));
				dobj.setPin(rs.getString(7));
				dobj.setCity(rs.getString(8));
				dobj.setState(rs.getString(9));
				dobj.setLandmart(rs.getString(10));
				pp.add(dobj);
			}
			obj.closeConnection(conn);
			return pp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pp;
	}

	public String updateProductQuantity(String pid, String dcid, int q, int th) {
		DAOUtil obj = new DAOUtil();
		Connection conn = obj.getConnection();
		String msg = "";
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update dcproduct99 set availablequantity = availablequantity + ?,th = th + ? where pid = ? and dcid=?");
			ps.setInt(1, q);
			ps.setInt(2, th);
			ps.setString(3, pid);
			ps.setString(4, dcid);
			ps.executeUpdate();
			ps = conn.prepareStatement("select * from product99 where pid=?");
			ps.setString(1, pid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getString(2);
			ps = conn.prepareStatement("select * from dcproduct99 where pid=? and dcid = ?");
			ps.setString(1, pid);
			ps.setString(2, dcid);
			rs = ps.executeQuery();
			rs.next();
			int qu = rs.getInt(3);
			int thu = rs.getInt(4);
			msg = name + " available quantity is updated to " + (qu - q) + " to " + qu
					+ " and threshhold value updated to " + (thu - th) + " to " + thu;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	public ArrayList<Product> getUnderThProductDetail(String dcId) {
		DAOUtil obj = new DAOUtil();
		ArrayList<Product> pp = new ArrayList<Product>();
		Connection conn = obj.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from dcproduct99 where dcid = ? and availablequantity <= th");
			ps.setString(1, dcId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pobj = new Product();
				pobj.setPid(rs.getString(2));
				pobj.setAvailableQuantity(rs.getInt(3));
				pobj.setTh(rs.getInt(4));
				PreparedStatement ps1 = conn.prepareStatement("select * from product99 where pid = ?");
				ps1.setString(1, rs.getString(2));
				ResultSet rs1 = ps1.executeQuery();
				rs1.next();
				pobj.setPname(rs1.getString(2));
				pobj.setPdetail(rs.getString(3));
				pp.add(pobj);
			}
			obj.closeConnection(conn);
			return pp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pp;
	}

	public ArrayList<Product> getAllProductDetail(String dcid) {
		DAOUtil obj = new DAOUtil();
		ArrayList<Product> pp = new ArrayList<Product>();
		Connection conn = obj.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select * from product99 where pid not in (select pid from dcproduct where dcid = ?)");
			ps.setString(1, dcid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pobj = new Product();
				pobj.setPid(rs.getString(1));
				pobj.setPname(rs.getString(2));
				pobj.setPdetail(rs.getString(3));
				pp.add(pobj);
			}
			obj.closeConnection(conn);
			return pp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pp;
	}

	public String addNewProduct(String dcid, Product pobj) {
		DAOUtil obj = new DAOUtil();
		Connection conn = obj.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into dcproduct99 values(?,?,?,?)");
			ps.setString(1, dcid);
			ps.setString(2, pobj.getPid());
			ps.setInt(3, pobj.getAvailableQuantity());
			ps.setInt(4, pobj.getTh());
			ps.executeUpdate();
			return pobj.getPid() + " product successfully added to " + dcid;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<Vendor> getAllVendor() {
		ArrayList<Vendor> vobj = new ArrayList<Vendor>();
		DAOUtil obj = new DAOUtil();
		Connection conn = obj.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Select * from vendor99");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vendor temp = new Vendor();
				temp.setVid(rs.getString(1));
				temp.setVname(rs.getString(2));
				temp.setVadd(rs.getString(3));
				vobj.add(temp);
			}
			return vobj;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String deleteDcStore(DCStore dc) {
		int deleted = 0;
		DAOUtil dutil = new DAOUtil();
		Connection con = dutil.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("delete from dcstore99 where sid =? and dcid =?");
			ps.setString(1, dc.getSid());
			ps.setString(2, dc.getDcId());
			deleted = ps.executeUpdate();
			if (deleted > 0) {
				return "Its Deleted";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String updateStoreDetails(DCStore dc) {
		String msg = "fail";
		int x = 0;
		DAOUtil du = new DAOUtil();
		Connection con = du.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(
					"update dcstore99 set smanager = ?, sphone= ?, add1=?,add2=?,pin=?,city=?,state=?,landmark=? where sid =? and dcid =?");
			ps.setString(1, dc.getsManager());
			ps.setString(2, dc.getSphone());
			ps.setString(3, dc.getAddress1());
			ps.setString(4, dc.getAddress2());
			ps.setString(5, dc.getPin());
			ps.setString(6, dc.getCity());
			ps.setString(7, dc.getState());
			ps.setString(8, dc.getLandmart());
			ps.setString(9, dc.getSid());
			ps.setString(10, dc.getDcId());

			x = ps.executeUpdate();
			if (x > 0) {
				System.out.println("sadklf");
				msg = "success";
				return msg;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public DCStore getStoreDetailsById(DCStore dc) {
		DAOUtil dao = new DAOUtil();
		Connection con = dao.getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement ps = con.prepareStatement("select * from dcstore99 where sid =? and dcid =?");
			ps.setString(1, dc.getSid());
			ps.setString(2, dc.getDcId());
			rs = ps.executeQuery();
			while (rs.next()) {
				dc.setsManager(rs.getString(3));
				dc.setSphone(rs.getString(4));
				dc.setAddress1(rs.getString(5));
				dc.setAddress2(rs.getString(6));
				dc.setPin(rs.getString(7));
				dc.setCity(rs.getString(8));
				dc.setState(rs.getString(9));
				dc.setLandmart(rs.getString(10));

			}
			return dc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<PurchaseOrder> getStoreGenPOs() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		ArrayList<PurchaseOrder> poa1 = new ArrayList<PurchaseOrder>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from dcpotable99");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				PurchaseOrder po = new PurchaseOrder();
				po.setPoId(rs.getString(1));
				po.setPoDate(rs.getString(2));
				po.setDcId(rs.getString(3));
				po.setvId(rs.getString(4));
				po.setEdate(rs.getString(5));
				po.setDts(rs.getString(6));
				po.setShipId(rs.getString(7));
				po.setStatus(rs.getString(8));

				poa1.add(po);

			}
			return poa1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<PurchaseOrder> getStoreAppPOs() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		ArrayList<PurchaseOrder> poa1 = new ArrayList<PurchaseOrder>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from dcpotable99");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PurchaseOrder po = new PurchaseOrder();
				po.setPoId(rs.getString(1));
				po.setPoDate(rs.getString(2));
				po.setDcId(rs.getString(3));
				po.setvId(rs.getString(4));
				po.setEdate(rs.getString(5));
				po.setDts(rs.getString(6));
				po.setShipId(rs.getString(7));
				po.setStatus(rs.getString(8));
				poa1.add(po);

			}
			return poa1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String approvePO(String poid) {
		DAOUtil da = new DAOUtil();
		Connection conn = da.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update dcpotable99 set status = 'g' where poid = ?");
			ps.setString(1, poid);
			int rs = ps.executeUpdate();
			return poid + " po is approved";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DCDetail;
import bean.DCStore;
import bean.POProduct;
import bean.PurchaseOrder;
import bean.UnitHeadProduct;
import bean.UnitHead;
import bean.Vendor;

public class UHDAO {
	public UnitHead getUHDetail(String uId) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from UnitHead99 where uh_Id = ?");
			ps.setString(1, uId);
			System.out.println(uId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UnitHead uh2 = new UnitHead();
				uh2.setuName(rs.getString(1));
				uh2.setuId(rs.getString(2));
				uh2.setuPhone(rs.getString(3));

				return uh2;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<DCDetail> getDCDetail() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		ArrayList<DCDetail> dca = new ArrayList<DCDetail>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from dcdetail99");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				DCDetail dc2 = new DCDetail();
				dc2.setDcId(rs.getString(1));
				dc2.setDcPhone(rs.getString(2));
				dc2.setAddress1(rs.getString(3));
				dc2.setAddress2(rs.getString(4));
				dc2.setPin(rs.getString(5));
				dc2.setCity(rs.getString(6));
				dc2.setState(rs.getString(7));
				dc2.setLandmart(rs.getString(8));

				dca.add(dc2);

			}
			return dca;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<DCStore> getStoreDetails() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		ArrayList<DCStore> dca = new ArrayList<DCStore>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from dcstore99");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				DCStore dcs = new DCStore();
				dcs.setSid(rs.getString(1));
				dcs.setDcId(rs.getString(2));
				dcs.setsManager(rs.getString(3));
				dcs.setSphone(rs.getString(4));
				dcs.setAddress1(rs.getString(5));
				dcs.setAddress2(rs.getString(6));
				dcs.setPin(rs.getString(7));
				dcs.setCity(rs.getString(8));
				dcs.setState(rs.getString(9));
				dcs.setLandmart(rs.getString(10));

				dca.add(dcs);

			}
			return dca;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<UnitHeadProduct> getProductDetails() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		ArrayList<UnitHeadProduct> pa = new ArrayList<UnitHeadProduct>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from product99");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				UnitHeadProduct p = new UnitHeadProduct();
				p.setpId(rs.getString(1));
				p.setpName(rs.getString(2));
				p.setpDetail(rs.getString(3));

				pa.add(p);

			}
			return pa;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public int addProducts(UnitHeadProduct uhp) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into product99 values(?,?,?)");

			ps.setString(1, uhp.getpId());
			ps.setString(2, uhp.getpName());
			ps.setString(3, uhp.getpDetail());

			ps.executeUpdate();
			return 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int addVendors(Vendor v) {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into vendor99 values(?,?,?)");

			ps.setString(1, v.getVid());
			ps.setString(2, v.getVname());
			ps.setString(3, v.getVadd());

			ps.executeUpdate();
			return 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Vendor> getVendorDetails() {
		DAOUtil du = new DAOUtil();
		Connection conn = du.getConnection();
		ArrayList<Vendor> va1 = new ArrayList<Vendor>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from vendor99");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Vendor v1 = new Vendor();
				v1.setVid(rs.getString(1));
				v1.setVname(rs.getString(2));
				v1.setVadd(rs.getString(3));

				va1.add(v1);

			}
			return va1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<PurchaseOrder> getPODetails() {
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

	public ArrayList<POProduct> showPOProductById(String poid) {
		DAOUtil da = new DAOUtil();
		Connection conn = da.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from poproduct99 where poid = ?");
			ps.setString(1, poid);
			ResultSet rs = ps.executeQuery();
			ArrayList<POProduct> pobj = new ArrayList<POProduct>();
			while (rs.next()) {
				POProduct po = new POProduct();
				po.setPid(rs.getString(2));
				po.setPoid(rs.getString(1));
				po.setUnit(rs.getDouble(4));
				po.setOrQuantity(rs.getInt(3));
				po.setTotal(rs.getDouble(5));
				System.out.println(rs.getString(1));
				pobj.add(po);
			}
			return pobj;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String approvePO(String poid) {
		DAOUtil da = new DAOUtil();
		Connection conn = da.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update dcpotable99 set status = 'a' where poid = ?");
			ps.setString(1, poid);
			int rs = ps.executeUpdate();
			return poid + " po is approved";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

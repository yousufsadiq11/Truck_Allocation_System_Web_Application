package bean;

public class POProduct {
	private String poid;
	private String pid;
	private int orQuantity;
	private double unit;
	private double total;

	public String getPoid() {
		return poid;
	}

	public void setPoid(String poid) {
		this.poid = poid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getOrQuantity() {
		return orQuantity;
	}

	public void setOrQuantity(int orQuantity) {
		this.orQuantity = orQuantity;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}

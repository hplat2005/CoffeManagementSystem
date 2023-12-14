package model;
import java.sql.Date;
public class Bill {
	private String billId;
    private String tableNo;
    private String orderNo;
    private String discount;
    private String totalAmount;
    private String name;
    private Date date;
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Bill(String billId, String tableNo, String orderNo, String discount, String totalAmount, String name,
			Date date) {
		super();
		this.billId = billId;
		this.tableNo = tableNo;
		this.orderNo = orderNo;
		this.discount = discount;
		this.totalAmount = totalAmount;
		this.name = name;
		this.date = date;
	}
    
    public Bill() {};

}

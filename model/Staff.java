package model;

public class Staff {
	private String staffId;
	private String staffName;
	private String staffAddress;
	private String staffPhoneNumber;
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffAddress=" + staffAddress
				+ ", staffPhoneNumber=" + staffPhoneNumber + "]";
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName (String staffName) {
		this.staffName = staffName;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}
	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}
	public Staff(String staffId, String staffName, String staffAddress, String staffPhoneNumber) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAddress = staffAddress;
		this.staffPhoneNumber = staffPhoneNumber;
	}
	public Staff() {};
	

}

package dto;

public class AdminStatusBean {
	private int adminStatusId;
	private int adminStatus;
	
	public AdminStatusBean(int adminStatusId, int adminStatus) {
		this.adminStatusId = adminStatusId;
		this.adminStatus = adminStatus;
	}
	public int getAdminStatusId() {
		return adminStatusId;
	}
	public void setAdminStatusId(int adminStatusId) {
		this.adminStatusId = adminStatusId;
	}
	public int getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(int adminStatus) {
		this.adminStatus = adminStatus;
	}
	
	
}

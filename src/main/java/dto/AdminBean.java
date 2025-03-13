package dto;

public class AdminBean {
	private int adminId;
	private String name;
	private int pass;
	private int adminStatusId;
	
	public AdminBean(int adminId, String name, int pass, int adminStatusId) {
		this.adminId = adminId;
		this.name = name;
		this.pass = pass;
		this.adminStatusId = adminStatusId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public int getAdminStatusId() {
		return adminStatusId;
	}

	public void setAdminStatusId(int adminStatusId) {
		this.adminStatusId = adminStatusId;
	}
	
	
	
	
}

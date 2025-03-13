package dto;

public class ticketStatusesBean {
	private int ticketStatusId;
	private String ticketStatus;
	
	public ticketStatusesBean(int ticketStatusId, String ticketStatus) {
		this.ticketStatusId = ticketStatusId;
		this.ticketStatus = ticketStatus;
	}

	public int getTicketStatusId() {
		return ticketStatusId;
	}

	public void setTicketStatusId(int ticketStatusId) {
		this.ticketStatusId = ticketStatusId;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	
	
	
}

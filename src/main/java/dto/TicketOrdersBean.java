package dto;

import java.time.LocalDateTime;

public class TicketOrdersBean {
	private int ticketOrderId;
	private int userId;
	private LocalDateTime createAt;
	
	public TicketOrdersBean(int ticketOrderId, int userId, LocalDateTime createAt) {
		this.ticketOrderId = ticketOrderId;
		this.userId = userId;
		this.createAt = createAt;
	}

	public int getTicketOrderId() {
		return ticketOrderId;
	}

	public void setTicketOrderId(int ticketOrderId) {
		this.ticketOrderId = ticketOrderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	
	
	
	
}

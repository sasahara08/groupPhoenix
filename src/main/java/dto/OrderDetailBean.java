package dto;

import java.time.LocalDateTime;

public class OrderDetailBean {
	private int orderDetailId;
	private int ticketId;
	private int userId;
	private LocalDateTime createAt;
	//	private int ticketOrderId;
	//	private int quantity;

	//	public OrderDetailBean(int orderDetailId, int ticketOrderId, int ticketId, int quantity) {
	public OrderDetailBean(int orderDetailId, int ticketId, int userId, LocalDateTime createAt) {
		this.orderDetailId = orderDetailId;
		this.ticketId = ticketId;
		this.userId = userId;
		this.createAt = createAt;
		//		this.ticketOrderId = ticketOrderId;
		//		this.quantity = quantity;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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

	//	public int getTicketOrderId() {
	//		return ticketOrderId;
	//	}
	//
	//	public void setTicketOrderId(int ticketOrderId) {
	//		this.ticketOrderId = ticketOrderId;
	//	}
	//
	//	public int getQuantity() {
	//		return quantity;
	//	}
	//
	//	public void setQuantity(int quantity) {
	//		this.quantity = quantity;
	//	}

}

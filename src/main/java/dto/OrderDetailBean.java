package dto;

public class OrderDetailBean {
	private int orderDetailId;
	private int ticketOrderId;
	private int ticketId;
	private int quantity;
	
	public OrderDetailBean(int orderDetailId, int ticketOrderId, int ticketId, int quantity) {
		this.orderDetailId = orderDetailId;
		this.ticketOrderId = ticketOrderId;
		this.ticketId = ticketId;
		this.quantity = quantity;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getTicketOrderId() {
		return ticketOrderId;
	}

	public void setTicketOrderId(int ticketOrderId) {
		this.ticketOrderId = ticketOrderId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}

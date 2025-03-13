package dto;

public class TicketsBean {
	private int ticketId;
	private int gameId;
	private int seatId;
	private int seatNUmber;
	private int ticketStatusId;
	
	public TicketsBean(int ticketId, int gameId, int seatId, int seatNUmber, int ticketStatusId) {
		this.ticketId = ticketId;
		this.gameId = gameId;
		this.seatId = seatId;
		this.seatNUmber = seatNUmber;
		this.ticketStatusId = ticketStatusId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getSeatNUmber() {
		return seatNUmber;
	}

	public void setSeatNUmber(int seatNUmber) {
		this.seatNUmber = seatNUmber;
	}

	public int getTicketStatusId() {
		return ticketStatusId;
	}

	public void setTicketStatusId(int ticketStatusId) {
		this.ticketStatusId = ticketStatusId;
	}
	
	
	
	
}

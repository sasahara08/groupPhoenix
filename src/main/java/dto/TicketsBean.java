package dto;

import java.sql.Date;

public class TicketsBean {
	private int ticketId;
	private int gameId;
	private int seatId;
	private int seatNUmber;
	private int ticketStatusId;

	private Date createAt;

	private int userId;
	private String name;
	private String kana;

	private int ticketPurchaseStatusId;

	public TicketsBean(int ticketId, int gameId, int seatId, int seatNUmber, int ticketStatusId) {
		this.ticketId = ticketId;
		this.gameId = gameId;
		this.seatId = seatId;
		this.seatNUmber = seatNUmber;
		this.ticketStatusId = ticketStatusId;
	}

	public TicketsBean(int ticketStatusId, int ticketId, Date createAt, int userId, String name, String kana,
			int ticketPurchaseStatusId) {
		this.ticketStatusId = ticketStatusId;
		this.ticketId = ticketId;
		this.createAt = createAt;
		this.userId = userId;
		this.name = name;
		this.kana = kana;
		this.ticketPurchaseStatusId = ticketPurchaseStatusId;
		//		this.setCreateAt(createAt);
		//		this.setUserId(userId);
		//		this.setName(name);
		//		this.setKana(kana);

	}

	public TicketsBean() {
		// TODO 自動生成されたメソッド・スタブ

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public int getTicketPurchaseStatusId() {
		return ticketPurchaseStatusId;
	}

	public void setTicketPurchaseStatusId(int ticketPurchaseStatusId) {
		this.ticketPurchaseStatusId = ticketPurchaseStatusId;
	}

}

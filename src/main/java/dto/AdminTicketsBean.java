package dto;

import java.sql.Date;
import java.sql.Time;

public class AdminTicketsBean {
	private int ticketId;
	private int gameId;
	private int seatId;
	private int seatNUmber;
	private int ticketStatusId;

	private Date gameDate;
	private Time startTime;
	private String homeTeamName;
	private String awayTeamName;
	private String stadium;

	private Date createAt;
	private int orderDetailId;

	private int userId;
	private String name;
	private String kana;

	private int ticketPurchaseStatusId;

	private String ticketStatus;

	public AdminTicketsBean(int ticketId, int gameId, int seatId, int seatNUmber, int ticketStatusId) {
		this.ticketId = ticketId;
		this.gameId = gameId;
		this.seatId = seatId;
		this.seatNUmber = seatNUmber;
		this.ticketStatusId = ticketStatusId;
	}
	
//	public AdminTicketsBean(int ticketId, int ticketStatusId) {
//		this.ticketId = ticketId;
//		this.ticketStatusId = ticketStatusId;
//	}

	public AdminTicketsBean(int ticketStatusId, int ticketId, Date createAt, int userId, String name, String kana,
			int ticketPurchaseStatusId, int gameId, Date gameDate, Time startTime, String homeTeamName,
			String awayTeamName, String stadium, String ticketStatus, int orderDetailId) {
		this.ticketStatusId = ticketStatusId;
		this.ticketId = ticketId;
		this.createAt = createAt;
		this.userId = userId;
		this.name = name;
		this.kana = kana;
		this.ticketPurchaseStatusId = ticketPurchaseStatusId;
		this.gameId = gameId;
		this.gameDate = gameDate;
		this.startTime = startTime;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.stadium = stadium;
		this.ticketStatus = ticketStatus;
		this.orderDetailId = orderDetailId;

	}

	public AdminTicketsBean() {
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

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public String getAwayTeamName() {
		return awayTeamName;
	}

	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }


}

package dto;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

// Ticket.java  
public class Ticket {
	private int ticketId;
	private int gameId;
	private int seatId;
	private String seatNumber;
	private int ticketStatusId;
	private int ticketStatus;
	private String seatType;
	private int seatPrice;
	private int ticketOrderDetailId; // ticket_order_detailsの詳細ID
	private int ticketOrderId; // チケットオーダーID
	private int quantity; // 数量
	private Date gameDate;
	private Time startTime;
	private int homeTeamId;
	private int awayTeamId;
	private int stadiumId;
	private String stadiumName;
	private String homeTeamName;
	private String awayTeamName;
	private int userId;
	private LocalDateTime createdAt;

	// Constructor
	public Ticket(int gameId, Date gameDate, Time startTime, String homeTeamName, String awayTeamName,
			String stadiumName, int seatPrice, String seatType, int ticketId, int ticketStatus) {
		this.ticketId = ticketId;
		this.gameId = gameId;
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.seatPrice = seatPrice;
		this.gameDate = gameDate;
		this.startTime = startTime;
		this.homeTeamId = homeTeamId;
		this.awayTeamId = awayTeamId;
		this.stadiumId = stadiumId;
		this.stadiumName = stadiumName;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.seatPrice = seatPrice;
		this.ticketStatus = ticketStatus;

	}

	// GETTERメソッド
	public int getTicketId() {
		return ticketId;
	}

	public int getGameId() {
		return gameId;
	}

	public int getSeatId() {
		return seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public int getTicketStatusId() {
		return ticketStatusId;
	}

	public int getTicketStatus() {
		return ticketStatus;
	}

	public String getSeatType() {
		return seatType;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public int getTicketOrderDetailId() {
		return ticketOrderDetailId;
	}

	public int getTicketOrderId() {
		return ticketOrderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public int getHomeTeamId() {
		return homeTeamId;
	}

	public int getAwayTeamId() {
		return awayTeamId;
	}

	public int getStadiumId() {
		return stadiumId;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public String getAwayTeamName() {
		return awayTeamName;
	}

	public int getUserId() {
		return userId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", gameId=" + gameId + ", seatId=" + seatId + ", seatNumber="
				+ seatNumber + ", ticketStatusId=" + ticketStatusId + ", ticketStatus=" + ticketStatus + ", seatType="
				+ seatType + ", seatPrice=" + seatPrice + ", ticketOrderDetailId=" + ticketOrderDetailId
				+ ", ticketOrderId=" + ticketOrderId + ", quantity=" + quantity + ", gameDate=" + gameDate
				+ ", startTime=" + startTime + ", homeTeamId=" + homeTeamId + ", awayTeamId=" + awayTeamId
				+ ", stadiumId=" + stadiumId + ", stadiumName=" + stadiumName + ", homeTeamName=" + homeTeamName
				+ ", awayTeamName=" + awayTeamName + ", userId=" + userId + ", createdAt=" + createdAt + "]";
	}

}
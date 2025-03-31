package dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Resaleticket {

	private int gameId;
	private int seatId;
	private String seatNumber;
	private int ticketStatusId;
	private String ticketStatus;
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

	private Timestamp createdAt;

	// Constructor
	public Resaleticket(int ticketId, Date gameDate, Time startTime, String homeTeamName, String awayTeamName,
			String stadiumName, int seatPrice, String seatType, String seatNumber) {
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

	}

	public Resaleticket() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// GETTERメソッド
	private int ticketId;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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

	public String getTicketStatus() {
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Resale [ticketId=" + ticketId + ", gameId=" + gameId + ", seatId=" + seatId + ", seatNumber="
				+ seatNumber + ", ticketStatusId=" + ticketStatusId + ", ticketStatus=" + ticketStatus + ", seatType="
				+ seatType + ", seatPrice=" + seatPrice + ", ticketOrderDetailId=" + ticketOrderDetailId
				+ ", ticketOrderId=" + ticketOrderId + ", quantity=" + quantity + ", gameDate=" + gameDate
				+ ", startTime=" + startTime + ", homeTeamId=" + homeTeamId + ", awayTeamId=" + awayTeamId
				+ ", stadiumId=" + stadiumId + ", stadiumName=" + stadiumName + ", homeTeamName=" + homeTeamName
				+ ", awayTeamName=" + awayTeamName + ", userId=" + userId + ", createdAt=" + createdAt + "]";
	}

}

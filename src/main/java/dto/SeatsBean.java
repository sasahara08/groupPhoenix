package dto;

public class SeatsBean {
	private int seatId;
	private String seatType;
	private int SeatPrice;
	
	public SeatsBean(int seatId, String seatType, int seatPrice) {
		this.seatId = seatId;
		this.seatType = seatType;
		SeatPrice = seatPrice;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public int getSeatPrice() {
		return SeatPrice;
	}

	public void setSeatPrice(int seatPrice) {
		SeatPrice = seatPrice;
	}
	
	
	
	
}

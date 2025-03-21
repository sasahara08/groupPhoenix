package dto;

import java.util.Date;

public class SaleBean {
	private int gameId;
	private Date gameDate;
	private int salesValue;
	private String outSeat;
	private String nInSeat;
	private String sInSeat;
	private String backnetSeat;
	private String gameName;
	private String saleManth;
	
	
	// コンストラクタ
		public SaleBean() {
			
		}
	
	public String getSaleManth() {
		return saleManth;
	}


	public void setSaleManth(String saleManth) {
		this.saleManth = saleManth;
	}


	public String getGameName() {
		return gameName;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


	public int getGameId() {
		return gameId;
	}


	public void setGameId(int gameId) {
		this.gameId = gameId;
	}


	public Date getGameDate() {
		return gameDate;
	}


	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}


	public int getSalesValue() {
		return salesValue;
	}


	public void setSalesValue(int salesValue) {
		this.salesValue = salesValue;
	}


	public String getOutSeat() {
		return outSeat;
	}


	public void setOutSeat(String outSeat) {
		this.outSeat = outSeat;
	}


	public String getnInSeat() {
		return nInSeat;
	}


	public void setnInSeat(String nInSeat) {
		this.nInSeat = nInSeat;
	}


	public String getsInSeat() {
		return sInSeat;
	}


	public void setsInSeat(String sInSeat) {
		this.sInSeat = sInSeat;
	}


	public String getBacknetSeat() {
		return backnetSeat;
	}


	public void setBacknetSeat(String backnetSeat) {
		this.backnetSeat = backnetSeat;
	}
	
	
}

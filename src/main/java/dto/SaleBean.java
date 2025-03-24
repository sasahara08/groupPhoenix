package dto;

import java.util.Date;

public class SaleBean {
	private int gameId;
	private Date gameDate;
	private int salesValue;
	private int outSeat;
	private int nInSeat;
	private int sInSeat;
	private int backnetSeat;
	
	private int totalOutSeat;	
	private int totalNInSeat;
	private int totalSInSeat;
	private int totalBacknetSeat;
	
	//完売率
	private double outSeatSellOutRate;
	private double outSeatSellNInSeat;
	private double outSeatSellSInSeat;
	private double outSeatSellBacknetSeat;
	
	private String gameName;
	private String saleMonth;
	
	
	// コンストラクタ
		public SaleBean() {
			
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


		public int getOutSeat() {
			return outSeat;
		}


		public void setOutSeat(int outSeat) {
			this.outSeat = outSeat;
		}


		public int getnInSeat() {
			return nInSeat;
		}


		public void setnInSeat(int nInSeat) {
			this.nInSeat = nInSeat;
		}


		public int getsInSeat() {
			return sInSeat;
		}


		public void setsInSeat(int sInSeat) {
			this.sInSeat = sInSeat;
		}


		public int getBacknetSeat() {
			return backnetSeat;
		}


		public void setBacknetSeat(int backnetSeat) {
			this.backnetSeat = backnetSeat;
		}


		public int getTotalOutSeat() {
			return totalOutSeat;
		}


		public void setTotalOutSeat(int totalOutSeat) {
			this.totalOutSeat = totalOutSeat;
		}


		public int getTotalNInSeat() {
			return totalNInSeat;
		}


		public void setTotalNInSeat(int totalNInSeat) {
			this.totalNInSeat = totalNInSeat;
		}


		public int getTotalSInSeat() {
			return totalSInSeat;
		}


		public void setTotalSInSeat(int totalSInSeat) {
			this.totalSInSeat = totalSInSeat;
		}


		public int getTotalBacknetSeat() {
			return totalBacknetSeat;
		}


		public void setTotalBacknetSeat(int totalBacknetSeat) {
			this.totalBacknetSeat = totalBacknetSeat;
		}


		public double getOutSeatSellOutRate() {
			return outSeatSellOutRate;
		}


		public void setOutSeatSellOutRate(double outSeatSellOutRate) {
			this.outSeatSellOutRate = outSeatSellOutRate;
		}


		public double getOutSeatSellNInSeat() {
			return outSeatSellNInSeat;
		}


		public void setOutSeatSellNInSeat(double outSeatSellNInSeat) {
			this.outSeatSellNInSeat = outSeatSellNInSeat;
		}


		public double getOutSeatSellSInSeat() {
			return outSeatSellSInSeat;
		}


		public void setOutSeatSellSInSeat(double outSeatSellSInSeat) {
			this.outSeatSellSInSeat = outSeatSellSInSeat;
		}


		public double getOutSeatSellBacknetSeat() {
			return outSeatSellBacknetSeat;
		}


		public void setOutSeatSellBacknetSeat(double outSeatSellBacknetSeat) {
			this.outSeatSellBacknetSeat = outSeatSellBacknetSeat;
		}


		public String getGameName() {
			return gameName;
		}


		public void setGameName(String gameName) {
			this.gameName = gameName;
		}


		public String getSaleManth() {
			return saleMonth;
		}


		public void setSaleManth(String saleManth) {
			this.saleMonth = saleManth;
		}
		
	    // JSON変換メソッド
	    public String toJson() {
	        return "{" +
	                "\"saleMonth\":\"" + saleMonth + "\"," +
	                "\"salesValue\":" + salesValue + "," +
	                "\"outSeat\":" + outSeat + "," +
	                "\"nInSeat\":" + nInSeat + "," +
	                "\"sInSeat\":" + sInSeat + "," +
	                "\"backnetSeat\":" + backnetSeat + "," +
	                "\"totalOutSeat\":" + totalOutSeat + "," +
	                "\"totalNInSeat\":" + totalNInSeat + "," +
	                "\"totalSInSeat\":" + totalSInSeat + "," +
	                "\"totalBacknetSeat\":" + totalBacknetSeat + "," +
	                "\"outSeatSellOutRate\":" + outSeatSellOutRate + "," +
	                "\"outSeatSellNInSeat\":" + outSeatSellNInSeat + "," +
	                "\"outSeatSellSInSeat\":" + outSeatSellSInSeat + "," +
	                "\"outSeatSellBacknetSeat\":" + outSeatSellBacknetSeat +
	                "}";
	    }

		
}

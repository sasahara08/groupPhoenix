package dto;

public class StadiumsBean {
	private int stadiumsId;
	private String stadiumsName;
	
	public StadiumsBean(int stadiumsId, String stadiumsName) {
		this.stadiumsId = stadiumsId;
		this.stadiumsName = stadiumsName;
	}

	public StadiumsBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getStadiumsId() {
		return stadiumsId;
	}

	public void setStadiumsId(int stadiumsId) {
		this.stadiumsId = stadiumsId;
	}

	public String getStadiumsName() {
		return stadiumsName;
	}

	public void setStadiumsName(String stadiumsName) {
		this.stadiumsName = stadiumsName;
	}
	
	
}

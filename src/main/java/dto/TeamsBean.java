package dto;

public class TeamsBean {
	private int teamId;
	private String teamName;
	
	public TeamsBean(int teamId, String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}
	
	public TeamsBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	
	
	
	
}

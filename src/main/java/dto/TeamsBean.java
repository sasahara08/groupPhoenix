package dto;

public class TeamsBean {
	private int teamid;
	private String team_name;
	
	public TeamsBean(int teamid, String team_name) {
		this.teamid = teamid;
		this.team_name = team_name;
	}

	public int getTeamid() {
		return teamid;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	
	
	
	
}

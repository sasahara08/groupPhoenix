package dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class GameBean implements Serializable {

	private int gameId;
	private Date gameDate;
	private Time startTime;
	private int homeTeamId;
	private int awayTeamId;
	private int stadiumId;
	private Date gameDeleteAt;
	
	private String homeTeamName;
	private String awayTeamName;
	private String stadium;
	
	public GameBean(int gameId, Date gameDate, int homeTeamId, int awayTeamId, int stadiumId) {
		this.gameId = gameId;
		this.gameDate = gameDate;
		this.homeTeamId = homeTeamId;
		this.awayTeamId = awayTeamId;
		this.stadiumId = stadiumId;
	}

	public GameBean(int gId, Date gDay, Time gTime, String gHomeTeam, String gAwayTeam, String gStadium) {
		this.gameId = gId;
		this.gameDate = gDay;
		this.startTime = gTime;
		this.setHomeTeamName(gHomeTeam);
		this.setAwayTeamName(gAwayTeam);
		this.setStadium(gStadium);
		
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

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public int getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(int homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public int getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(int awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public int getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}

	public Date getGameDeleteAt() {
		return gameDeleteAt;
	}

	public void setGameDeleteAt(Date gameDeleteAt) {
		this.gameDeleteAt = gameDeleteAt;
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
	
	
	
	

	

}

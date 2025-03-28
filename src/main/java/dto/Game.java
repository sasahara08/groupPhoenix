package dto;

import java.sql.Date;
import java.sql.Time;

public class Game {
 private int gameId;
 private Date gameDate;
 private Time startTime;
 private int homeTeamId;
 private String homeTeamName; 
 private int awayTeamId;
 private String awayTeamName; 
 private int stadiumId;
 private String stadiumName;
 

 public Game(int gameId, Date gameDate, Time startTime, int homeTeamId, String homeTeamName, int awayTeamId, String awayTeamName, int stadiumId, String stadiumName) {
     this.gameId = gameId;
     this.gameDate = gameDate;
     this.startTime = startTime;
     this.homeTeamId = homeTeamId;
     this.homeTeamName = homeTeamName; 
     this.awayTeamId = awayTeamId;
     this.awayTeamName = awayTeamName; 
     this.stadiumId = stadiumId;
     this.setStadiumName(stadiumName);
 }

public int getGameId() {
     return gameId;
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
 
 public String getHomeTeamName() {
     return homeTeamName;
 }

 public int getAwayTeamId() {
     return awayTeamId;
 }
 
 public String getAwayTeamName() {
     return awayTeamName; 
 }


 public int getStadiumId() {
     return stadiumId;
 }

public String getStadiumName() {
	return stadiumName;
}

public void setStadiumName(String stadiumName) {
	this.stadiumName = stadiumName;
}
}

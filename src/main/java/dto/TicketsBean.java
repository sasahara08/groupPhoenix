package dto;
public class TicketsBean {  
    private int gameId;  
    private String gameDate;  
    private String startTime;  
    private String homeTeamName;  
    private String awayTeamName;  
    private String stadiumName;  

    public TicketsBean(int gameId, String gameDate, String startTime, String homeTeamName, String awayTeamName, String stadiumName) {  
        this.gameId = gameId;  
        this.gameDate = gameDate;  
        this.startTime = startTime;  
        this.homeTeamName = homeTeamName;  
        this.awayTeamName = awayTeamName;  
        this.stadiumName = stadiumName;  
    }  

    // ゲッター  
    public int getGameId() { return gameId; }  
    public String getGameDate() { return gameDate; }  
    public String getStartTime() { return startTime; }  
    public String getHomeTeamName() { return homeTeamName; }  
    public String getAwayTeamName() { return awayTeamName; }  
    public String getStadiumName() { return stadiumName; }  
}  

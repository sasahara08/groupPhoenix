package dto;

public class PlayerStatusesBean {
	private int playerStatusId;
	private String playerStatus;
	
	public PlayerStatusesBean(int playerStatusId, String playerStatus) {
		this.playerStatusId = playerStatusId;
		this.playerStatus = playerStatus;
	}

	public int getPlayerStatusId() {
		return playerStatusId;
	}

	public void setPlayerStatusId(int playerStatusId) {
		this.playerStatusId = playerStatusId;
	}

	public String getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
	}
	
	
	
	
}

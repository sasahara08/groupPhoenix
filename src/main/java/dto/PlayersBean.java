package dto;

import java.time.LocalDateTime;
import java.util.Date;

public class PlayersBean {
	private int playerId;
	private String name;
	private String kana;
	private String image;
	private Date birthday;
	private int height;
	private int weight;
	private String birthPlace;
	private String position;
	private String comment;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Date joinedAt;
	private Date endingAt;
	private int playerStatusId;
	
	public PlayersBean(int playerId, String name, String kana, String image, Date birthday, int height, int weight,
			String birthPlace, String position, String comment, LocalDateTime createdAt, LocalDateTime updatedAt,
			Date joinedAt, Date endingAt, int playerStatusId) {
		this.playerId = playerId;
		this.name = name;
		this.kana = kana;
		this.image = image;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		this.birthPlace = birthPlace;
		this.position = position;
		this.comment = comment;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.joinedAt = joinedAt;
		this.endingAt = endingAt;
		this.playerStatusId = playerStatusId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}

	public Date getEndingAt() {
		return endingAt;
	}

	public void setEndingAt(Date endingAt) {
		this.endingAt = endingAt;
	}

	public int getPlayerStatusId() {
		return playerStatusId;
	}

	public void setPlayerStatusId(int playerStatusId) {
		this.playerStatusId = playerStatusId;
	}
	
	
	
	
	
}

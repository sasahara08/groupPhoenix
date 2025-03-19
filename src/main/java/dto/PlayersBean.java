package dto;

import java.time.LocalDate;

public class PlayersBean {
    private int playerId;
    private String name;
    private String kana;
    private String image;
    private LocalDate birthday;
    private int height;
    private int weight;
    private String birthPlace;
    private String position;
    private String comment;
    private LocalDate joinedAt;
    private LocalDate endingAt;
    private int playerStatusId;
    private String playerStatus; // ステータス名

    // デフォルトコンストラクタ
    public PlayersBean() {
    }

    // 必要最低限のフィールドを使用したコンストラクタ
    public PlayersBean(int playerId, String name, String kana, String image, LocalDate birthday, int height,
                      int weight, String birthPlace, String position, String comment, int playerStatusId) {
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
        this.playerStatusId = playerStatusId;
    }

    // ゲッターとセッター
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
        // nullチェック
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("名前を入力してください。");
        }
        this.name = name;
    }

    public String getKana() {
        return kana;
    }

    public void setKana(String kana) {
        if (kana == null || kana.trim().isEmpty()) {
            throw new IllegalArgumentException("フリガナを入力してください。");
        }
        this.kana = kana;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
    public int getAge() {
        if (birthday == null) {
            return 0; // 生年月日が未設定の場合のデフォルト値
        }
        LocalDate now = LocalDate.now();
        return now.getYear() - birthday.getYear();
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("身長は正の値を入力してください。");
        }
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("体重は正の値を入力してください。");
        }
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

    public LocalDate getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDate joinedAt) {
        this.joinedAt = joinedAt;
    }

    public LocalDate getEndingAt() {
        return endingAt;
    }

    public void setEndingAt(LocalDate endingAt) {
        this.endingAt = endingAt;
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

	public void setAge(int i) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}

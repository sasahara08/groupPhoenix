package dto;

import java.time.LocalDateTime;

public class NewsBean {
	private int newsId;
	private String title;
	private String mainText;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime startAt;
	private LocalDateTime endingAt;
	
	public NewsBean(int newsId, String title, String mainText, LocalDateTime createdAt, LocalDateTime updatedAt,
			LocalDateTime startAt, LocalDateTime endingAt) {
		this.newsId = newsId;
		this.title = title;
		this.mainText = mainText;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.startAt = startAt;
		this.endingAt = endingAt;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainText() {
		return mainText;
	}

	public void setMainText(String mainText) {
		this.mainText = mainText;
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

	public LocalDateTime getStartAt() {
		return startAt;
	}

	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
	}

	public LocalDateTime getEndingAt() {
		return endingAt;
	}

	public void setEndingAt(LocalDateTime endingAt) {
		this.endingAt = endingAt;
	}
	
	
	
	
}

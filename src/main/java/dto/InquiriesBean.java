package dto;

import java.time.LocalDateTime;

public class InquiriesBean {
	private int inquiryId;
	private int userId;
	private LocalDateTime createdAt;
	private String inquiryText;
	private String responseText;
	private LocalDateTime responseAt;
	
	public InquiriesBean(int inquiryId, int userId, LocalDateTime createdAt, String inquiryText, String responseText,
			LocalDateTime responseAt) {
		this.inquiryId = inquiryId;
		this.userId = userId;
		this.createdAt = createdAt;
		this.inquiryText = inquiryText;
		this.responseText = responseText;
		this.responseAt = responseAt;
	}

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getInquiryText() {
		return inquiryText;
	}

	public void setInquiryText(String inquiryText) {
		this.inquiryText = inquiryText;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public LocalDateTime getResponseAt() {
		return responseAt;
	}

	public void setResponseAt(LocalDateTime responseAt) {
		this.responseAt = responseAt;
	}
	
	
	
	
}

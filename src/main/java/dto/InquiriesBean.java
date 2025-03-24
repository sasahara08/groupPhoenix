package dto;

import java.time.LocalDateTime;

public class InquiriesBean {
	private int inquiryId;
	private int userId;
	private LocalDateTime createdAt;
	private String inquiryText;
	private String responseText;
	private LocalDateTime responseAt;
	
//	追加
	private String name;
	private String email;
	
//	public InquiriesBean(int inquiryId, int userId, LocalDateTime createdAt, String inquiryText, String responseText,
//			LocalDateTime responseAt) {
	
//	追加nameとemailを
	public InquiriesBean(int inquiryId, int userId, LocalDateTime createdAt, String inquiryText, String responseText,
	        LocalDateTime responseAt, String name, String email) {

		this.inquiryId = inquiryId;
		this.userId = userId;
		this.createdAt = createdAt;
		this.inquiryText = inquiryText;
		this.responseText = responseText;
		this.responseAt = responseAt;
//		追加nameとemail
		this.name = name;
	    this.email = email;

	}

	public InquiriesBean() {
		// TODO 自動生成されたコンストラクター・スタブ
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
	
	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}
	
	
}

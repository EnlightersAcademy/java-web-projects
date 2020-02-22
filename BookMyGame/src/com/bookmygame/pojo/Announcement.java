package com.bookmygame.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.bookmygame.pojo.enums.AnnouncementType;

@Entity
public class Announcement {

	@Id
	private int id;
	
	private String message;
	
	private AnnouncementType announcementType;
	
	private Date messageDate;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AnnouncementType getAnnouncementType() {
		return announcementType;
	}

	public void setAnnouncementType(AnnouncementType announcementType) {
		this.announcementType = announcementType;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	
}

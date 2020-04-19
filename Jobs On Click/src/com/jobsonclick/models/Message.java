package com.jobsonclick.models;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Message")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Message_Id")
	private int messageId;
	
	@Column(name="Message_From")
	private String messageFrom;
	
	@Column(name="Message_To")
	private String messageTo;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="Status")
	private boolean status; // message read or unread where read: false and unread:true
	
	@Column(name="Deleted")
	private boolean deleted;


	@Column(name="Body")
	private String body;
	
	@Column(name="Date")
	private Date date;
	
	public Message(String messageFrom, String messageTo, String subject, String body, Date date, boolean status, boolean deleted) {
		super();
		this.messageFrom = messageFrom;
		this.messageTo = messageTo;
		this.subject = subject;
		this.body = body;
		this.date = date;
		this.status = status;
	}
	



	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}




	/**
	 * @return the deleted
	 */
	public boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the messageId
	 */
	public int getMessageId() {
		return messageId;
	}


	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	
	public Message() {
		
	}


	/**
	 * @return the from
	 */
	public String getMessageFrom() {
		return messageFrom;
	}


	/**
	 * @param from the from to set
	 */
	public void setMessageFrom(String messageFrom) {
		this.messageFrom = messageFrom;
	}


	/**
	 * @return the to
	 */
	public String getMessageTo() {
		return messageTo;
	}


	/**
	 * @param to the to to set
	 */
	public void setMessageTo(String messageTo) {
		this.messageTo = messageTo;
	}


	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}


	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}


	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}


	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", from=" + messageFrom + ", to=" + messageTo + ", subject=" + subject + ", body="
				+ body + ", date=" + date + "]";
	}
	
	

}

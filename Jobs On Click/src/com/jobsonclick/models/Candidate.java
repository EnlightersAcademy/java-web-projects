package com.jobsonclick.models;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Candidate_Id")
	private int candidateId;
	
	@Column(name="Candidate_Email")
	private String candidateEmail;
	
	@Column(name="Candidate_Name")
	private String candidateName;
	
	/**
	 * @return the candidateId
	 */
	public int getCandidateId() {
		return candidateId;
	}
	/**
	 * @param candidateId the candidateId to set
	 */
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	@Column(name="Candidate_Password")
	private String candidatePassword;
	
	@Column(name="Candidate_Summary")
	private String candidateSummary;
	
	@Column(name="Candidate_Experience")
	private String candidateExperience;
	
	@Column(name="Candidate_Skills")
	private String candidateSkills;
	
	@Column(name="Candidate_Contact")
	private String candidateContact;
	
	@Column(name="Resume")
	@Lob
	private byte[] resume;
	
	@Column(name="Profile")
	@Lob
	private byte[] profile;
	
	public Candidate() {
		
	}
	public Candidate(String candidateEmail, String candidateName, String candidatePassword, String candidateSummary,
			String candidateExperience, String candidateSkills, String candidateContact, byte[] resume, byte[] profile) {
		this.candidateEmail = candidateEmail;
		this.candidateName = candidateName;
		this.candidatePassword = candidatePassword;
		this.candidateSummary = candidateSummary;
		this.candidateExperience = candidateExperience;
		this.candidateSkills = candidateSkills;
		this.candidateContact = candidateContact;
		this.resume = resume;
		this.profile = profile;
	}
	/**
	 * @return the candidateEmail
	 */
	public String getCandidateEmail() {
		return candidateEmail;
	}
	/**
	 * @param candidateEmail the candidateEmail to set
	 */
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	/**
	 * @return the candidateName
	 */
	public String getCandidateName() {
		return candidateName;
	}
	/**
	 * @param candidateName the candidateName to set
	 */
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	/**
	 * @return the candidatePassword
	 */
	public String getCandidatePassword() {
		return candidatePassword;
	}
	/**
	 * @param candidatePassword the candidatePassword to set
	 */
	public void setCandidatePassword(String candidatePassword) {
		this.candidatePassword = candidatePassword;
	}
	/**
	 * @return the candidateSummary
	 */
	public String getCandidateSummary() {
		return candidateSummary;
	}
	/**
	 * @param candidateSummary the candidateSummary to set
	 */
	public void setCandidateSummary(String candidateSummary) {
		this.candidateSummary = candidateSummary;
	}
	/**
	 * @return the candidateExperience
	 */
	public String getCandidateExperience() {
		return candidateExperience;
	}
	/**
	 * @param candidateExperience the candidateExperience to set
	 */
	public void setCandidateExperience(String candidateExperience) {
		this.candidateExperience = candidateExperience;
	}
	/**
	 * @return the candidateSkills
	 */
	public String getCandidateSkills() {
		return candidateSkills;
	}
	/**
	 * @param candidateSkills the candidateSkills to set
	 */
	public void setCandidateSkills(String candidateSkills) {
		this.candidateSkills = candidateSkills;
	}
	/**
	 * @return the candidateContact
	 */
	public String getCandidateContact() {
		return candidateContact;
	}
	/**
	 * @param candidateContact the candidateContact to set
	 */
	public void setCandidateContact(String candidateContact) {
		this.candidateContact = candidateContact;
	}
	/**
	 * @return the resume
	 */
	public byte[] getResume() {
		return resume;
	}
	/**
	 * @param resume the resume to set
	 */
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	/**
	 * @return the profile
	 */
	public byte[] getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(byte[] profile) {
		this.profile = profile;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateEmail=" + candidateEmail + ", candidateName="
				+ candidateName + ", candidatePassword=" + candidatePassword + ", candidateSummary=" + candidateSummary
				+ ", candidateExperience=" + candidateExperience + ", candidateSkills=" + candidateSkills
				+ ", candidateContact=" + candidateContact + "]";
	}
	
	

}

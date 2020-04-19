package com.jobsonclick.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Application")
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Application_Id")
	private int applicationId;
	
	@Column(name = "Job_Id")
	private int jobId;
	
	@Column(name = "Candidate_Id")
	private int candidateId;
	
	@Column(name = "Status")
	private String status;
	
	@Transient
	private Candidate candidate;
	
	@Transient
	private Jobs job;
	
	public Application(int jobId, int candidateId, String status) {
		this.jobId = jobId;
		this.candidateId = candidateId;
		this.status = status;
	}
	
	public Application() {
		
	}

	/**
	 * @return the jobId
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the companyId
	 */
	public int getCandidateId() {
		return candidateId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	
	

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	


	/**
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate the candidate to set
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	/**
	 * @return the job
	 */
	public Jobs getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(Jobs job) {
		this.job = job;
	}

	/**
	 * @return the applicationId
	 */
	public int getApplicationId() {
		return applicationId;
	}

	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Applications [jobId=" + jobId + ", candidateId=" + candidateId + "]";
	}
	
	
}

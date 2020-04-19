package com.jobsonclick.models;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="Jobs")
public class Jobs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Job_Id")
	private int jobId;
	
	@Column(name = "Job_Title")
	private String jobTitle;
	
	@Column(name = "Job_Description")
	private String jobDescription;
	
	@Column(name = "Salary")
	private String salary;
	
	@Column(name = "Date_Of_Posting")
	private Date dateOfPosting;
	
	@Column(name = "Experience_Required")
	private String experienceRequired;
	
	@Column(name = "Job_Skills")
	private String jobSkills;
	
	@Column(name = "Expired")
	private boolean expired;
	
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH,
						})
	@JoinColumn(name="Company_Id")
	private Company company;
	
	@Transient
	private List<Application> applications;
	

	/**
	 * @return the applications
	 */
	public List<Application> getApplications() {
		return applications;
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	public Jobs() {
		
	}
	
	public Jobs(String jobTitle, String jobDescription, String salary, String experienceRequired, String jobSkills, Date dateOfPosting, boolean expired) {
		super();
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.salary = salary;
		this.experienceRequired = experienceRequired;
		this.jobSkills = jobSkills;
		this.dateOfPosting = dateOfPosting;
		this.expired = expired;
	}
	
	
	
	/**
	 * @return the dateOfPosting
	 */
	public Date getDateOfPosting() {
		return dateOfPosting;
	}


	/**
	 * @param dateOfPosting the dateOfPosting to set
	 */
	public void setDateOfPosting(Date dateOfPosting) {
		this.dateOfPosting = dateOfPosting;
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
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}
	/**
	 * @param jobDescription the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	/**
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * @return the experienceRequired
	 */
	public String getExperienceRequired() {
		return experienceRequired;
	}
	/**
	 * @param experienceRequired the experienceRequired to set
	 */
	public void setExperienceRequired(String experienceRequired) {
		this.experienceRequired = experienceRequired;
	}
	/**
	 * @return the jobSkills
	 */
	public String getJobSkills() {
		return jobSkills;
	}
	/**
	 * @param jobSkills the jobSkills to set
	 */
	public void setJobSkills(String jobSkills) {
		this.jobSkills = jobSkills;
	}


	/**
	 * @return the expired
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", salary="
				+ salary + ", experienceRequired=" + experienceRequired + ", jobSkills=" + jobSkills + "]";
	}

		

}

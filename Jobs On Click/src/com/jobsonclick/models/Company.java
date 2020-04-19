package com.jobsonclick.models;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name ="Company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Company_Id")
	private int companyId;
	
	@Column(name="Company_Name")
	private String companyName;
	
	@Column(name="Company_Description")
	private String companyDescription;
	
	@Column(name="Company_Email")
	private String companyEmail;
	
	@Column(name="Company_Password")
	private String companyPassword;
	
	@Column(name="Logo")
	@Lob
	private byte[] logo;
	
	@Column(name="Status")
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="company")
	private List<Jobs> openings;
	
	public Company() {
		
	}
	
	public Company(String companyName, String companyDescription, String companyEmail, String companyPassword,
			byte[] logo, List<Jobs> openings, String status) {
		this.companyName = companyName;
		this.companyDescription = companyDescription;
		this.companyEmail = companyEmail;
		this.companyPassword = companyPassword;
		this.logo = logo;
		this.openings = openings;
		this.status = status;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the companyDescription
	 */
	public String getCompanyDescription() {
		return companyDescription;
	}
	/**
	 * @param companyDescription the companyDescription to set
	 */
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	/**
	 * @return the companyEmail
	 */
	public String getCompanyEmail() {
		return companyEmail;
	}
	/**
	 * @return the companyId
	 */
	public int getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	/**
	 * @param companyEmail the companyEmail to set
	 */
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	/**
	 * @return the companyPassword
	 */
	public String getCompanyPassword() {
		return companyPassword;
	}
	/**
	 * @param companyPassword the companyPassword to set
	 */
	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}
	/**
	 * @return the logo
	 */
	public byte[] getLogo() {
		return logo;
	}
	/**
	 * @param logo the logo to set
	 */
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	/**
	 * @return the openings
	 */
	public List<Jobs> getOpenings() {
		return openings;
	}
	/**
	 * @param openings the openings to set
	 */
	public void setOpenings(List<Jobs> openings) {
		this.openings = openings;
	}
	/**
	 * @return the active
	 */
	public String isStatus() {
		return status;
	}

	/**
	 * @param active the active to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyDescription="
				+ companyDescription + ", companyEmail=" + companyEmail + ", companyPassword=" + companyPassword
				+ ", logo=" + logo + ", openings=" + openings + "]";
	}

	
	// add convenience method for bu-directional relationship
	
	public void add(Jobs tempJob) {
		if(openings == null) {
			openings = new ArrayList<Jobs>();
		}
		
		openings.add(tempJob);
		tempJob.setCompany(this);
	}
	
}

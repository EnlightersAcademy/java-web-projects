package com.matchmaker.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horoscope")
public class Horoscope implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String dob;
	
	private String placeOfBirth;
	
	private String timeOfBirth;
	
	@Column(name="rasi")
	private String rasi;
	
	private String nakshtra;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getTimeOfBirth() {
		return timeOfBirth;
	}

	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}

	public String getRasi() {
		return rasi;
	}

	public void setRasi(String rasi) {
		this.rasi = rasi;
	}

	public String getNakshtra() {
		return nakshtra;
	}

	public void setNakshtra(String nakshtra) {
		this.nakshtra = nakshtra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rasi == null) ? 0 : rasi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horoscope other = (Horoscope) obj;
		if (rasi == null) {
			if (other.rasi != null)
				return false;
		} else if (!rasi.equals(other.rasi))
			return false;
		return true;
	}

	
}

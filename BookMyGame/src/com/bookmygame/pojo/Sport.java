package com.bookmygame.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="sport")
public class Sport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image")
	private String image;
	
	@ElementCollection
	@CollectionTable(name="sport_facility_names_mapping",
	joinColumns= {@JoinColumn(name="sport_id")})
	@Column(name="court_or_board_names")
	private Collection<String> courtOrBoardNames = new ArrayList<>();
	
	public String getName() {
		return name;
	}	

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}

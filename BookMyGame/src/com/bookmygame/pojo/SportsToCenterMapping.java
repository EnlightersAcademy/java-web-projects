package com.bookmygame.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sports_to_center_mapping")
public class SportsToCenterMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sport_id")
	private Sport sport;
	

	public SportCenter getSportCenter() {
		return sportCenter;
	}

	public void setSportCenter(SportCenter sportCenter) {
		this.sportCenter = sportCenter;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sport_center_id")
	private SportCenter sportCenter;
	
	@Column(name="board_or_court_name")
	private String boardOrCourtName;




	public String getBoardOrCourtName() {
		return boardOrCourtName;
	}

	public void setBoardOrCourtName(String boardOrCourtName) {
		this.boardOrCourtName = boardOrCourtName;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
}

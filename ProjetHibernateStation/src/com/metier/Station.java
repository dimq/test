package com.metier;
import java.util.*;

// persistance staion

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="station")
public class Station {
	@Id
	@GeneratedValue
	@Column(name="idStation")
	private int idStation;
	
	@Column(name="libelleEmplacement")
	private String libelleEmplacement;
	@OneToMany
	@JoinColumn(name = "idStation")
	private List<Borne> lesBornes;
    // constructeur pour hibernate
	private  Station() {
		super();
	}
	
	// constructeur pour nouvelle station pour développeur
	public Station(String libelleEmplacement) {
		super();
		this.libelleEmplacement = libelleEmplacement;
		this.lesBornes =new ArrayList<Borne>();;
	}
	public String getLibelleEmplacement() {
		return libelleEmplacement;
	}
	public void setLibelleEmplacement(String libelleEmplacement) {
		this.libelleEmplacement = libelleEmplacement;
	}
	@Override
	public String toString() {
		return "Station [idStation=" + idStation + ", libelleEmplacement="
				+ libelleEmplacement + "]"+ lesBornes.size();
	}
	public List<Borne> getLesBornes() {
		return lesBornes;
	}
	public void setLesBornes(List<Borne> lesBornes) {
		this.lesBornes = lesBornes;
	}
	public int getIdStation() {
		return idStation;
	}
	// modificateur pour hibernate
	private void setIdStation(int idStation) {
		this.idStation = idStation;
	}
}

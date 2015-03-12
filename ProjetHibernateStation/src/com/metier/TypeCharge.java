package com.metier;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="typecharge")
public class TypeCharge {
	@Id
	@GeneratedValue
	@Column(name="codeTypeCharge")	
	private int codeTypeCharge;
	
	@Column(name="libelleTypeCharge")
	private String libelleTypeCharge;
	@Column(name="puissanceTypeCharge")
	private int puissanceTypeCharge;
	@OneToMany
	@JoinColumn(name = "codeTypeCharge")
	private List<Borne> listeBorne;
	
    public List<Borne> getListeBorne() {
		return listeBorne;
	}

	public void setListeBorne(List<Borne> listeBorne) {
		this.listeBorne = listeBorne;
	}

	// constructeur obligatoire pour hibernate
	private  TypeCharge() {
		super();
	}

	// constructeur pour développeur
	public TypeCharge(String libelleTypeCharge, int puissanceTypeCharge) {
		super();
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissanceTypeCharge = puissanceTypeCharge;
		this.listeBorne=new ArrayList<Borne>();
	}

	public String getLibelleTypeCharge() {
		return libelleTypeCharge;
	}
	public void setLibelleTypeCharge(String libelleTypeCharge) {
		this.libelleTypeCharge = libelleTypeCharge;
	}
	public int getPuissanceTypeCharge() {
		return puissanceTypeCharge;
	}
	public void setPuissanceTypeCharge(int puissanceTypeCharge) {
		this.puissanceTypeCharge = puissanceTypeCharge;
	}
	public int getCodeTypeCharge() {
		return codeTypeCharge;
	}
	@Override
	public String toString() {
		return "TypeCharge [codeTypeCharge=" + codeTypeCharge
				+ ", libelleTypeCharge=" + libelleTypeCharge
				+ ", puissanceTypeCharge=" + puissanceTypeCharge + "]";
	}
	public void setCodeTypeCharge(int codeTypeCharge) {
		this.codeTypeCharge = codeTypeCharge;
	}
}

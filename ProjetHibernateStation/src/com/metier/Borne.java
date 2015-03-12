package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
// entité persistante
@Entity
// nom de la table de la base de données
@Table(name="borne")
public class Borne {
	// identifiant en numéro auto , lien avec la colonne de la table
	@Id
	@GeneratedValue
	@Column(name="idBorne")	
private int idBorne;
	@Column(name="dateMiseEnService")	
private String dateMiseEnService;
	@Column(name="etat")	
private String etat;
	// lien vers un objet Station, colonne de jointure idStation
	@ManyToOne
	@JoinColumn(name="idStation")
// lien vers un objet typeCharge
private Station laStation;
	@ManyToOne
	@JoinColumn(name="codeTypeCharge")
private TypeCharge typeCharge;
// constructeur vide obligatoire pour hibernate pour qu'il puisse monter les objets
// conseillé : mettre en private si on veut qu'hibernate puisse l'utiliser sans qu'il soit un service proposé au développeur
// ne respecte pas les conventions constructeur public cependant
private Borne() {
	super();
}
// constructeur pour nouvelle borne à utiliser par le développeur
public Borne(String dateMiseEnService,Station laStation, TypeCharge typeCharge) {
	super();
	this.etat="ES";
	this.dateMiseEnService = dateMiseEnService;
	this.laStation=laStation;
	this.typeCharge = typeCharge;
}
@Override
public String toString() {
	return "Borne [idBorne=" + idBorne + ", dateMiseEnService="
			+ dateMiseEnService + ", etat=" + etat + ", idStation=" + laStation.toString()
			+ ", typeCharge=" + typeCharge.toString() + "]";
}
public Station getLaStation() {
	return laStation;
}
public void setLaStation(Station laStation) {
	this.laStation = laStation;
}
public String getDateMiseEnService() {
	return dateMiseEnService;
}
public void setDateMiseEnService(String dateMiseEnService) {
	this.dateMiseEnService = dateMiseEnService;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public TypeCharge getTypeCharge() {
	return typeCharge;
}
public void setTypeCharge(TypeCharge typeCharge) {
	this.typeCharge = typeCharge;
}
public int getIdBorne() {
	return idBorne;
}
private void setIdBorne(int idBorne) {
	this.idBorne = idBorne;
}
// accesseur privé

}

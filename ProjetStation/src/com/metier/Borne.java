package com.metier;

/**
 * Classe métier permettant d'agir sur les bornes de recharges définies par un
 * entier idBorne, une chaîne dateMiseEnService, une chaîne etat, un TypeCharge
 * et un entier identifiant de la station à la quelle elle appartient
 * 
 * @author leguen-t
 *
 */

public class Borne {
	private int idBorne;
	private String dateMiseEnService;
	private String etat;
	private TypeCharge typeCharge;
	private int station;

	/**
	 * Constructeur de Borne qui permet d'instancier des bornes de recharge
	 * 
	 * @param idBorne
	 * @param dateMiseEnService
	 * @param typeCharge
	 * @param station
	 */

	public Borne(int idBorne, String dateMiseEnService, TypeCharge typeCharge,
			int station) {
		super();
		this.idBorne = idBorne;
		this.dateMiseEnService = dateMiseEnService;
		this.etat = "ES";
		this.typeCharge = typeCharge;
		this.station = station;
	}

	/**
	 * Constructeur surchargé qui ne prend pas en compte la station à laquelle
	 * la borne appartient
	 * 
	 * @param idBorne
	 * @param dateMiseEnService
	 * @param typeCharge
	 * @see TypeCharge
	 */

	public Borne(int idBorne, String dateMiseEnService, TypeCharge typeCharge) {
		super();
		this.idBorne = idBorne;
		this.dateMiseEnService = dateMiseEnService;
		this.etat = "ES";
		this.typeCharge = typeCharge;
	}

	/**
	 * Constructeur surchargé qui ne prend pas en compte l'idBorne afin de
	 * pouvoir l'insérer dans la base de donnée (numéro Auto)
	 * 
	 * @param dateMiseEnService
	 * @param typeCharge
	 * @param station
	 * @see TypeCharge
	 */

	public Borne(String dateMiseEnService, TypeCharge typeCharge, int station) {
		super();
		this.dateMiseEnService = dateMiseEnService;
		this.typeCharge = typeCharge;
		this.station = station;
	}

	/**
	 * Accesseur sur la date de mise en service de la borne
	 * 
	 * @return une chaîne contenant la date de mise en service
	 */

	public String getDateMiseEnService() {
		return dateMiseEnService;
	}

	/**
	 * Mutateur de la date de mise en service de la borne
	 * 
	 * @param dateMiseEnService
	 */

	public void setDateMiseEnService(String dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}

	/**
	 * Accesseur sur l'état de la borne, par défaut, ES = En Service
	 * 
	 * @return une chaîne contenant l'état de la borne
	 */

	public String getEtat() {
		return etat;
	}

	/**
	 * Mutateur sur l'état de la borne
	 * 
	 * @param etat
	 */

	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * Accesseur sur le type de charge de la borne
	 * 
	 * @return un objet TypeCharge qui permet d'accéder à ses propriétés
	 * @see TypeCharge
	 */

	public TypeCharge getTypeCharge() {
		return typeCharge;
	}

	/**
	 * Mutateur sur le type de charge de la borne
	 * 
	 * @param typeCharge
	 * @see TypeCharge
	 */

	public void setTypeCharge(TypeCharge typeCharge) {
		this.typeCharge = typeCharge;
	}

	/**
	 * Accesseur sur l'identifiant de la station à laquelle la borne appartient
	 * 
	 * @return un entier représentant l'identifiant de la station
	 */

	public int getStation() {
		return station;
	}

	/**
	 * Mutateur sur l'identifiant de la station à laquelle la borne appartient
	 * 
	 * @param station
	 */

	public void setStation(int station) {
		this.station = station;
	}

	/**
	 * Accesseur sur l'identifiant de la borne
	 * 
	 * @return un entier représentant l'identifiant de la borne
	 */

	public int getIdBorne() {
		return idBorne;
	}

	/**
	 * Procédure renvoyant une chaîne contenant l'ensemble des informations de
	 * la borne ainsi que son type de charge
	 * 
	 * @return une chaîne
	 */

	public String toString() {
		return "Id Borne : " + idBorne + " Date de mise en service : "
				+ dateMiseEnService + " Etat : " + etat + "\n"
				+ typeCharge.toString();
	}
}

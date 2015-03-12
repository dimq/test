package com.metier;

import java.util.ArrayList;

/**
 * Classe métier permettant d'agir sur les stations qui gère des collections de
 * borne de recharge. Elle est définie par un idStation, un libelleEmplacement
 * ainsi qu'une collection de station
 * 
 * @author leguen-t
 *
 */

public class Station {
	private int idStation;
	private String libelleEmplacement;
	private ArrayList<Borne> lesBornes;

	/**
	 * Constructeur d'une station à partir de son id et son libelleEmplacement
	 * 
	 * @param idStation
	 * @param libelleEmplacement
	 */

	public Station(int idStation, String libelleEmplacement) {
		super();
		this.idStation = idStation;
		this.libelleEmplacement = libelleEmplacement;
		this.lesBornes = new ArrayList<Borne>();
	}

	/**
	 * Constructeur surchargé à partir de son seul libelleEmplacement
	 * 
	 * @param libelleEmplacement
	 */

	public Station(String libelleEmplacement) {
		super();
		this.libelleEmplacement = libelleEmplacement;
		this.lesBornes = new ArrayList<Borne>();
	}

	/**
	 * Accesseur sur l'identifiant d'une station
	 * 
	 * @return un entier permettant d'identifier la station
	 */

	public int getIdStation() {
		return idStation;
	}

	/**
	 * Accesseur sur le libelleEmplacement
	 * 
	 * @return retourne une chaîne contenant le libellé de l'emplacement de la
	 *         station
	 */

	public String getLibelleEmplacement() {
		return libelleEmplacement;
	}

	/**
	 * Mutateur sur le libelleEmplacement
	 * 
	 * @param libelleEmplacement
	 */

	public void setLibelleEmplacement(String libelleEmplacement) {
		this.libelleEmplacement = libelleEmplacement;
	}

	/**
	 * Accesseur sur la liste de borne contenant l'ensemble des bornes de la
	 * station
	 * 
	 * @return une ArrayList de bornes
	 */

	public ArrayList<Borne> getLesBornes() {
		return lesBornes;
	}

	/**
	 * Mutateur sur la liste des bornes de la station
	 * 
	 * @param lesBornes
	 */

	public void setLesBornes(ArrayList<Borne> lesBornes) {
		this.lesBornes = lesBornes;
	}

	/**
	 * Accesseur sur le nombre de borne contenus dans la liste de bornes
	 * 
	 * @return un entier obtenu par la propriété size() de la liste de borne.
	 */

	public int getNbBorne() {
		return lesBornes.size();
	}

	/**
	 * Procédure permettant d'ajouter une borne à la liste de borne
	 * 
	 * @param b
	 */

	public void ajoutBorne(Borne b) {
		lesBornes.add(b);
	}

	/**
	 * Fonction retournant les informations sur la station ainsi que sur ses
	 * bornes
	 * 
	 * @return une chaîne contenant toutes ces informations
	 */

	public String toString() {
		String chaineFinale = "Id Station : " + idStation
				+ " libelleEmplacement : " + libelleEmplacement;

		for (Borne b : lesBornes) {
			chaineFinale = chaineFinale + "\n" + b.toString();
		}

		return chaineFinale;
	}
}

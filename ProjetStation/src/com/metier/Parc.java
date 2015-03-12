package com.metier;

import java.util.ArrayList;

/**
 * Classe métier parc permettant d'agir sur le parc contenant un ensemble de
 * stations gérant des bornes de recharge. Elle est définie par une liste de
 * stations
 * 
 * @see Station
 * @author leguen-t
 *
 */

public class Parc {
	private ArrayList<Station> lesStations;

	/**
	 * Constructeur de Parc qui permet d'instancier un parc par sa liste de
	 * stations.
	 */

	public Parc() {
		super();
		lesStations = new ArrayList<Station>();
	}

	/**
	 * Procédure d'ajout d'une station à la liste des stations
	 * 
	 * @param s
	 */

	public void ajouterStation(Station s) {
		lesStations.add(s);
	}

	/**
	 * Accesseur sur le nombre de stations du parc
	 * 
	 * @return un entier obtenu par la méthode size() de la liste de stations
	 */

	public int getNbStation() {
		return lesStations.size();
	}

	/**
	 * Accesseur sur la liste de stations
	 * 
	 * @return une ArrayList d'objet Station
	 */

	public ArrayList<Station> getLesStations() {
		return lesStations;
	}

	/**
	 * Accesseur sur le nombre de borne de l'ensemble du parc
	 * 
	 * @return un entier obtenu par l'addition de l'ensemble des size() de la
	 *         liste de borne des stations
	 */

	public int getNbBorne() {
		int nbBorne = 0;
		for (Station s : lesStations) {
			nbBorne = s.getNbBorne() + nbBorne;
		}

		return nbBorne;
	}

	/**
	 * Fonction permettant d'accéder à une station par son id
	 * 
	 * @param id
	 * @return une ArrayList de borne attachée à la station identifiée par l'id
	 */

	public ArrayList<Borne> getLaStation(int id) {
		boolean trouver = false;
		int i = 0;
		ArrayList<Borne> listeBorne = new ArrayList<Borne>();
		while (trouver == false && i < lesStations.size()) {
			if (lesStations.get(i).getIdStation() == id) {
				trouver = true;
				listeBorne = lesStations.get(i).getLesBornes();
			} else {
				i++;
			}
		}

		return listeBorne;
	}

	/**
	 * Mutateur sur la liste de stations du parc
	 * 
	 * @param lesStations
	 */

	public void setLesStations(ArrayList<Station> lesStations) {
		this.lesStations = lesStations;
	}

	/**
	 * Fonctions permettant d'accéder à la liste des stations offrant un type de
	 * charge identifié par l'idTypeCharge passé en paramètre
	 * 
	 * @param idTypeCharge
	 * @return une ArrayList d'objet Station avec le type de charge
	 */

	public ArrayList<Station> getStationsTypeRecharge(int idTypeCharge) {
		ArrayList<Station> listeStation = new ArrayList<Station>();

		boolean trouver = false;
		int i = 0;
		int nbBorne = 0;
		for (Station s : lesStations) {
			nbBorne = s.getNbBorne();
			while (i < nbBorne && trouver == false) {
				if (s.getLesBornes().get(i).getTypeCharge().getCodeTypeCharge() == idTypeCharge) {
					trouver = true;
					listeStation.add(s);
				}
				i++;
			}
			i = 0;
			trouver = false;
		}
		return listeStation;
	}

	/**
	 * Fonction permettant d'accéder à la liste des bornes offrant le type de
	 * charge identifié par l'idTypeCharge passé en paramètre
	 * 
	 * @param idTypeCharge
	 * @return une ArrayList d'objet Borne avec le type de charge
	 */

	public ArrayList<Borne> getBorneTypeCharge(int idTypeCharge) {
		ArrayList<Borne> listeBorne = new ArrayList<Borne>();
		for (Station s : lesStations) {
			for (Borne b : s.getLesBornes()) {
				if (b.getTypeCharge().getCodeTypeCharge() == idTypeCharge) {
					listeBorne.add(b);
				}
			}
		}

		return listeBorne;
	}

	/**
	 * Fonction permettant d'accéder à une station du parc par son id passé en
	 * paramètre
	 * 
	 * @param id
	 * @return un objet Station identifié par l'id
	 */

	public Station getStation(int id) {
		boolean trouver = false;
		Station s = null;
		int i = 0;
		while (i < lesStations.size() || trouver == false) {
			if (lesStations.get(i).getIdStation() == id) {
				s = lesStations.get(i);
				trouver = true;
			}
			i++;
		}

		if (trouver == false) {
			return null;
		} else {
			return s;
		}
	}

	/**
	 * Fonction retournant une chaîne contenant l'ensemble des informations sur
	 * les stations du parc ainsi que les bornes de ces stations et leur type de
	 * charge
	 * 
	 * @return une chaîne contenant toutes ces informations
	 */

	public String toString() {
		String chaineFinale = "";
		for (Station s : lesStations) {
			chaineFinale = chaineFinale + "\n" + s.toString();
		}
		return chaineFinale;
	}
}

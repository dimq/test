package com.persistance;

import java.util.ArrayList;
import java.sql.*;
import com.metier.*;

/**
 * Classe de persistance des stations, permet d'accéder aux bornes et donc de
 * les modifier dans la base Héritant de la classe DAO. Basé sur le CRUD :
 * Create, Retrieve, Update, Delete + Find
 * 
 * @see DAO
 * @see Station
 * @author leguen-t
 *
 */

public class StationDAO extends DAO<Station> {

	/**
	 * Constructeur permettant la connexion à la base de données
	 */

	public StationDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Fonction Create qui permet d'insérer une nouvelle station dans la base de
	 * données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que l'insertion s'est bien effectuée (true
	 *         : ok, false : échec)
	 */

	@Override
	public boolean create(Station obj) {
		String sql = "INSERT INTO Station (libelleEmplacement) VALUES('"
				+ obj.getLibelleEmplacement() + "');";
		Statement requete;
		boolean execution = false;
		int nbMaj;

		try {
			requete = this.cnx.createStatement();
			nbMaj = requete.executeUpdate(sql);
			if (nbMaj <= 0) {
				execution = false;
			} else {
				execution = true;
			}
		} catch (SQLException e) {
			execution = false;
		}
		return execution;
	}

	/**
	 * Fonction Delete qui permet de supprimer une station dans la base de
	 * données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que la suppression s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	@Override
	public boolean delete(Station obj) {
		String sql = "DELETE FROM Station WHERE idStation="
				+ obj.getIdStation() + ";";
		Statement requete;
		boolean execution = false;
		int nbMaj;

		try {
			requete = this.cnx.createStatement();
			nbMaj = requete.executeUpdate(sql);
			if (nbMaj <= 0) {
				execution = false;
			} else {
			}
		} catch (SQLException e) {
		}
		return execution;
	}

	/**
	 * Fonction Update qui permet de modifier une station dans la base de
	 * données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que la mise à jour s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	@Override
	public boolean update(Station obj) {
		String sql = "UPDATE Station SET libelleEmplacement='"
				+ obj.getLibelleEmplacement() + "' WHERE idStation="
				+ obj.getIdStation() + ";";
		Statement requete;
		boolean execution = false;
		int nbMaj;

		try {
			requete = this.cnx.createStatement();
			nbMaj = requete.executeUpdate(sql);
			if (nbMaj <= 0) {
				execution = false;
			} else {
			}
		} catch (SQLException e) {
		}
		return execution;
	}

	/**
	 * Fonction Find qui permet de trouver une station à partir de son
	 * identifiant dans la base de données. Utilisé dans la fonction Retrieve
	 * afin de mieux déléguer.
	 * 
	 * @param id
	 * @return un objet Station
	 */

	@Override
	public Station find(int id) {
		Statement requete;
		ResultSet rs;
		String sql = "SELECT * FROM Station WHERE idStation=" + id + ";";
		int idStation;
		String libelleStation;
		Station s = null;
		BorneDAO bDAO = new BorneDAO();
		ArrayList<Borne> listeBorne = new ArrayList<Borne>();

		try {
			requete = this.cnx.createStatement();
			rs = requete.executeQuery(sql);
			if (rs.next()) {
				idStation = rs.getInt("idStation");
				libelleStation = rs.getString("libelleEmplacement");
				listeBorne = bDAO.retrieve(idStation);
				s = new Station(idStation, libelleStation);
				s.setLesBornes(listeBorne);
			}
		} catch (SQLException e) {

		}
		return s;
	}

	/**
	 * Fonction Retrieve qui ramène la liste des stations dans la base de
	 * données. Elle utilise la fonction Find pour construire les différents
	 * objets bornes
	 * 
	 * @return une ArrayList d'objet Station
	 */

	@Override
	public ArrayList<Station> retrieve() {
		Statement requete;
		ResultSet rs;
		String sql = "SELECT * FROM Station";
		int idStation;
		Station s = null;
		ArrayList<Station> listeStation = new ArrayList<Station>();

		try {
			requete = this.cnx.createStatement();
			rs = requete.executeQuery(sql);
			while (rs.next()) {
				idStation = rs.getInt("idStation");
				s = find(idStation);
				listeStation.add(s);
			}
		} catch (SQLException e) {

		}
		return listeStation;
	}

}

package com.persistance;

import java.util.ArrayList;
import java.sql.*;
import com.metier.*;

/**
 * Classe de persistance des bornes de recharge, permet d'accéder aux bornes et
 * donc de les modifier dans la base Héritant de la classe DAO. Basé sur le CRUD
 * : Create, Retrieve, Update, Delete + Find
 * 
 * @see DAO
 * @see Borne
 * @author leguen-t
 *
 */

public class BorneDAO extends DAO<Borne> {

	/**
	 * Constructeur généré automatiquement, hérité de la classe DAO
	 */

	public BorneDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Fonction Create qui permet d'insérer une nouvelle borne dans la base de
	 * données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que l'insertion s'est bien effectuée (true
	 *         : ok, false : échec)
	 */

	@Override
	public boolean create(Borne obj) {
		String sql = "INSERT INTO Borne (DateMiseEnService, idStation, idTypeRecharge) VALUES('"
				+ obj.getDateMiseEnService()
				+ "',"
				+ obj.getStation()
				+ ","
				+ obj.getTypeCharge().getCodeTypeCharge() + ");";
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
		}
		return execution;
	}

	/**
	 * Fonction Delete qui permet de supprimer une borne dans la base de données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que la suppression s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	@Override
	public boolean delete(Borne obj) {
		String sql = "DELETE FROM Borne WHERE idBorne=" + obj.getIdBorne()
				+ ";";
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
	 * Fonction Update qui permet de modifier une borne dans la base de données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que la mise à jour s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	@Override
	public boolean update(Borne obj) {
		String sql = "UPDATE Borne SET dateMiseEnService='"
				+ obj.getDateMiseEnService() + "', idStation="
				+ obj.getStation() + ", idTypeRecharge="
				+ obj.getTypeCharge().getCodeTypeCharge() + " WHERE idBorne=" + obj.getIdBorne() + ";";
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
	 * Fonction Find qui permet de trouver une borne à partir de son identifiant
	 * dans la base de données. Utilisé dans la fonction Retrieve afin de mieux
	 * déléguer.
	 * 
	 * @param id
	 * @return un objet Borne
	 */

	@Override
	public Borne find(int id) {
		Borne b = null;
		Statement requete;
		String sql = "SELECT * FROM Borne WHERE idBorne=" + id + ";";
		ResultSet rs;
		int idBorne;
		String dateMiseEnService;
		TypeCharge t = null;
		TypeChargeDAO tDAO = new TypeChargeDAO();
		int s = 0;
		try {
			requete = this.cnx.createStatement();
			rs = requete.executeQuery(sql);
			if (rs.next()) {
				idBorne = rs.getInt("idBorne");
				dateMiseEnService = rs.getString("dateMiseEnService");
				t = tDAO.find(rs.getInt("idTypeRecharge"));
				s = rs.getInt("idStation");
				b = new Borne(idBorne, dateMiseEnService, t, s);
			}
		} catch (SQLException e) {
		}
		return b;
	}

	/**
	 * Fonction Retrieve qui ramène la liste des bornes dans la base de données.
	 * Elle utilise la fonction Find pour construire les différents objets
	 * bornes
	 * 
	 * @return une ArrayList d'objet Borne
	 */

	@Override
	public ArrayList<Borne> retrieve() {
		// TODO Auto-generated method stub
		Statement requete;
		ResultSet rs;
		String sql = "SELECT * FROM Borne";
		int idBorne;
		Borne b = null;

		ArrayList<Borne> listeBorne = new ArrayList<Borne>();

		try {
			requete = this.cnx.createStatement();
			rs = requete.executeQuery(sql);
			while (rs.next()) {
				idBorne = rs.getInt("idBorne");
				b = find(idBorne);
				listeBorne.add(b);
			}
		} catch (SQLException e) {

		}
		return listeBorne;
	}

	/**
	 * Fonction Retrieve surchargée qui ramène la liste des bornes contenant
	 * l'id station passé en paramètre. On limite donc cette recherche
	 * 
	 * @param idStation
	 * @return une ArrayList d'objet Borne.
	 */

	public ArrayList<Borne> retrieve(int idStation) {
		// TODO Auto-generated method stub
		Statement requete;
		ResultSet rs;
		String sql = "SELECT * FROM Borne WHERE idStation=" + idStation;
		int idBorne;
		Borne b = null;
		ArrayList<Borne> listeBorne = new ArrayList<Borne>();

		try {
			requete = this.cnx.createStatement();
			rs = requete.executeQuery(sql);
			while (rs.next()) {
				idBorne = rs.getInt("idBorne");
				b = find(idBorne);
				listeBorne.add(b);
			}
		} catch (SQLException e) {

		}
		return listeBorne;
	}
}

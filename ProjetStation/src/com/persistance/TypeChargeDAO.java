package com.persistance;

import java.util.ArrayList;
import java.sql.*;

import com.metier.*;

/**
 * Classe de persistance des types de charge, permet d'accéder aux bornes et
 * donc de les modifier dans la base Héritant de la classe DAO. Basé sur le CRUD
 * : Create, Retrieve, Update, Delete + Find
 * 
 * @see DAO
 * @see TypeCharge
 * @author leguen-t
 *
 */

public class TypeChargeDAO extends DAO<TypeCharge> {

	/**
	 * Constructeur permettant l'accès aux données
	 */

	public TypeChargeDAO() {
		super();
	}

	/**
	 * Fonction Create qui permet d'insérer un nouveau type de charge dans la
	 * base de données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que l'insertion s'est bien effectuée (true
	 *         : ok, false : échec)
	 */

	@Override
	public boolean create(TypeCharge obj) {
		String sql = "INSERT INTO TypeRecharge(libelleType,puissance) VALUES ('"
				+ obj.getLibelleTypeCharge() + "'," + obj.getPuissance() + ");";
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
	 * Fonction Delete qui permet de supprimer un type de charge dans la base de
	 * données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que la suppression s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	@Override
	public boolean delete(TypeCharge obj) {
		String sql = "DELETE FROM TypeRecharge WHERE idTypeRecharge="
				+ obj.getCodeTypeCharge() + ";";
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
	 * Fonction Update qui permet de modifier un type de charge dans la base de
	 * données
	 * 
	 * @param obj
	 * @return un boolean qui vérifie que la mise à jour s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	@Override
	public boolean update(TypeCharge obj) {
		String sql = "UPDATE TypeRecharge SET libelleType='"
				+ obj.getLibelleTypeCharge() + "', puissance="
				+ obj.getPuissance() + " WHERE idTypeRecharge=" + obj.getCodeTypeCharge() + ";";
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
	 * Fonction Find qui permet de trouver un type de charge à partir de son
	 * identifiant dans la base de données. Utilisé dans la fonction Retrieve
	 * afin de mieux déléguer.
	 * 
	 * @param id
	 * @return un objet Station
	 */

	@Override
	public TypeCharge find(int id) {
		TypeCharge t = null;
		Statement requete;
		String sql;
		ResultSet rs;

		try {
			requete = this.cnx.createStatement();
			sql = "SELECT * FROM TypeRecharge WHERE idTypeRecharge = " + id
					+ ";";
			rs = requete.executeQuery(sql);
			if (rs.next()) {
				int idTypeCharge = rs.getInt("idTypeRecharge");
				String libelleType = rs.getString("libelleType");
				int puissance = rs.getInt("puissance");
				t = new TypeCharge(idTypeCharge, libelleType, puissance);
			}
		} catch (SQLException e) {
		}
		return t;
	}

	/**
	 * Fonction Retrieve qui ramène la liste des type de charge dans la base de
	 * données. Elle utilise la fonction Find pour construire les différents
	 * objets bornes
	 * 
	 * @return une ArrayList d'objet Station
	 */

	public ArrayList<TypeCharge> retrieve() {
		Statement requete;
		ResultSet rs;
		String sql = "SELECT * FROM TypeRecharge";
		int idTypeCharge;
		TypeCharge t;
		ArrayList<TypeCharge> listeCharge = new ArrayList<TypeCharge>();

		try {
			requete = this.cnx.createStatement();
			rs = requete.executeQuery(sql);
			while (rs.next()) {
				idTypeCharge = rs.getInt("idTypeRecharge");
				t = find(idTypeCharge);
				listeCharge.add(t);
			}
		} catch (SQLException e) {
		}
		return listeCharge;
	}

}

package com.persistance;

/**
 * Classe mère qui gère la connexion à la base de donnée utilisée. Propose aussi l'architecture du CRUD : Create, Retrieve, Update, Delete + Find.
 * Les autres classes DAO héritent de ses propriétés.
 */

import java.sql.Connection;
import java.util.*;

//classe DAO generique indiqu�e par DAO<T>
public abstract class DAO<T> {
	public Connection cnx = null;

	/**
	 * Constructeur DAO permettant de se connecter à la base de donnée par la
	 * DSN
	 */

	public DAO() {
		// DSN Production
		this.cnx = AccesBd.getInstance("DSN-Crab-LeGuen-t");
		// DSN Test
		// this.cnx = AccesBd.getInstance("DSN-CRAB-Test-LeGuen-t");
	}

	/**
	 * Méthode de d'insertion d'un objet dans la base de données
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(T obj);

	/**
	 * Méthode de suppression d'un objet dans la base de données
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(T obj);

	/**
	 * Méthode de mise à jour d'un objet dans la base de données
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);

	/**
	 * Fonction Find qui permet de trouver un objet à partir de son identifiant
	 * dans la base de données.
	 * 
	 * @param id
	 * @return un objet
	 */
	public abstract T find(int id);

	/**
	 * Méthode permettant d'obtenir l'ensemble d'un type d'objet dans la base de
	 * données
	 * 
	 * @return ArrayList<T>
	 */
	public abstract ArrayList<T> retrieve();
}

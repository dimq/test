package com.persistance;

import java.util.*;
import com.metier.*;

/**
 * Classe centralisant l'ensemble des accès aux données et leurs méthodes.
 * 
 * @see TypeChargeDAO
 * @see BorneDAO
 * @see StationDAO
 * @author leguen-t
 *
 */

public class AccesData {

	private static TypeChargeDAO tDAO;
	private static BorneDAO bDAO;
	private static StationDAO sDAO;

	/**
	 * Fonction retournant un objet TypeChargeDAO qui permet d'accéder aux
	 * méthodes d'accès aux types charge de la base
	 * 
	 * @return un objet TypeChargeDAO
	 * @see TypeChargeDAO
	 */

	private static TypeChargeDAO getTypeChargeDAO() {
		tDAO = new TypeChargeDAO();
		return tDAO;
	}

	/**
	 * Fonction retournant un objet BorneDAO qui permet d'accéder aux méthodes
	 * d'accès aux bornes de la base
	 * 
	 * @return un objet BorneDAO
	 * @see BorneDAO
	 */

	private static BorneDAO getBorneDAO() {
		bDAO = new BorneDAO();
		return bDAO;
	}

	/**
	 * Fonction retournant un objet StationDAO qui permet d'accéder aux méthodes
	 * d'accès aux stations de la base
	 * 
	 * @return un objet StationDAO
	 * @see StationDAO
	 */

	private static StationDAO getStationDAO() {
		sDAO = new StationDAO();
		return sDAO;
	}

	/**
	 * Fonction retournant l'ensemble des types de charge de la base de données
	 * 
	 * @return une ArrayList d'objet TypeCharge
	 */

	public static ArrayList<TypeCharge> getListeTypeCharge() {
		return getTypeChargeDAO().retrieve();
	}

	/**
	 * Fonction retournant l'ensemble des bornes de la base de données
	 * 
	 * @return une ArrayList d'objet Borne
	 */

	public static ArrayList<Borne> getListeBorne() {
		return getBorneDAO().retrieve();
	}

	/**
	 * Fonction retournant l'ensemble des stations de la base de données
	 * 
	 * @return une ArrayList d'objet Station
	 */

	public static ArrayList<Station> getListeStation() {
		return getStationDAO().retrieve();
	}

	/**
	 * Fonction retournant la liste des bornes d'une station identifiée par l'id
	 * 
	 * @param idStation
	 * @return une ArrayList d'objet Borne
	 */

	public static ArrayList<Borne> getListeBorneStation(int idStation) {
		return getBorneDAO().retrieve(idStation);
	}

	/**
	 * Fonction retournant un type de charge identifié par son id
	 * 
	 * @param idTypeCharge
	 * @return un objet TypeCharge
	 */

	public static TypeCharge getTypeCharge(int idTypeCharge) {
		return getTypeChargeDAO().find(idTypeCharge);
	}

	/**
	 * Fonction retournant une borne identifiée par son id
	 * 
	 * @param idBorne
	 * @return un objet Borne
	 */

	public static Borne getBorne(int idBorne) {
		return getBorneDAO().find(idBorne);
	}

	/**
	 * Fonction retourne une station identifiée par son id
	 * 
	 * @param idStation
	 * @return un objet Station
	 */

	public static Station getStation(int idStation) {
		return getStationDAO().find(idStation);
	}

	/**
	 * Fonction permettant d'ajouter un type de charge dans la base de données
	 * 
	 * @param t
	 * @return un boolean qui vérifie que l'insertion s'est bien effectuée (true
	 *         : ok, false : échec)
	 */

	public static boolean addTypeCharge(TypeCharge t) {
		return getTypeChargeDAO().create(t);
	}

	/**
	 * Fonction permettant de supprimer un type de charge de la base de données
	 * 
	 * @param t
	 * @return un boolean qui vérifie que la suppression s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	public static boolean deleteTypeCharge(TypeCharge t) {
		return getTypeChargeDAO().delete(t);
	}

	/**
	 * Fonction permettant de mettre à jour un type de charge de la base de
	 * données
	 * 
	 * @param t
	 * @return un boolean qui vérifie que la mise à jour s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	public static boolean updateTypeCharge(TypeCharge t) {
		return getTypeChargeDAO().update(t);
	}

	/**
	 * Fonction permettant d'ajouter une borne dans la base de données
	 * 
	 * @param b
	 * @return un boolean qui vérifie que l'insertion s'est bien effectuée (true
	 *         : ok, false : échec)
	 */

	public static boolean addBorne(Borne b) {
		return getBorneDAO().create(b);
	}

	/**
	 * Fonction permettant de supprimer une borne de la base de données
	 * 
	 * @param b
	 * @return un boolean qui vérifie que l'insertion s'est bien effectuée (true
	 *         : ok, false : échec)
	 */

	public static boolean deleteBorne(Borne b) {
		return getBorneDAO().delete(b);
	}

	/**
	 * Fonction permettant de mettre à jour une borne dans la base de données
	 * 
	 * @param b
	 * @return un boolean qui vérifie que la mise à jour s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	public static boolean updateBorne(Borne b) {
		return getBorneDAO().update(b);
	}

	/**
	 * Fonction permettant d'ajouter une station dans la base de données
	 * 
	 * @param s
	 * @return un boolean qui vérifie que l'insertion s'est bien effectuée (true
	 *         : ok, false : échec)
	 */

	public static boolean addStation(Station s) {
		return getStationDAO().create(s);
	}

	/**
	 * Fonction permettant de supprimer une station dans la base de données
	 * 
	 * @param s
	 * @return un boolean qui vérifie que la suppression s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	public static boolean deleteStation(Station s) {
		return getStationDAO().delete(s);
	}

	/**
	 * Fonction permettant de mettre à jour une station dans la base de données
	 * 
	 * @param s
	 * @return un boolean qui vérifie que la mise à jour s'est bien effectuée
	 *         (true : ok, false : échec)
	 */

	public static boolean updateStation(Station s) {
		return getStationDAO().update(s);
	}
}

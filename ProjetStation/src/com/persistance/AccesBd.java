package com.persistance;

import java.sql.*;

/**
 * Classe qui permet d'accéder à la base de données par le biais de la DSN.
 * 
 * @author leguen-t
 */

public class AccesBd {
	// description des propriétés
	private static Connection con = null;
	private static String url;

	/**
	 * Constructeur recevant le nom de la DSN. Format try/catch pour capturer
	 * les exceptions.
	 * 
	 * @param nomdsn
	 * @return un objet Connection qui permet à la classe de faire des appels de
	 *         donnée sur la base
	 */

	// constructeur reçoit en paramêtre le nom de la DSN access
	public static Connection getInstance(String nomdsn) {

		url = "jdbc:odbc:" + nomdsn;
		if (con == null) {
			try {// chargement du driver
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection(url, "", "");
			}

			// ouverture de la connexion
			catch (ClassNotFoundException e)

			{
				System.out.println(e.getMessage());
				System.out.println("échec driver");
			}

			catch (SQLException e)

			{
				System.out.println(e.getMessage());
				System.out.println("échec de connexion bd ");
			}
		}

		return con;
	}

	/**
	 * Procédure de fermeture de la connexion
	 */

	// fermeture de la connexion
	public static void close() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problème lors de la fermeture");
		}
	}
}

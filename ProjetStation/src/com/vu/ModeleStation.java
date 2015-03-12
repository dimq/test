package com.vu;

import java.util.ArrayList;
import com.metier.Station;
import javax.swing.table.AbstractTableModel;
import com.persistance.AccesData;

/**
 * Modele héritant d'AbstractTableModel permettant de mettre en forme les
 * données pour la JTable du formulaire
 * 
 * @author leguen-t
 *
 */
public class ModeleStation extends AbstractTableModel {

	/**
	 * Propriétés du modèle, le tableau entete comporte le nom des colonnes
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Station> listeStation;
	private String[] entete = { "id Station", "emplacement", "nombre de borne" };

	/**
	 * Constructeur à partir d'une liste de borne à arranger
	 * 
	 * @param listeBorne
	 */
	public ModeleStation() {
		listeStation = AccesData.getListeStation();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Fonction retournant le nombre de colonnes à partir de la taille du tablea
	 * entete
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entete.length;
	}

	/**
	 * Fonction retournant le nombre de lignes à partir de la size() de la liste
	 * de Station
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeStation.size();
	}

	/**
	 * Fonction ramenant le nom de la colonne d'index column dans le tableau
	 * entete
	 */
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return entete[column];
	}

	/**
	 * Fonction avec un switch ramenant les différentes données à mettre dans le
	 * tableau aux coordonnées passées en paramètre
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return listeStation.get(rowIndex).getIdStation();
		case 1:
			return listeStation.get(rowIndex).getLibelleEmplacement();
		case 2:
			return listeStation.get(rowIndex).getLesBornes().size();
		default:
			return null;
		}
	}
}

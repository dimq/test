package com.vu;

import java.util.ArrayList;

import com.metier.Borne;

import javax.swing.table.AbstractTableModel;

/**
 * Modele héritant d'AbstractTableModel permettant de mettre en forme les
 * données pour la JTable du formulaire
 * 
 * @author leguen-t
 *
 */

public class ModeleBorneStation extends AbstractTableModel {

	/**
	 * Propriétés du modèle, le tableau entete comporte le nom des colonnes
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Borne> listeBorne;
	private String[] entete = { "id Borne", "date", "libelle type", "puissance" };

	/**
	 * Constructeur à partir d'une liste de borne à arranger
	 * 
	 * @param listeBorne
	 */

	public ModeleBorneStation(ArrayList<Borne> listeBorne) {
		super();
		this.listeBorne = listeBorne;
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
	 * de Borne
	 */

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeBorne.size();
	}

	/**
	 * Fonction ramenant le nom de la colonne d'index column dans le tableau
	 * entete
	 */

	@Override
	public String getColumnName(int column) {
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
			return listeBorne.get(rowIndex).getIdBorne();
		case 1:
			return listeBorne.get(rowIndex).getDateMiseEnService();
		case 2:
			return listeBorne.get(rowIndex).getTypeCharge()
					.getLibelleTypeCharge();
		case 3:
			return listeBorne.get(rowIndex).getTypeCharge().getPuissance();
		default:
			return null;
		}
	}

}

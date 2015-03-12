package com.vu;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.metier.Borne;
import com.metier.Parc;

/**
 * Modele héritant d'AbstractTableModel permettant de mettre en forme les
 * données pour la JTable du formulaire
 * 
 * @author leguen-t
 *
 */
public class ModeleBorneTypeCharge extends AbstractTableModel {

	/**
	 * Propriétés du modèle, le tableau entete comporte le nom des colonnes
	 */
	private static final long serialVersionUID = 1L;
	private Parc p;
	private String[] entete = { "idBorne", "date mise en service",
			"libelle emplacement", "puissance" };
	private int codeTypeCharge;
	private ArrayList<Borne> listeBorne;

	/**
	 * Constructeur à partir d'une liste de borne à arranger
	 * 
	 * @param listeBorne
	 */
	public ModeleBorneTypeCharge(Parc p, int codeTypeCharge) {
		super();
		this.p = p;
		this.codeTypeCharge = codeTypeCharge;
		listeBorne = p.getBorneTypeCharge(codeTypeCharge);
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
		return p.getBorneTypeCharge(codeTypeCharge).size();
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
			return listeBorne.get(rowIndex).getIdBorne();
		case 1:
			return listeBorne.get(rowIndex).getDateMiseEnService();
		case 2:
			return p.getStation(listeBorne.get(rowIndex).getStation())
					.getLibelleEmplacement();
		case 3:
			return listeBorne.get(rowIndex).getTypeCharge().getPuissance();
		default:
			return null;
		}
	}
}

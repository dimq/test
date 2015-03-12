package com.modele;

import java.util.*;

import javax.swing.table.AbstractTableModel;


import com.metier.Borne;
import com.metier.Station;
import com.metier.TypeCharge;
import com.persistance.AccesData;
public class ModeleBorneTypeCharge extends AbstractTableModel {
	private final String[] entetes = { "idBorne", "date mise en service", "libelle emplacement", "puissance"};
	private List<Borne> listeTypeChargeBorne = null;

	public ModeleBorneTypeCharge(TypeCharge t) {
			listeTypeChargeBorne = t.getListeBorne();
	}
		
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return listeTypeChargeBorne.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			// idBorne
			return listeTypeChargeBorne.get(rowIndex).getIdBorne();
		case 1:
			// Date de mise en service
			return listeTypeChargeBorne.get(rowIndex).getDateMiseEnService();
		case 2:
			return listeTypeChargeBorne.get(rowIndex).getLaStation().getLibelleEmplacement();
		case 3:
			// puissance
			return listeTypeChargeBorne.get(rowIndex).getTypeCharge().getPuissanceTypeCharge();
		default:
			throw new IllegalArgumentException();
	}
	}
}


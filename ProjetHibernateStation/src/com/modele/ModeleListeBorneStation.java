package com.modele;

import javax.swing.table.AbstractTableModel;

import com.persistance.AccesData;
import java.util.*;
import com.metier.*;
public class ModeleListeBorneStation extends AbstractTableModel {
	private final String[] entetes = { "idBorne", "date mise en service", "libelle type", "puissance", "etat"};
	private List<Borne> listeBorneStation;
	public ModeleListeBorneStation(List<Borne> listeBorne) {
		listeBorneStation = listeBorne;
	}
	public List<Borne> getListeBorneStation() {
		return listeBorneStation;
	}
	public void setListeBorneStation(ArrayList<Borne> listeBorneStation) {
		this.listeBorneStation = listeBorneStation;
	}
	@Override
	public int getRowCount() {
		return listeBorneStation.size();
	}
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			// idBorne
			return listeBorneStation.get(rowIndex).getIdBorne();
		case 1:
			// Date de mise en service
			return listeBorneStation.get(rowIndex).getDateMiseEnService();
		case 2:
			// type de charge
			return listeBorneStation.get(rowIndex).getTypeCharge().getLibelleTypeCharge();
		case 3:
			// puissance
			return listeBorneStation.get(rowIndex).getTypeCharge().getPuissanceTypeCharge();
		case 4:
			// etat
			return listeBorneStation.get(rowIndex).getEtat();
		default:
			throw new IllegalArgumentException();
		}
	}
}



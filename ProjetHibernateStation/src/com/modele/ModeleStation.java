package com.modele;

import java.util.*;
import javax.swing.table.AbstractTableModel;

import com.metier.*;
import com.persistance.AccesData;
public class ModeleStation extends AbstractTableModel {
	private String[] entetes = { "idStation", "emplacement", "nombre bornes"};
	private List<Station> listeStation;
	public ModeleStation(List<Station> laListeStation) {
		listeStation=laListeStation;
	}
	@Override
	public int getRowCount() {
		return listeStation.size();
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
			// id Station
			return listeStation.get(rowIndex).getIdStation();
		case 1:
			// Emplacement
			return listeStation.get(rowIndex).getLibelleEmplacement();
		case 2:
			// Nombre de bornes
			return listeStation.get(rowIndex).getLesBornes().size();
		default:
			throw new IllegalArgumentException();
		}
	}
}

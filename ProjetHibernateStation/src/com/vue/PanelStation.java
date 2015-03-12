package com.vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.persistance.AccesData;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;

import com.metier.*;
import com.modele.ModeleStation;

import javax.swing.JTextField;

public class PanelStation extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private ModeleStation modele;
	private JLabel lblDesStations;
	private JLabel lblNombreDeStations;
	private JLabel lblNombreDeBornes;
	private JTextField txtTxtnbstation;
	private JTextField txtTxtnbborne;
	private List<Station> listeStation=null;
	/**
	 * Créer le Panel pour afficher la liste des stations
	 * fait appel au modeleStation
	 */
	public PanelStation() {

		this.setLayout(null);
		// récupération liste des stations
		listeStation=AccesData.getListeStation();
		modele=new ModeleStation(listeStation);
		this.add(getScrollPane());
		this.add(getLblDesStations());
		
		lblNombreDeStations = new JLabel("Nombre de stations ");
		lblNombreDeStations.setBounds(332, 66, 160, 14);
		add(lblNombreDeStations);
		
		lblNombreDeBornes = new JLabel("Nombre de bornes ");
		lblNombreDeBornes.setBounds(332, 91, 156, 14);
		add(lblNombreDeBornes);
		// zone de texte pour nombre de stations
		txtTxtnbstation = new JTextField();
		txtTxtnbstation.setText(Integer.toString(listeStation.size()));
		txtTxtnbstation.setBounds(498, 63, 27, 20);
		add(txtTxtnbstation);
		txtTxtnbstation.setColumns(10);
		//calcul du nombre de bornes car plus de classe Parc
		int nbBorne=0;
		// parcours pour faire le cumul
	        for (Station s : listeStation)
	        {
	           nbBorne = nbBorne + s.getLesBornes().size();
	        }
		txtTxtnbborne = new JTextField();
		txtTxtnbborne.setText(Integer.toString(nbBorne));
		txtTxtnbborne.setBounds(498, 88, 27, 20);
		add(txtTxtnbborne);
		txtTxtnbborne.setColumns(10);
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(54, 121, 438, 114);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable(modele);
		}
		return table;
	}

	public JLabel getLblDesStations() {
		if (lblDesStations == null) {
			lblDesStations = new JLabel("Liste des Stations");
			lblDesStations.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblDesStations.setBounds(139, 41, 230, 14);
		}
		return lblDesStations;
	}
}

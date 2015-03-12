package com.vu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.metier.Parc;
import com.vu.ModeleStation;

import javax.swing.JScrollPane;

/**
 * Panel contenant les différents éléments de l'interface graphique 3 Jlabel
 * statiques (décrivant les éléments du panel) 2 JLabel dynamiques (nombre de
 * station et nombre de bornes) 1 JScrollPane et 1 Jtable contenant les données
 * 
 * @author leguen-t
 *
 */
public class PanelStation extends JPanel {
	/**
	 * Propriétés du panel
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblListeDesStations;
	private ModeleStation modele;
	private JScrollPane scrollPane;
	private JTable tableStation;
	private JLabel lblNbStation;
	private JLabel lblResNbStation;
	private JLabel lblNbBorne;
	private JLabel lblResNbBorne;
	private String nbBorne;
	private String nbStation;
	private Parc parc;

	/**
	 * Create the panel. Instanciation des données
	 */
	public PanelStation(Parc p) {
		modele = new ModeleStation();
		setLayout(null);
		parc = p;
		add(getLblListeDesStations());
		add(getScrollPane());
		add(getLblNbStation());
		add(getLblResNbStation());
		add(getLblNbBorne());
		add(getLblResNbBorne());
	}

	/**
	 * Construction du label statique
	 * 
	 * @return un label
	 */

	public JLabel getLblListeDesStations() {
		if (lblListeDesStations == null) {
			lblListeDesStations = new JLabel("Liste des stations");
			lblListeDesStations.setBounds(10, 11, 156, 14);
		}
		return lblListeDesStations;
	}

	/**
	 * Construction du scroll pane, affectation de la table
	 * 
	 * @return un scroll pane
	 */

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 41, 388, 177);
			scrollPane.setViewportView(getTableStation());
		}
		return scrollPane;
	}

	/**
	 * Construction de la table, affectation d'un modele fixe
	 * 
	 * @return une JTable
	 */

	public JTable getTableStation() {
		if (tableStation == null) {
			tableStation = new JTable(modele);
		}
		return tableStation;
	}

	/**
	 * Construction d'un label statique
	 * 
	 * @return un label
	 */

	public JLabel getLblNbStation() {
		if (lblNbStation == null) {
			lblNbStation = new JLabel("Nombre de station");
			lblNbStation.setBounds(10, 231, 184, 14);
		}
		return lblNbStation;
	}

	/**
	 * Construction d'un label dynamique En fonction du nombre de station dans
	 * le parc
	 * 
	 * @return un lable
	 */

	public JLabel getLblResNbStation() {
		if (lblResNbStation == null) {
			nbStation = Integer.toString(parc.getNbStation());
			lblResNbStation = new JLabel(nbStation);
			lblResNbStation.setBounds(10, 256, 144, 14);
		}
		return lblResNbStation;
	}

	/**
	 * Construction d'un label statique
	 * 
	 * @return un label
	 */

	public JLabel getLblNbBorne() {
		if (lblNbBorne == null) {
			lblNbBorne = new JLabel("Nombre de borne");
			lblNbBorne.setBounds(10, 281, 156, 14);
		}
		return lblNbBorne;
	}

	/**
	 * Construction d'un label dynamique En fonction du nombre de borne dans le
	 * parc
	 * 
	 * @return un label
	 */

	public JLabel getLblResNbBorne() {
		if (lblResNbBorne == null) {
			nbBorne = Integer.toString(parc.getNbBorne());
			lblResNbBorne = new JLabel(nbBorne);
			lblResNbBorne.setBounds(10, 306, 156, 14);
		}
		return lblResNbBorne;
	}
}

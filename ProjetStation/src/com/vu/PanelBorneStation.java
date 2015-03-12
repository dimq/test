package com.vu;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.vu.ModeleBorneStation;
import com.metier.*;
import com.persistance.AccesData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Panel contenant les différents éléments de l'interface graphiques permettant
 * d'afficher les Bornes par station. Ici : 1 JCombobox (Station) 1 JButton
 * (supprimer) 1 JLabel (pour décrire les différents éléments) 1 JTable dans un
 * 1 JScrollPane (contenant les données sur les bornes) .
 * 
 * @author leguen-t
 *
 */
public class PanelBorneStation extends JPanel {
	/**
	 * Propriétés du panel
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableBorne;
	private JComboBox<String> cbxStation;
	private JLabel lblStation;
	private JScrollPane scrollPane;
	private ModeleBorneStation modele;
	private ArrayList<Borne> listeBorne;
	private JButton btnSupprimer;
	private Parc p;
	private Borne b;

	/**
	 * Create the panel. Reçoit le parc contenant les données en paramètre
	 * Instancie les différents éléments du panel
	 */
	public PanelBorneStation(Parc p) {
		setLayout(null);
		this.p = p;
		add(getLblStation());
		add(getScrollPane());
		add(getCbxStation());
		add(getBtnSupprimer());
		modele = null;
	}

	/**
	 * Construction de la JTable,
	 * 
	 * @return une table pour le scrollpane
	 */

	public JTable getTableBorne() {
		if (tableBorne == null) {
			tableBorne = new JTable();
			tableBorne.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					btnSupprimer.setVisible(true);
				}
			});
		}
		return tableBorne;
	}

	/**
	 * Construction de la combobox Procédure évènementielle affectant un modèle
	 * à la JTable en fonction de l'élément sélectionné dans la liste
	 * 
	 * @return une combobox
	 */

	public JComboBox<String> getCbxStation() {
		if (cbxStation == null) {
			cbxStation = new JComboBox<String>();
			for (Station s : p.getLesStations()) {
				cbxStation.addItem(s.getLibelleEmplacement());
			}

			cbxStation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cbxStation.getSelectedIndex() != -1) {
						listeBorne = p.getLesStations()
								.get(cbxStation.getSelectedIndex())
								.getLesBornes();
						modele = new ModeleBorneStation(listeBorne);
						tableBorne.setModel(modele);
					}
				}
			});
			cbxStation.setSelectedIndex(0);
			cbxStation.setBounds(233, 47, 191, 31);
		}
		return cbxStation;
	}

	/**
	 * Construction du label station
	 * 
	 * @return un label
	 */

	public JLabel getLblStation() {
		if (lblStation == null) {
			lblStation = new JLabel("Station");
			lblStation.setBounds(70, 73, 46, 14);
		}
		return lblStation;
	}

	/**
	 * Construction du scroll pane Affectation d'une table
	 * 
	 * @return un scroll pane
	 */

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(70, 121, 266, 124);
			scrollPane.setViewportView(getTableBorne());
		}
		return scrollPane;
	}

	/**
	 * Construction du bouton supprimer Il n'apparaît que lors de la sélection
	 * d'un objet de la jtable. Possibilité de supprimer donc l'élément
	 * sélectionné dans la jtable
	 * 
	 * @return
	 */

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setVisible(false);
			btnSupprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					b = p.getLesStations().get(cbxStation.getSelectedIndex())
							.getLesBornes().get(tableBorne.getSelectedRow());
					int reply = JOptionPane.showConfirmDialog(btnSupprimer,
							"êtes vous sur ?");
					if (reply == JOptionPane.YES_OPTION) {
						if (AccesData.deleteBorne(b)) {
							p.getLesStations()
									.get(cbxStation.getSelectedIndex())
									.getLesBornes()
									.remove(tableBorne.getSelectedRow());
							JOptionPane.showMessageDialog(btnSupprimer,
									"Suppression OK");
							tableBorne.revalidate();
						} else {
							JOptionPane.showMessageDialog(btnSupprimer,
									"Suppression KO");
						}
					} else {

					}
				}
			});
			btnSupprimer.setBounds(70, 266, 116, 23);
		}
		return btnSupprimer;
	}
}

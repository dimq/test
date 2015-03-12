package com.vu;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.metier.Parc;
import com.metier.TypeCharge;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Panel contenant les différents éléments de l'interface graphiques permettant
 * d'ajouter des bornes. Ici : 1 JCombobox (Type de charge) 1 JScrollPane et 1
 * JTable, 1 JLabel (pour décrire les différents éléments)
 * 
 * @author leguen-t
 *
 */
public class PanelBorneTypeCharge extends JPanel {
	/**
	 * Propriétés du panel
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane sPBorneTypeCharge;
	private JTable tBorneTypeCharge;
	private JLabel lblTypeCharge;
	private JComboBox<String> cbxBorneTypeCharge;
	private Parc parc;
	private ArrayList<TypeCharge> listeTypeCharge;
	private ModeleBorneTypeCharge modeleBTC;

	/**
	 * Create the panel. Reçoit le parc contenant les données et la liste des
	 * types de charge Instancie les différents éléments du panel
	 */
	public PanelBorneTypeCharge(ArrayList<TypeCharge> listeTypeCharge, Parc p) {
		setLayout(null);
		parc = p;
		this.listeTypeCharge = listeTypeCharge;
		add(getSPBorneTypeCharge());
		add(getLblTypeCharge());
		add(getCbxBorneTypeCharge());
		modeleBTC = null;

	}

	/**
	 * Construction du scrollpane Affectation d'une table
	 * 
	 * @return un scrollpane
	 */

	public JScrollPane getSPBorneTypeCharge() {
		if (sPBorneTypeCharge == null) {
			sPBorneTypeCharge = new JScrollPane();
			sPBorneTypeCharge.setBounds(45, 94, 434, 163);
			sPBorneTypeCharge.setViewportView(getTBorneTypeCharge());
		}
		return sPBorneTypeCharge;
	}

	/**
	 * Construction de la table Instanciation
	 * 
	 * @return une table
	 */

	public JTable getTBorneTypeCharge() {
		if (tBorneTypeCharge == null) {
			tBorneTypeCharge = new JTable();
		}
		return tBorneTypeCharge;
	}

	/**
	 * Construction du label station
	 * 
	 * @return un label
	 */

	public JLabel getLblTypeCharge() {
		if (lblTypeCharge == null) {
			lblTypeCharge = new JLabel("Type de charge");
			lblTypeCharge.setBounds(104, 46, 108, 14);
		}
		return lblTypeCharge;
	}

	/**
	 * Construction d'une combobox Remplissage avec les données de la liste de
	 * TypeCharge Procédure évènementielle qui change le modèle chargeant la
	 * table en fonction de l'index sélectionné dans la combobox
	 * 
	 * @return
	 */

	public JComboBox<String> getCbxBorneTypeCharge() {
		if (cbxBorneTypeCharge == null) {

			cbxBorneTypeCharge = new JComboBox<String>();
			for (TypeCharge t : listeTypeCharge) {
				cbxBorneTypeCharge.addItem(t.getLibelleTypeCharge());
			}
			cbxBorneTypeCharge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cbxBorneTypeCharge.getSelectedIndex() != -1) {
						modeleBTC = new ModeleBorneTypeCharge(parc,
								listeTypeCharge.get(
										cbxBorneTypeCharge.getSelectedIndex())
										.getCodeTypeCharge());
						tBorneTypeCharge.setModel(modeleBTC);
					}
				}
			});
			cbxBorneTypeCharge.setSelectedIndex(0);
			cbxBorneTypeCharge.setBounds(222, 43, 115, 20);
		}
		return cbxBorneTypeCharge;
	}
}

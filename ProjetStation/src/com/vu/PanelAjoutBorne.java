package com.vu;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.text.*;
import java.util.ArrayList;

import com.metier.*;
import com.persistance.AccesData;

/**
 * Panel contenant les différents éléments de l'interface graphiques permettant d'ajouter des bornes. Ici : deux
 * JCombobox (Station et TypeCharge) 1 JTextField (Date) 2 JButton (Annuler et
 * Valider) 3 JLabel (pour décrire les différents éléments)
 * 
 * @author leguen-t
 *
 */

public class PanelAjoutBorne extends JPanel {
	/**
	 * Propriétés du panel
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbxStation;
	private JComboBox<String> cbxTypeCharge;
	private JTextField txtDate;
	private JButton btnAnnuler;
	private JButton btnValider;
	private JLabel lblStation;
	private JLabel lblTypeDeCharge;
	private JLabel lblDateMiseEn;
	private Parc p;
	private ArrayList<TypeCharge> listeTC;
	private Borne b;

	/**
	 * Create the panel. Reçoit le parc contenant les données en paramètre
	 * Instancie les différents éléments du panel
	 */
	public PanelAjoutBorne(Parc p, ArrayList<TypeCharge> listeTC) {
		setLayout(null);
		this.p = p;
		this.listeTC = listeTC;
		add(getCbxStation());
		add(getCbxTypeCharge());
		add(getTxtDate());
		add(getBtnAnnuler());
		add(getBtnValider());
		add(getLblStation());
		add(getLblTypeDeCharge());
		add(getLblDateMiseEn());

	}

	/**
	 * Construction de la combobox pour les stations, remplissage avec chaque
	 * stations du parc
	 * 
	 * @return la combobox de chaine
	 */
	public JComboBox<String> getCbxStation() {
		if (cbxStation == null) {
			cbxStation = new JComboBox<String>();
			cbxStation.setBounds(174, 82, 170, 20);
			for (Station s : p.getLesStations()) {
				cbxStation.addItem(s.getLibelleEmplacement());
			}
			cbxStation.setSelectedIndex(0);
		}
		return cbxStation;
	}

	/**
	 * Construction de la combobox pour les types de charge, remplissage avec
	 * chaque type charge de la liste
	 * 
	 * @return la combobox de chaine
	 */

	public JComboBox<String> getCbxTypeCharge() {
		if (cbxTypeCharge == null) {
			cbxTypeCharge = new JComboBox<String>();
			cbxTypeCharge.setBounds(174, 139, 170, 20);
			for (TypeCharge t : listeTC) {
				cbxTypeCharge.addItem(t.getLibelleTypeCharge());
			}
			cbxTypeCharge.setSelectedIndex(0);
		}
		return cbxTypeCharge;
	}

	/**
	 * Construction de la zone de texte
	 * 
	 * @return une zone de texte
	 */

	public JTextField getTxtDate() {
		if (txtDate == null) {
			txtDate = new JTextField();
			txtDate.setBounds(174, 185, 170, 20);
			txtDate.setColumns(10);
		}
		return txtDate;
	}

	/**
	 * Construction du bouton annuler Procédure évènementiel annulant l'action
	 * de l'utilisateur par la remise à 0 des différent champs
	 * 
	 * @return
	 */

	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					remiseAZero();
				}
			});
			btnAnnuler.setBounds(85, 266, 89, 23);
		}
		return btnAnnuler;
	}

	/**
	 * Construction du bouton valider Procédure évènementielle permettant de
	 * valider l'action de l'utilisateur Procédure évènementielle sous forme
	 * d'un switch par rapport au résultat du contrôle de la zone de texte Ajout
	 * ou non des données dans la base de données
	 * 
	 * @return un bouton
	 */

	public JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switch (ctrlText(txtDate)) {
					case 0:
						b = new Borne(txtDate.getText(), listeTC
								.get(cbxTypeCharge.getSelectedIndex()), p
								.getLesStations()
								.get(cbxStation.getSelectedIndex())
								.getIdStation());

						if (AccesData.addBorne(b) == true) {
							JOptionPane.showMessageDialog(btnValider,
									"Ajout Effectué");
							p.setLesStations(AccesData.getListeStation());
							remiseAZero();
						} else {
							b = null;
							JOptionPane.showMessageDialog(btnValider,
									"Ajout non effectué");
						}
						break;
					case 1:
						JOptionPane.showMessageDialog(btnValider,
								"Veuillez Remplir le champs date");
						txtDate.requestFocus();
						remiseAZero();
						break;
					case 2:
						JOptionPane.showMessageDialog(btnValider,
								"Format de date non valide");
						txtDate.requestFocus();
						remiseAZero();
					}

				}
			});
			btnValider.setBounds(224, 266, 89, 23);
		}
		return btnValider;
	}

	/**
	 * Construction du label station
	 * 
	 * @return un label
	 */

	public JLabel getLblStation() {
		if (lblStation == null) {
			lblStation = new JLabel("Station");
			lblStation.setBounds(56, 85, 46, 14);
		}
		return lblStation;
	}

	/**
	 * Construction du label Type charge
	 * 
	 * @return un label
	 */

	public JLabel getLblTypeDeCharge() {
		if (lblTypeDeCharge == null) {
			lblTypeDeCharge = new JLabel("Type de Charge");
			lblTypeDeCharge.setBounds(35, 142, 129, 14);
		}
		return lblTypeDeCharge;
	}

	/**
	 * Construction du label de date de mise en service
	 * 
	 * @return un label
	 */

	public JLabel getLblDateMiseEn() {
		if (lblDateMiseEn == null) {
			lblDateMiseEn = new JLabel("Date mise en service");
			lblDateMiseEn.setBounds(22, 188, 123, 14);
		}
		return lblDateMiseEn;
	}

	/**
	 * Procédure de contrôle de la jtext field selon les différents cas d'erreur
	 * possible
	 * 
	 * @param jt
	 * @return un entier code d'erreur
	 */

	private int ctrlText(JTextField jt) {
		int test = 5;
		if (jt.getText().equals("")) {
			test = 1;
		} else {
			DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date.parse(jt.getText());
				if (estDateValide(jt.getText())) {
					test = 0;
				} else {
					test = 2;
				}
			} catch (ParseException pe) {
				test = 2;
			}
		}
		return test;

	}

	public static boolean estDateValide(String date) {

		int jj = 0, mm = 0, aaaa = 0;
		try {
			jj = Integer.parseInt(date.substring(0, 2));
			mm = Integer.parseInt(date.substring(3, 5));
			aaaa = Integer.parseInt(date.substring(6, 10));
		} catch (IndexOutOfBoundsException soobe) {
			return false;
		} catch (NumberFormatException nfe) {
			return false;
		}
		if (jj < 0 || jj > 31)
			return false;
		else if (mm < 0 || mm > 12)
			return false;
		else if (aaaa < 1900 || aaaa > 2200)
			return false;
		else {
			switch (mm) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (jj > 31)
					return false;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (jj > 30)
					return false;
				break;
			case 2:
				if (estUneAnneeBissextile(aaaa) && jj > 29) {
					return false;
				} else if (!estUneAnneeBissextile(aaaa) && jj > 28) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	}

	public static boolean estUneAnneeBissextile(int year) {
		return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
	}

	private void remiseAZero() {
		cbxStation.setSelectedIndex(0);
		cbxTypeCharge.setSelectedIndex(0);
		txtDate.setText("");
	}

	public Borne getNouvelleBorne() {
		return b;
	}
}

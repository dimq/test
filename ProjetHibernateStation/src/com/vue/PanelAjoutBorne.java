package com.vue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.util.*;
import com.metier.*;
import com.persistance.AccesData;
import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Créer le panel pour l'ajout d'une borne à une station.
 */
public class PanelAjoutBorne extends JPanel {
	private JLabel lblStation;
	private JLabel lblTypeDeCharge;
	private JLabel lblDateDeMise;
	private JButton btnAnnuler;
	private JButton btnValider;
	private JComboBox cbxStation;
	private JComboBox cbxTypeCharge;
	private JTextField textDate;
	private List<TypeCharge> listeTypeCharge;
	private List<Station> listeStation;
	public PanelAjoutBorne() {
		
		setLayout(null);
		add(getLblStation());
		add(getLblTypeDeCharge());
		add(getLblDateDeMise());
		listeTypeCharge = AccesData.getListeTypeCharge();
		listeStation=AccesData.getListeStation();
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				effacement();
			}
		});
		btnAnnuler.setBounds(253, 274, 89, 23);
		add(btnAnnuler);
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// on récupère les données du formulaire
				Station laStation = listeStation.get(cbxStation.getSelectedIndex());
				TypeCharge type = listeTypeCharge.get(cbxTypeCharge.getSelectedIndex());
				String dateMiseEnService = textDate.getText();
				// on vérifie la saisie de la date
				if (!(dateMiseEnService.equals("")) )
				{ 
					// on vérifie la validité de la date
					if (VerifDate.ConvertChaineDate(dateMiseEnService) == false)
					{
						afficheMessage("Attention cette date n'est pas valide");
						textDate.setText("");;
						textDate.requestFocus();
					}
					else
					{ 
						// on instancie l'objet Borne
						Borne b = new Borne(dateMiseEnService, laStation, type);
						// on l'ajoute à la base de données
						if (AccesData.addBorne(b)) 	{
							afficheMessage("ajout effectué");
							effacement();
						}
						else
							afficheMessage("ajout non effectué");
					}
				}
				else
				{  
					afficheMessage("Attention la date doit être saisie");
					textDate.requestFocus();
				}
			}
		});
		btnValider.setBounds(404, 274, 89, 23);
		add(btnValider);

		cbxStation = new JComboBox();
		//chargement liste déroulante station
		for(Station s:listeStation)
		{
			cbxStation.addItem(s.getLibelleEmplacement());
		}
		cbxStation.setBounds(298, 70, 169, 20);
		add(cbxStation);

		cbxTypeCharge = new JComboBox();
		// chargement liste déroulante typecharge
		for(TypeCharge t:listeTypeCharge)
		{
			cbxTypeCharge.addItem(t.getLibelleTypeCharge());
		}
		cbxTypeCharge.setBounds(299, 127, 150, 20);
		add(cbxTypeCharge);

		textDate = new JTextField();
		textDate.setBounds(298, 184, 86, 20);
		add(textDate);
		textDate.setColumns(10);

	}

	private JLabel getLblStation() {
		if (lblStation == null) {
			lblStation = new JLabel("Station");
			lblStation.setBounds(52, 73, 101, 14);
		}
		return lblStation;
	}
	private JLabel getLblTypeDeCharge() {
		if (lblTypeDeCharge == null) {
			lblTypeDeCharge = new JLabel("Type de Charge ");
			lblTypeDeCharge.setBounds(52, 130, 110, 14);
		}
		return lblTypeDeCharge;
	}
	private JLabel getLblDateDeMise() {
		if (lblDateDeMise == null) {
			lblDateDeMise = new JLabel("date de mise en service jj/mm/aaaa");
			lblDateDeMise.setBounds(52, 187, 213, 14);
		}
		return lblDateDeMise;
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	private void effacement()
	{
		cbxStation.setSelectedIndex(0);
		cbxTypeCharge.setSelectedIndex(0);
		textDate.setText("");
	}

}



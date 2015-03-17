package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.metier.*;
import com.persistance.AccesData;
public class MenuStation extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenu mnStation;
	private JMenu mnBorne;
	private JMenuItem mntmQuitter;
	private JMenuItem mntmListeStations;
	private JMenuItem mntmListeBornePar;
	private JMenuItem mntmAjoutBorne;
	private JMenuItem mntmBornesParType;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuStation frame = new MenuStation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Cr�er le formulaire avec le menu g�n�ral
	 * g�re les �v�nements du menu pour charger le panel associ�
	 */
	public MenuStation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 445);
		setTitle("Gestion station");
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		this.getContentPane().setLayout(null);
		mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFichier.add(mntmQuitter);
		mnStation = new JMenu("Station");
		menuBar.add(mnStation);
		mntmListeStations = new JMenuItem("Liste Stations");
		mntmListeStations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					affichageStation();
			}
		});
		mnStation.add(mntmListeStations);
		mnBorne = new JMenu("Borne");
		menuBar.add(mnBorne);
		mntmListeBornePar = new JMenuItem("Liste borne par station");
		mntmListeBornePar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageListeBorneStation();
			}
		});
		mnBorne.add(mntmListeBornePar);
		mntmAjoutBorne = new JMenuItem("Ajout borne");
		mntmAjoutBorne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageAjoutBorne();
			}
		});
		mnBorne.add(mntmAjoutBorne);
		mntmBornesParType = new JMenuItem("Bornes par type de charge");
		mntmBornesParType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageBorneTypeCharge();
			}
		});
		mnBorne.add(mntmBornesParType);
	}
	// instanciation des panels et rafraichissement par revalidate
	private void affichageStation() {
		this.setContentPane(new PanelStation());
		this.revalidate();
	}
	private void affichageListeBorneStation() {
		this.setContentPane(new PanelBorneStation());
		this.revalidate();
	}
	private void affichageAjoutBorne() 	{
		this.setContentPane(new PanelAjoutBorne());
		this.revalidate();
	}
	private void affichageBorneTypeCharge() {
		this.setContentPane(new PanelBorneTypeCharge());
		this.revalidate();
	}
}


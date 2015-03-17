
			}
		});
	}

	/**
	 * Create the frame. Et création du menu, chargement des données
	 */
	public FormStation() {

		setTitle("Ajout Borne");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 501);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		listeTypeCharge = AccesData.getListeTypeCharge();
		parc = new Parc();
		parc.setLesStations(AccesData.getListeStation());

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Quitter();
			}
		});
		mnFichier.add(mntmQuitter);

		JMenu mnStation = new JMenu("Station");
		mnStation.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnStation);

		JMenuItem mntmlisteStation = new JMenuItem("Liste Station");
		mntmlisteStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Station();
			}
		});
		mnStation.add(mntmlisteStation);

		JMenu mnBorne = new JMenu("Borne");
		menuBar.add(mnBorne);

		JMenuItem mntmListeBorne = new JMenuItem("Liste Borne");
		mntmListeBorne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListeBorne();
			}
		});
		mnBorne.add(mntmListeBorne);

		JMenuItem mntmAjoutBorne = new JMenuItem("Ajouter Borne");
		mntmAjoutBorne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AjoutBorne();
			}
		});
		mnBorne.add(mntmAjoutBorne);

		JMenuItem mntmBorneTypeCharge = new JMenuItem("Liste Borne Type Charge");
		mntmBorneTypeCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListeBorneTypeCharge();
			}
		});
		mnBorne.add(mntmBorneTypeCharge);
	}

	/**
	 * Prodécure pour le menu item quitter, ferme l'application
	 */

	public void Quitter() {
		System.exit(0);
	}

	/**
	 * Procédure pour instancier un PanelStation prenant un parc en paramètre
	 */

	public void Station() {
		this.setContentPane(new PanelStation(parc));
		this.revalidate();
	}

	/**
	 * Procédure pour instancier un PanelBorneStation prenant un parc en
	 * paramètre
	 */

	public void ListeBorne() {
		this.setContentPane(new PanelBorneStation(parc));
		this.revalidate();
	}

	/**
	 * Procédure pour instancier un PanelAjoutBorne prenant un parc et une liste
	 * de type de charge en paramètre
	 */

	public void AjoutBorne() {
		this.setContentPane(new PanelAjoutBorne(parc, listeTypeCharge));
		this.revalidate();
	}

	/**
	 * Procédure pour instancier un PanelBorneTypeCharge prenant une liste de
	 * type charge et un parc
	 */

	public void ListeBorneTypeCharge() {
		this.setContentPane(new PanelBorneTypeCharge(listeTypeCharge, parc));
		this.revalidate();
	}

}

package com.test;

import com.metier.TypeCharge;
import com.metier.Borne;
import com.metier.Station;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test de la classe métier Station
 * 
 * @author leguen-t
 *
 */

public class StationTest {

	TypeCharge t;
	Borne b1;
	Borne b2;
	Borne b3;
	Borne b4;
	ArrayList<Borne> listeBorne;
	ArrayList<Borne> listeTest;
	Station s;
	Station s1;

	/**
	 * Test de la procédure d'initialisation des données
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		s = new Station(1, "test");
		s1 = new Station("15/02/1993");
		t = new TypeCharge(1, "normale", 3);
		b1 = new Borne(1, "12/02/1992", t, s.getIdStation());
		b2 = new Borne(2, "13/02/1992", t, s.getIdStation());
		b3 = new Borne(3, "14/02/1992", t, s1.getIdStation());
		b4 = new Borne(4, "15/02/1992", t, s1.getIdStation());
		listeBorne = new ArrayList<Borne>();
		listeTest = new ArrayList<Borne>();
		listeBorne.add(b1);
		listeBorne.add(b2);
		listeTest.add(b3);
		listeTest.add(b4);
		s.setLesBornes(listeBorne);
	}

	/**
	 * Test de la procédure de nettoyage des données
	 * 
	 * @throws Exception
	 */

	@After
	public void tearDown() throws Exception {
		s = null;
		listeBorne.clear();
		listeBorne = null;
		b1 = null;
		b2 = null;
		t = null;
	}

	/**
	 * Test du constructeur
	 */

	@Test
	public void testStation() {
		assertNotNull("L'instance est cr�e", s);
		assertNotNull(s1);
	}

	/**
	 * Test de l'accesseur sur l'id de la station
	 */

	@Test
	public void testGetIdStation() {
		assertEquals("Est ce que l'id est correct", 1, s.getIdStation());
	}

	/**
	 * Test de l'accesseur sur le libelle emplacement
	 */

	@Test
	public void testGetLibelleEmplacement() {
		assertEquals("Est ce que le libelle est correct", "test",
				s.getLibelleEmplacement());
	}

	/**
	 * Test du mutateur sur le libelle emplacement
	 */

	@Test
	public void testSetLibelleEmplacement() {
		s.setLibelleEmplacement("test2");
		assertEquals("Est ce que le libelle est correct", "test2",
				s.getLibelleEmplacement());
	}

	/**
	 * Test de l'accesseur sur les bornes de la station
	 */

	@Test
	public void testGetLesBornes() {
		assertSame("Est ce que la liste des bornes est correcte", listeBorne,
				s.getLesBornes());
		s.getLesBornes().clear();
		assertEquals(0, s.getLesBornes().size());
	}

	/**
	 * Test du mutateur sur les bornes de la station
	 */

	@Test
	public void testSetLesBornes() {
		s.setLesBornes(listeTest);
		assertSame("Est ce que la liste des bornes est correcte", listeTest,
				s.getLesBornes());
		s.setLesBornes(null);
		assertEquals(null, s.getLesBornes());
	}

	/**
	 * Test de l'accesseur sur le nombre de borne de la station
	 */

	@Test
	public void testGetNbBorne() {
		assertEquals("Est ce que le nombre de bornes est correct",
				listeBorne.size(), s.getNbBorne());
	}

	/**
	 * Test de l'ajout de borne
	 */

	@Test
	public void testAjoutBorne() {
		s.ajoutBorne(b3);
		listeBorne.add(b3);
		assertEquals("Est ce que l'ajout de borne fonctionne", listeBorne,
				s.getLesBornes());
	}

	/**
	 * Test de la fonction d'affichage en chaine des informations de la station
	 */

	@Test
	public void testToString() {
		String chaineFinale = "Id Station : " + s.getIdStation()
				+ " libelleEmplacement : " + s.getLibelleEmplacement();
		for (Borne b : s.getLesBornes()) {
			chaineFinale = chaineFinale + "\n" + b.toString();
		}
		assertEquals("Est ce que le toString fonctionne", chaineFinale,
				s.toString());
	}

}

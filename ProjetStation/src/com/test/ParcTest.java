package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Borne;
import com.metier.Parc;
import com.metier.Station;
import com.metier.TypeCharge;

/**
 * Tests de la classe métier Parc
 * 
 * @author leguen-t
 *
 */
public class ParcTest {

	TypeCharge t1;
	TypeCharge t2;
	Borne b1;
	Borne b2;
	Borne b3;
	Borne b4;
	Borne b5;
	Borne b6;
	ArrayList<Borne> listeBorne1;
	ArrayList<Borne> listeBorne2;
	ArrayList<Borne> listeBorne3;
	ArrayList<Station> listeStation;
	ArrayList<Station> listeTestStation;
	ArrayList<Station> listeTestStationCharge;
	ArrayList<Borne> listeBorneTypeCharge;
	Station s1;
	Station s2;
	Station s3;
	Station s4;
	Parc p;

	/**
	 * Instanciation de l'ensemble des données de test
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		t1 = new TypeCharge(1, "normale", 3);
		t2 = new TypeCharge(2, "semi-rapide", 25);
		s1 = new Station(1, "test1");
		s2 = new Station(2, "test2");
		s3 = new Station(3, "test3");
		s4 = new Station(4, "test4");
		b1 = new Borne(1, "12/02/1992", t1, s1.getIdStation());
		b2 = new Borne(2, "13/02/1992", t1, s1.getIdStation());
		b3 = new Borne(3, "14/02/1992", t2, s2.getIdStation());
		b4 = new Borne(4, "15/02/1992", t2, s2.getIdStation());
		b5 = new Borne(5, "16/02/1992", t2, s3.getIdStation());
		b6 = new Borne(6, "17/02/1992", t1, s3.getIdStation());
		listeBorne1 = new ArrayList<Borne>();
		listeBorne2 = new ArrayList<Borne>();
		listeBorne3 = new ArrayList<Borne>();
		listeStation = new ArrayList<Station>();
		listeTestStation = new ArrayList<Station>();
		listeTestStationCharge = new ArrayList<Station>();
		listeBorneTypeCharge = new ArrayList<Borne>();
		listeBorneTypeCharge.add(b1);
		listeBorneTypeCharge.add(b2);
		listeBorneTypeCharge.add(b6);
		listeBorne1.add(b1);
		listeBorne1.add(b2);
		listeBorne2.add(b3);
		listeBorne2.add(b4);
		listeBorne3.add(b5);
		listeBorne3.add(b6);
		listeStation.add(s1);
		listeStation.add(s2);
		s1.setLesBornes(listeBorne1);
		s2.setLesBornes(listeBorne2);
		s3.setLesBornes(listeBorne3);
		listeTestStation.add(s3);
		listeTestStation.add(s4);
		listeTestStationCharge.add(s1);
		p = new Parc();
		p.setLesStations(listeStation);
	}

	/**
	 * nettoyage des données de test
	 * 
	 * @throws Exception
	 */

	@After
	public void tearDown() throws Exception {
		p = null;
		listeStation.clear();
		listeTestStation.clear();
		listeTestStationCharge.clear();
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		listeBorne1.clear();
		listeBorne2.clear();
		listeBorne3.clear();
		b1 = null;
		b2 = null;
		b3 = null;
		b4 = null;
		b5 = null;
		b6 = null;
	}

	/**
	 * Test du constructeur
	 */

	@Test
	public void testParc() {
		assertNotNull("L'instance est crée", p);
	}

	/**
	 * Test de l'accesseur sur les stations
	 */

	@Test
	public void testGetLesStations() {
		assertEquals("Est ce que les stations sont correcte", listeStation,
				p.getLesStations());
		listeStation.clear();
		assertEquals(0, listeStation.size());
	}

	/**
	 * Test de l'accesseur sur une station
	 */

	@Test
	public void testGetLaStation() {
		assertEquals("Est ce que l'accesseur sur une station fonctionne",
				s1.getLesBornes(), p.getLaStation(1));
		assertEquals(0, p.getLaStation(12).size());
	}

	/**
	 * Test de l'accesseur sur le nombre de station du parc
	 */

	@Test
	public void testGetNbStation() {
		assertEquals("Est ce que le nombre de station est correct", 2,
				p.getNbStation());
		listeStation.clear();
		assertEquals(0, p.getNbStation());
	}

	/**
	 * Test de l'accesseur sur le nombre de borne du parc
	 */

	@Test
	public void testGetNbBorne() {
		assertEquals("Est ce que le nombre de borne est correct", 4,
				p.getNbBorne());
		;
		listeBorne1.clear();
		listeBorne2.clear();
		assertEquals(0, p.getNbBorne());
	}

	/**
	 * Test de l'ajout de station
	 */

	@Test
	public void testAjouterStation() {
		p.ajouterStation(s3);
		assertEquals("Est ce que l'ajout de station fonctionn",
				s3.getLesBornes(), p.getLaStation(3));
		assertEquals(3, p.getNbStation());
		assertEquals(s3, p.getLesStations().get(2));
		assertEquals(s3.getIdStation(), p.getLesStations().get(2)
				.getIdStation());
	}

	/**
	 * Test du mutateur de station
	 */

	@Test
	public void testSetLesStations() {
		p.setLesStations(listeTestStation);
		assertSame("Est ce que les stations sont correctes", listeTestStation,
				p.getLesStations());
	}

	/**
	 * Test de l'accesseur sur les stations ayant un type de charge
	 */

	@Test
	public void testGetStationsTypeRecharge() {
		assertEquals("Est ce que les stations sont correctes",
				listeTestStationCharge, p.getStationsTypeRecharge(1));
		assertEquals(0, p.getStationsTypeRecharge(12).size());
	}

	/**
	 * Test de l'accesseur sur les bornes ayant un type de charge
	 */

	@Test
	public void testGetBorneTypeCharge() {
		assertEquals(p.getBorneTypeCharge(1), listeBorneTypeCharge);
	}

	/**
	 * Test de l'accesseur sur une station en particulier du parc par son id
	 */

	@Test
	public void testGetStation() {
		assertEquals(p.getStation(1), s1);
	}

	/**
	 * Test de la fonction d'affichage en chaîne
	 */

	@Test
	public void testToString() {
		String chaineFinale = "";
		for (Station s : p.getLesStations()) {
			chaineFinale = chaineFinale + "\n" + s.toString();
		}
		assertEquals("Est ce que le toString fonctionne", chaineFinale,
				p.toString());
	}

}

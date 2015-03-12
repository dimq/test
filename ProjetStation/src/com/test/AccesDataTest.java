package com.test;

import static org.junit.Assert.*;

import com.metier.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import com.persistance.AccesData;

/**
 * Classe de tests d'acces aux données
 * 
 * @author leguen-t
 *
 */
public class AccesDataTest {

	TypeCharge t1;
	TypeCharge t2;
	TypeCharge t3;
	TypeCharge tTest;
	Borne b1;
	Borne b2;
	Borne b3;
	Borne b4;
	Borne b5;
	Borne b6;
	Borne bTest;

	Station s1;
	Station s2;
	Station s3;
	Station s4;
	Station sTest;
	ArrayList<TypeCharge> listeTestTypeCharge;
	ArrayList<TypeCharge> listeTestTypeCharge2;
	ArrayList<Borne> listeTestBorne;
	ArrayList<Borne> listeTestBorne2;
	ArrayList<Station> listeTestStation;
	ArrayList<Station> listeTestStation2;
	ArrayList<Borne> listeTestBorneStation;
	ArrayList<Borne> listeTestBorneStation2;

	/**
	 * Instanciation des données
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		s1 = new Station(1, "GareMontParnasse");
		s2 = new Station(2, "Gare du Nord");
		s3 = new Station(3, "Gare de l'Est");
		s4 = new Station("Gare de Lyon");
		t1 = new TypeCharge(1, "normale", 3);
		t2 = new TypeCharge(2, "semi-rapide", 24);
		t3 = new TypeCharge(3, "rapide", 50);
		tTest = new TypeCharge("test", 50);
		listeTestTypeCharge = new ArrayList<TypeCharge>();
		listeTestTypeCharge.add(t1);
		listeTestTypeCharge.add(t2);
		listeTestTypeCharge.add(t3);
		b1 = new Borne(1, "12/12/2010", t1, s1.getIdStation());
		b2 = new Borne(2, "12/12/2011", t1, s1.getIdStation());
		b3 = new Borne(3, "25/02/2012", t2, s2.getIdStation());
		b4 = new Borne(4, "15/02/2012", t2, s2.getIdStation());
		b5 = new Borne(5, "12/12/2010", t3, s3.getIdStation());
		bTest = new Borne("12/12/2010", t1, s1.getIdStation());
		listeTestBorne = new ArrayList<Borne>();
		listeTestBorne.add(b1);
		listeTestBorne.add(b2);
		listeTestBorne.add(b3);
		listeTestBorne.add(b4);
		listeTestBorne.add(b5);
		sTest = new Station("Gare de test");
		listeTestStation = new ArrayList<Station>();
		listeTestStation.add(s1);
		listeTestStation.add(s2);
		listeTestStation.add(s3);
		listeTestBorneStation = new ArrayList<Borne>();
		listeTestBorneStation.add(b1);
		listeTestBorneStation.add(b2);
		listeTestBorneStation.add(b6);
		listeTestBorne2 = new ArrayList<Borne>();
		listeTestStation2 = new ArrayList<Station>();
		listeTestBorneStation2 = new ArrayList<Borne>();
	}

	/**
	 * Netoyage de la mémoire
	 * 
	 * @throws Exception
	 */

	@After
	public void tearDown() throws Exception {
		t1 = null;
		t2 = null;
		t3 = null;
		tTest = null;
		b1 = null;
		b2 = null;
		b3 = null;
		b4 = null;
		b5 = null;
		b6 = null;
		bTest = null;

		s1 = null;
		s2 = null;
		s3 = null;
		sTest = null;

		listeTestBorne.clear();
		listeTestBorne2.clear();
		listeTestStation.clear();
		listeTestStation2.clear();
		listeTestBorneStation.clear();
		listeTestBorneStation2.clear();
	}

	/**
	 * Test sur la liste des types de charge
	 */

	@Test
	public void testGetListeTypeCharge() {
		boolean trouver = false;
		int i = 0;
		listeTestTypeCharge2 = AccesData.getListeTypeCharge();
		for (TypeCharge t : listeTestTypeCharge2) {
			trouver = false;
			i = 0;
			while (i < listeTestTypeCharge.size() || trouver == false) {
				if (t.getCodeTypeCharge() == listeTestTypeCharge.get(i)
						.getCodeTypeCharge()) {
					assertEquals(t.getLibelleTypeCharge(), listeTestTypeCharge
							.get(i).getLibelleTypeCharge());
					assertEquals(t.getPuissance(), listeTestTypeCharge.get(i)
							.getPuissance());
					trouver = true;
				}
				i++;
			}
		}
	}

	/**
	 * Test sur la liste des bornes
	 */

	@Test
	public void testGetListeBorne() {
		boolean trouver = false;
		int i = 0;
		listeTestBorne2 = AccesData.getListeBorne();
		for (Borne b : listeTestBorne2) {
			while (i < listeTestBorne.size() || trouver == false) {
				if (b.getIdBorne() == listeTestBorne.get(i).getIdBorne()) {
					assertEquals(b.getDateMiseEnService(), listeTestBorne
							.get(i).getDateMiseEnService());
					assertEquals(listeTestBorne.get(i).getTypeCharge()
							.toString(), b.getTypeCharge().toString());
					trouver = true;
				}
				i++;
			}
		}
	}

	/**
	 * Test sur la liste des stations
	 */

	@Test
	public void testGetListeStation() {
		boolean trouver = false;
		int i = 0;
		listeTestStation2 = AccesData.getListeStation();
		for (Station s : listeTestStation2) {
			trouver = false;
			i = 0;
			while (i < listeTestStation.size() && trouver == false) {
				if (s.getIdStation() == listeTestStation.get(i).getIdStation()) {
					assertEquals(s.getLibelleEmplacement(), listeTestStation
							.get(i).getLibelleEmplacement());
					trouver = true;
				}
				i++;
			}
		}
	}

	/**
	 * Test sur la liste des bornes par station
	 */

	@Test
	public void testGetListeBorneStation() {
		boolean trouver = false;
		int i = 0;
		listeTestBorneStation2 = AccesData.getListeBorneStation(1);
		for (Borne b : listeTestBorneStation2) {
			while (i < listeTestBorneStation.size() && trouver == false) {
				if (b.getIdBorne() == listeTestBorneStation.get(i).getIdBorne()) {
					assertEquals(b.getDateMiseEnService(),
							listeTestBorneStation.get(i).getDateMiseEnService());
					assertEquals(b.getTypeCharge().toString(),
							listeTestBorneStation.get(i).getTypeCharge()
									.toString());
					trouver = true;
				}
				i++;
			}
		}
	}

	/**
	 * Test sur un type de charge
	 */

	@Test
	public void testGetTypeCharge() {
		TypeCharge t = AccesData.getTypeCharge(1);
		assertEquals(t1.getPuissance(), t.getPuissance());
	}

	/**
	 * Test sur une borne
	 */

	@Test
	public void testGetBorne() {

		assertEquals(b2.getDateMiseEnService(), AccesData.getBorne(2)
				.getDateMiseEnService());
		assertEquals(t1.toString(), AccesData.getBorne(1).getTypeCharge()
				.toString());
	}

	/**
	 * Test sur une station
	 */

	@Test
	public void testGetStation() {
		assertEquals(AccesData.getStation(1).getLibelleEmplacement(),
				s1.getLibelleEmplacement());
	}

	/**
	 * Test sur la création et la suppression de station
	 */

	@Test
	public void testAddDeleteStation() {
		assertTrue(AccesData.addStation(sTest));
		assertEquals(sTest.getLibelleEmplacement(), AccesData.getListeStation()
				.get(AccesData.getListeStation().size() - 1)
				.getLibelleEmplacement());
		int idStation=AccesData.getListeStation()
				.get(AccesData.getListeStation().size() - 1).getIdStation();
		AccesData.deleteStation(AccesData.getListeStation()
				.get(AccesData.getListeStation().size() - 1));
		assertNull(AccesData.getStation(idStation));
	}

	/**
	 * Test sur la mise à jour de station
	 */

	@Test
	public void testUpdateStation() {

		s1.setLibelleEmplacement("lol");
		AccesData.updateStation(s1);
		assertEquals(s1.getLibelleEmplacement(), AccesData.getStation(1)
				.getLibelleEmplacement());
		s1.setLibelleEmplacement("GareMontParnasse");
		AccesData.updateStation(s1);
		assertEquals(s1.getLibelleEmplacement(), AccesData.getStation(1)
				.getLibelleEmplacement());
	}

	/**
	 * Test sur l'ajout et la suppression d'un type de charge
	 */

	@Test
	public void testAddDeleteTypeCharge() {
		AccesData.addTypeCharge(tTest);
		assertEquals(
				"test",
				AccesData.getListeTypeCharge()
						.get(AccesData.getListeTypeCharge().size() - 1)
						.getLibelleTypeCharge());
		int idTypeCharge = AccesData.getListeTypeCharge()
				.get(AccesData.getListeTypeCharge().size() - 1)
				.getCodeTypeCharge();
		AccesData.deleteTypeCharge(AccesData.getListeTypeCharge()
				.get(AccesData.getListeTypeCharge().size() - 1));
		assertNull(AccesData.getTypeCharge(idTypeCharge));
		

	}

	/**
	 * Test sur la mise à jour d'un type de charge
	 */

	@Test
	public void testUpdateTypeCharge() {
		t1.setLibelleTypeCharge("Test2");
		AccesData.updateTypeCharge(t1);
		assertEquals("Test2", AccesData.getTypeCharge(t1.getCodeTypeCharge())
				.getLibelleTypeCharge());
		t1.setLibelleTypeCharge("normale");
		AccesData.updateTypeCharge(t1);
	}

	/**
	 * Test sur l'ajout et la suppression de borne
	 */

	@Test
	public void testAddDeleteBorne() {
		AccesData.addBorne(bTest);
		assertEquals(bTest.getDateMiseEnService(), AccesData.getListeBorne()
				.get(AccesData.getListeBorne().size() - 1)
				.getDateMiseEnService());
		assertTrue(AccesData.deleteBorne(AccesData.getListeBorne().get(
				AccesData.getListeBorne().size() - 1)));
	}

	/**
	 * Test sur la mise à jour de borne
	 */

	@Test
	public void testUpdateBorne() {
		b1.setDateMiseEnService("12/02/1992");
		AccesData.updateBorne(b1);
		assertEquals(b1.getDateMiseEnService(), AccesData.getBorne(1)
				.getDateMiseEnService());
		b1.setDateMiseEnService("12/12/2010");
		AccesData.updateBorne(b1);
		assertEquals(b1.getDateMiseEnService(), AccesData.getBorne(1)
				.getDateMiseEnService());
	}
}

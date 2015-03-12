package com.test;

import com.metier.Borne;
import com.metier.TypeCharge;
import com.metier.Station;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests de la classe métier borne
 * 
 * @author leguen-t
 *
 */
public class BorneTest {

	Borne b;
	Borne b1;
	TypeCharge t;
	Station s1;

	/**
	 * Préparation des données de set
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		t = new TypeCharge(1, "normale", 3);
		s1 = new Station(1, "Gare Du Nord");
		b = new Borne(1, "12/02/1992", t, 1);
		b1 = new Borne("12/02/1992", t, 1);
	}

	/**
	 * Nettoyage des données de test
	 * 
	 * @throws Exception
	 */

	@After
	public void tearDown() throws Exception {
		b = null;
		t = null;
	}

	/**
	 * Test du constructeur
	 */

	@Test
	public void testBorne() {
		assertNotNull("L'instance est cr�e", b);
		assertNotNull(b1);
	}

	/**
	 * Test sur l'idBorne
	 */

	@Test
	public void testGetIdBorne() {
		assertEquals("Est ce que l'id est correct", 1, b.getIdBorne());
		assertEquals(0, b1.getIdBorne());
	}

	/**
	 * Test sur l'accesseur de la date de mise en service
	 */

	@Test
	public void testGetDateMiseEnService() {
		assertEquals("Est ce que la date de mise en service est correcte",
				"12/02/1992", b.getDateMiseEnService());
	}

	/**
	 * Test sur le mutateur de la date de mise en service
	 */

	@Test
	public void testSetDateMiseEnService() {
		b.setDateMiseEnService("12/02/1993");
		assertEquals("Est ce que la date de mise en service est correcte",
				"12/02/1993", b.getDateMiseEnService());
	}

	/**
	 * Test sur l'accesseur de l'Etat
	 * 
	 */

	@Test
	public void testGetEtat() {
		assertEquals("Est ce que l'Etat est correct", "ES", b.getEtat());
	}

	/**
	 * Test sur le mutateur de l'Etat
	 */

	@Test
	public void testSetEtat() {
		b.setEtat("EF");
		assertEquals("Est ce que l'Etat est correct", "EF", b.getEtat());
	}

	/**
	 * Test sur l'accesseur du type de charge
	 */

	@Test
	public void testGetTypeCharge() {
		assertSame("Est ce que le type charge est correct", t,
				b.getTypeCharge());
	}

	/**
	 * Test sur le mutateur du type de charge
	 */

	@Test
	public void testSetTypeCharge() {
		TypeCharge tTest2 = new TypeCharge(2, "semi-rapide", 25);
		b.setTypeCharge(tTest2);
		assertSame("Est ce que le type charge est correct", tTest2,
				b.getTypeCharge());
	}

	/**
	 * Test sur l'accesseur de station
	 */

	@Test
	public void testGetStation() {
		assertEquals(s1.getIdStation(), b.getStation());
	}

	/**
	 * Test sur le mutateur de station
	 */
	@Test
	public void testSetStation() {
		b.setStation(4);
		assertEquals(4, b.getStation());
	}

	/**
	 * Test sur la fonction d'affichage
	 */
	@Test
	public void testToString() {
		assertEquals(
				"Est ce que la cha�ne est correct",
				"Id Borne : 1 Date de mise en service : 12/02/1992 Etat : ES\nCode Type Charge : 1 Libelle Type Charge : normale Puissance : 3",
				b.toString());
	}
}

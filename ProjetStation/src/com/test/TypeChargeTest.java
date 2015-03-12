package com.test;

import com.metier.TypeCharge;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du type de charge
 * 
 * @author leguen-t
 *
 */
public class TypeChargeTest {

	TypeCharge t;
	TypeCharge t1;

	/**
	 * Initialisation des données du type de charge
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new TypeCharge(1, "normale", 3);
		t1 = new TypeCharge("semirapide", 24);
	}

	/**
	 * Procédure de nettoyage des données
	 * 
	 * @throws Exception
	 */

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test du constructeur
	 */

	@Test
	public void testTypeCharge() {
		assertNotNull("L'instance est créee", t);
		assertNotNull("L'instance est créee", t1);
	}

	/**
	 * Test de l'accesseur sur le code type charge
	 */

	@Test
	public void testGetCodeTypeCharge() {
		assertEquals("Est ce que le code Type Charge est correct", 1,
				t.getCodeTypeCharge());
	}

	/**
	 * Test de l'accesseur sur le libellé de type charge
	 */

	@Test
	public void testGetLibelleTypeCharge() {
		assertEquals("Est ce que le Libelle Type Charge est correct",
				"normale", t.getLibelleTypeCharge());
	}

	/**
	 * Test du mutateur sur le libelle type de charge
	 */

	@Test
	public void testSetLibelleTypeCharge() {
		t.setLibelleTypeCharge("test");
		assertEquals("Est ce que le libelle type charge est correct", "test",
				t.getLibelleTypeCharge());
	}

	/**
	 * Test de l'accesseur sur la puissance
	 */

	@Test
	public void testGetPuissance() {
		assertEquals("Est ce que la puissance est correcte", 3,
				t.getPuissance());
	}

	/**
	 * Test du mutateur sur la puissance
	 */

	@Test
	public void testSetPuissance() {
		t.setPuissance(4);
		assertEquals("Est ce que la puissance est correcte", 4,
				t.getPuissance());
	}

	/**
	 * Test de l'accesseur sur la chaine contenant les informations du type de
	 * charge
	 */

	@Test
	public void testToString() {
		assertEquals(
				"Est ce que la chaine est correcte",
				"Code Type Charge : 1 Libelle Type Charge : normale Puissance : 3",
				t.toString());
	}

}

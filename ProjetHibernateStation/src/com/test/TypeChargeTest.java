package com.test;
import com.metier.Borne;
import com.metier.Station;
import com.metier.TypeCharge;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypeChargeTest {
	private TypeCharge t, t0;
	private Borne b , b0;
	private Station st1, st2;
	@Before
	public void setUp() throws Exception {
		st1=new Station("gare montparnasse");
		st2=new Station("gare de l'est");
		t=new TypeCharge("normale", 3);
		t0=new TypeCharge("semi-rapide",24);
		b = new Borne("25/09/2014" , st1 ,   t);
		b0 = new Borne("26/09/2014" , st1 , t0);
		t0=new TypeCharge("semi-rapide",24);
		}

	@After
	public void tearDown() throws Exception {
		t=null;
	}

	@Test
	public void testTypeCharge() {
		assertNotNull(t);
		assertNotNull(t0);
	}

	@Test
	public void testGetLibelleTypeCharge() {
		assertEquals("normale", t.getLibelleTypeCharge());
		assertEquals("semi-rapide", t0.getLibelleTypeCharge());
	}

	@Test
	public void testSetLibelleTypeCharge() {
		t.setLibelleTypeCharge("new normale");
		assertEquals("new normale", t.getLibelleTypeCharge());
	}

	@Test
	public void testGetPuissanceTypeCharge() {
	assertEquals(3, t.getPuissanceTypeCharge());
	assertEquals(24, t0.getPuissanceTypeCharge());
	}

	@Test
	public void testSetPuissanceTypeCharge() {
		t.setPuissanceTypeCharge(5);
		assertEquals(5, t.getPuissanceTypeCharge());
	}

	}

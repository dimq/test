package com.test;
import com.metier.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BorneTest {
	private Borne b , b0;
	private TypeCharge t1 , t2 , t3 ;
    private Station st1, st2;
	@Before
	public void setUp() throws Exception {
		t1 = new TypeCharge( "normale" , 3);
		t2 = new TypeCharge("semi-rapide" ,24);
		st1=new Station( "gare montparnasse");
		st2=new Station( "gare de l'est");
		b = new Borne("26/09/2014" , st1 , t1);
		t3 = new TypeCharge("très rapide" , 75);
	}

	@After
	public void tearDown() throws Exception {
		b = null;
		t1 = null;
		t2 = null;
	}

	@Test
	public void testBorne() {
		assertNotNull(b);
	
	}

	@Test
	public void testGetDateMiseEnService() {
		
		assertEquals("26/09/2014" , b.getDateMiseEnService());
	}

	@Test
	public void testSetDateMiseEnService() {
		b.setDateMiseEnService("26/09/2014");
		assertEquals("26/09/2014" , b.getDateMiseEnService());
	}

	@Test
	public void testGetEtat() {
		assertEquals("ES", b.getEtat());
		
	}

	@Test
	public void testSetEtat() {
		b.setEtat("HS");
		assertEquals("HS" , b.getEtat());
	}
	@Test
	public void testGetLaStation() {
		assertEquals(b.getLaStation() , st1);
		
	}
	@Test
	public void testSetLaStation() {
		b.setLaStation(st2);
		assertEquals(st2 , b.getLaStation());
	}
	@Test
	public void testGetTypeCharge() {
		assertEquals(t1 , b.getTypeCharge());
		
	}

	@Test
	public void testSetTypeCharge() {
		b.setTypeCharge(t2);
		assertEquals(t2 , b.getTypeCharge());
		
	}

	
}

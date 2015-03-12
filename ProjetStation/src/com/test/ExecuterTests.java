package com.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { TypeChargeTest.class, BorneTest.class,
		StationTest.class, ParcTest.class })
/**
 * Classe qui permet d'exécuter l'ensemble des tests de la classe métier
 * @author leguen-t
 *
 */
public class ExecuterTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		org.junit.runner.JUnitCore.main("ExecuterTest");
	}

}

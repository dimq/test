package com.test;

import junit.framework.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value={   // on note la liste des classes de test à enchainer
TypeChargeTest.class,
BorneTest.class,
StationTest.class,
AccesDataTest.class
})
public class ExecuterTest {
		
		  public static void main(String args[]) {
			  org.junit.runner.JUnitCore.main(
					  "ExecuterTests");

	}}

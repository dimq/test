package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.metier.*;
import com.persistance.*;
import java.util.*;

public class AccesDataTest {
	List<TypeCharge> listeCharge;
	List<Station> listeStation;
	List<Borne> listeBorne;
	TypeCharge t;
	Station s;
	Borne b;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@After
	public void tearDown() throws Exception {
	
	}
   
	// ordre al�atoire d'ex�cution des m�thodes de test
	// il faut donc que l'�tat initial au lancement de la m�thode soit le m�me que l'�tat final
	// cons�quence : ajout et suppression test�s dans la m�me m�thode
	// mises � jour effectu�es mais avec remise � l'�tat initial
	// ajout dans Station : collection position 0
	// ajout dans Borne et TypeCharge : collection derni�re position

	@Test
	public void testGetListeTypeCharge() {
		// r�cup�ration des types charges dans la base
		listeCharge=AccesData.getListeTypeCharge();
		// base contient 3 types charges
		// 3 utilis�s
		assertNotNull(listeCharge);
		assertEquals(listeCharge.size(),3);
		// test des valeurs des propri�t�s r�cup�r�es
		assertEquals(listeCharge.get(0).getCodeTypeCharge(), 1);
		assertEquals(listeCharge.get(0).getLibelleTypeCharge(), "recharge normale");
		assertEquals(listeCharge.get(0).getPuissanceTypeCharge(),3);
		assertEquals(listeCharge.get(1).getCodeTypeCharge(), 2);
		assertEquals(listeCharge.get(1).getLibelleTypeCharge(), "semi-rapide");
		assertEquals(listeCharge.get(1).getPuissanceTypeCharge(),24);
		assertEquals(listeCharge.get(2).getCodeTypeCharge(), 3);
		assertEquals(listeCharge.get(2).getLibelleTypeCharge(), "recharge rapide");
		assertEquals(listeCharge.get(2).getPuissanceTypeCharge(),50);
	}

	@Test
	public void testGetListeStation() {
	
		// r�cup�ration des stations dans la base
		listeStation = AccesData.getListeStation();
		// �tat initial 3 �l�ments dont 2 stations uniquement avec bornes(1 et 2)
		assertEquals(listeStation.size(),3);
		// test des informations de la station 1 qui a 2 bornes
		s=listeStation.get(0);
		assertEquals(s.getIdStation(),1);
		assertEquals(s.getLibelleEmplacement(), "Gare MontParnasse");
		listeBorne=s.getLesBornes();
		assertEquals(listeBorne.size(), 2);
		// test des informations de la station 3 en position 3 dans la collection qui a 0 borne
		s=listeStation.get(2);
		assertEquals(s.getIdStation(),3);
		assertEquals(s.getLibelleEmplacement(), "Gare de l'Est");
		listeBorne=s.getLesBornes();
		assertEquals(listeBorne.size(), 0);
	}

	@Test
	public void testGetListeBorne() {
		// r�cup�ration liste de bornes
		// 5 dans la base de donn�es
		listeBorne =AccesData.getListeBorne();
		assertEquals(listeBorne.size(), 5);
		// test des donn�es de la premi�re borne de la collection id 1
		b=listeBorne.get(0);
		assertEquals(b.getIdBorne(),1);
		assertEquals(b.getEtat(),"ES");
		assertEquals(b.getTypeCharge().getCodeTypeCharge(),1);
		assertEquals(b.getTypeCharge().getLibelleTypeCharge(),"recharge normale");
		assertEquals(b.getTypeCharge().getPuissanceTypeCharge(),3);
		}

	@Test
	public void testGetListeBorneStation() {
		// station qui existe
		listeBorne=AccesData.getListeBorneStation(1);
		assertEquals(listeBorne.size(),2);
		b=listeBorne.get(1);
		assertEquals(b.getIdBorne(),2);
		assertEquals(b.getEtat(),"ES");
		assertEquals(b.getTypeCharge().getCodeTypeCharge(),2);
		assertEquals(b.getTypeCharge().getLibelleTypeCharge(),"semi-rapide");
		assertEquals(b.getTypeCharge().getPuissanceTypeCharge(),24);
		// station qui n'existe pas, ram�ne 0 bornes
		listeBorne=AccesData.getListeBorneStation(4);
		assertEquals(listeBorne.size(),0);
		
	}
	
	@Test
	public void testGetTypeCharge() {
	
		// test sur Type charge existant code type 1
		t = AccesData.getTypeCharge(1);
		assertNotNull(t);
		assertEquals(t.getCodeTypeCharge(), 1);
		assertEquals(t.getLibelleTypeCharge(), "recharge normale");
		assertEquals(t.getPuissanceTypeCharge(), 3);
		// test sur type charge qui n'existe pas code type 5
		t=AccesData.getTypeCharge(5);
		assertEquals(t, null);
	
	}
	@Test
	public void testGetStation() {
		//station qui existe
		s = AccesData.getStation(1);
		assertNotNull(s);
		assertEquals(s.getLesBornes().size(),2);
		// station qui n'existe pas
		s = AccesData.getStation(100);
		assertNull(s);
	}
	@Test
	public void testGetBorne() {
		//borne  qui existe
		b = AccesData.getBorne(1);
		assertNotNull(b);
		assertEquals(b.getEtat(),"ES");
		assertEquals(b.getDateMiseEnService(),"12/12/2010");
		assertEquals(b.getIdBorne(),1);
		assertEquals(b.getTypeCharge().getCodeTypeCharge(),1);
		// borne qui n'existe pas
		b = AccesData.getBorne(500);
		assertNull(b);
	}
	@Test
	public void testAddDeleteTypeCharge() {
		TypeCharge t = new TypeCharge("tres rapide", 100);
		assertTrue(AccesData.addTypeCharge(t));
		// test suppression typecharge utilis�e	
		t = AccesData.getTypeCharge(2);
		assertFalse(AccesData.deleteTypeCharge(t));
		// suppresssion du dernier type charge ins�r� pour remettre la base en �tat initial
		List<TypeCharge> listeTypeCharge = AccesData.getListeTypeCharge();
		// ajout en dernier, donc on efface le dernier ajout� en size() -1
		assertTrue(AccesData.deleteTypeCharge(listeTypeCharge.get(listeTypeCharge.size()-1)));
	}
	@Test
	public void testUpdateTypeCharge() {
		// on r�cup�re un typeCharge existant
		TypeCharge t = AccesData.getTypeCharge(1);
		// on sauvegarde la valeur des propri�t�s
		String ancLibelle = t.getLibelleTypeCharge();
		int ancPuissance = t.getPuissanceTypeCharge();
		// on modifie les propri�t�s de l'objet
		t.setLibelleTypeCharge("megakg");
		t.setPuissanceTypeCharge(450);
		// on effectue la mise � jour dans la base
		assertTrue(AccesData.updateTypeCharge(t));
		// on r�cup�re l'�tat l'objet de la base
		t = AccesData.getTypeCharge(1);
		// on teste la valeur des propri�t�s modifi�es
		assertEquals(t.getLibelleTypeCharge(), "megakg");
		assertEquals(t.getPuissanceTypeCharge(),450);
		// on remet � l'�tat initial
		t.setLibelleTypeCharge(ancLibelle);
		t.setPuissanceTypeCharge(ancPuissance);
		assertTrue(AccesData.updateTypeCharge(t));
	}
	
	/*@Test
	public void testAddDeleteBorne() {
		// on ajoute une nouvelle borne
		TypeCharge t = AccesData.getTypeCharge(1);
		Borne b = new Borne("12/12/2013", 1,t);
		assertTrue(AccesData.addBorne(b));
		// onr�cup�re la liste des bornes , dernier �l�ment est le nouvel ins�r�
		List<Borne> listeBorne = AccesData.getListeBorne();
		// onsupprime le dernier
		b=listeBorne.get(listeBorne.size()-1);
			b.setTypeCharge(null);
		AccesData.deleteBorne(b);
	}
	@Test
	public void testUpdateBorne() {
	// r�cup�ration borne 1
		Borne b = AccesData.getBorne(1);
		assertEquals(b.getLaStation().getIdStation(),1 );
		assertEquals(b.getDateMiseEnService(),"12/12/2010" );
		assertEquals(b.getTypeCharge().getCodeTypeCharge(),1);
		// modification des donn�es idStation et typeCharge
		b.setIdStation(2);
		b.setTypeCharge(AccesData.getTypeCharge(3));
		// mise � jour
		assertTrue(AccesData.updateBorne(b));
		b = AccesData.getBorne(1);
		b.setIdStation(1);
		b.setTypeCharge(AccesData.getTypeCharge(1));
		// remise � l'�tat initial
		assertTrue(AccesData.updateBorne(b));
		 
	}*/
	
	@Test
	public void testAddDeleteStation() {
		// ajout station
		Station s = new Station("tests station");
		assertTrue(AccesData.addStation(s));
		// r�cup�ration liste des stations , nouvelle station en position 0 dans la liste
		List<Station> listeStation = AccesData.getListeStation();
		// suppressison de la station en premi�re position dans la liste
		// remise en l'�tat initial avant fin m�thode
		//System.out.println(listeStation.get(listeStation.size()-1).toString());
		s=listeStation.get(listeStation.size()-1);
		//System.out.println(s.toString());
		s.setLesBornes(null);
		assertTrue(AccesData.deleteStation(s));
		// suppression station li�e impossible
		s = AccesData.getStation(2);
		assertFalse(AccesData.deleteStation(s));
		
	}
	@Test
	public void testUpdateStation() {
		// r�cup�ration station 1
		Station st = AccesData.getStation(1);
		// sauvegarde ancien libelle pour r�tablissement situation en fin de m�thode
		String ancValeur = st.getLibelleEmplacement();
		// modification libelle
		String nouvelleValeur = "gare test";
		st.setLibelleEmplacement(nouvelleValeur);
	//	st.getLesBornes().clear();
		System.out.println(st.getIdStation()+"");
		assertTrue(AccesData.updateStation(st));
		// acc�s en lecture pour rafraichissement
		st = AccesData.getStation(1);
		// remise � l'�tat initial
				st.setLibelleEmplacement(ancValeur);
				assertTrue(AccesData.updateStation(st));
	}
}



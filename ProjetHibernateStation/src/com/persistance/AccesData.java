package com.persistance;
import com.metier.*;

import java.util.*;

import com.util.*;
import com.util.HibernateSession;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.*;

import com.metier.*;



public class AccesData {
	private static  Session s = HibernateSession.getSession();
	private static Transaction trans=null;
	// accesseurs sur listes d'objets
	public static List<TypeCharge> getListeTypeCharge()
	{
		s = HibernateSession.getSession();
		return  s.createQuery("from TypeCharge").list();
		
	}
	public static List<Station> getListeStation()
	{
		return  s.createQuery("from Station").list();
	}
	public static List<Borne> getListeBorne()
	{
		return  s.createQuery("from Borne").list();
	}
	public static List<Borne> getListeBorneStation(int idStation)
	{
		return  s.createQuery("from Borne where idStation="+idStation).list();
	}
	public static TypeCharge getTypeCharge(int idType)
	{
		TypeCharge t=null;
		t=(TypeCharge) s.get(TypeCharge.class, idType);
		return t;
	}
	
		
	public static boolean addTypeCharge(TypeCharge t)
	{
		boolean ok=false;
	try {
	
		trans=s.beginTransaction();
		s.save(t);
		trans.commit();
		s.flush();
		ok=true;
	} catch (HibernateException e) {
	 trans.rollback();
	}
	return ok;
	}
	public static boolean deleteTypeCharge(TypeCharge t)
	{
		boolean ok=false;
	try {
		
		trans=s.beginTransaction();
		s.delete(t);
		trans.commit();
		s.flush();
		ok=true;
	} catch (HibernateException e) {
		 trans.rollback();
	}
	return ok;
	}
	public static boolean updateTypeCharge(TypeCharge t)
	{
		boolean ok=false;
	try {
		trans=s.beginTransaction();
		s.update(t);
		trans.commit();
		ok=true;
	} catch (HibernateException e) {
		 trans.rollback();
	}
	return ok;
	}
	
	public static Station getStation(int idStation)
	{
		Station sta=null;
		sta=(Station) s.get(Station.class, idStation);
		return sta;
	}
	public static Borne getBorne(int idBorne)
	{
		Borne b=null;
		b=(Borne) s.get(Borne.class, idBorne);
		return b;
	}
	public static boolean addBorne(Borne b)
	{
		boolean ok=false;
	try {
		trans=s.beginTransaction();
		s.save(b);
		trans.commit();
		ok=true;
	} catch (HibernateException e) {
		 trans.rollback();
	}
	return ok;
	}
	public static boolean addStation(Station st)
	{
		boolean ok=false;
		try {
			trans=s.beginTransaction();
			s.save(st);
			trans.commit();
			ok=true;
		} catch (HibernateException e) {
			 trans.rollback();
		}
		return ok;
	}
	public static boolean deleteStation(Station st)
	{
		boolean ok=false;
		try {
			trans=s.beginTransaction();
			s.delete(st);
			trans.commit();
			ok=true;
		} catch (HibernateException e) {
			 trans.rollback();
		}
		return ok;
	}
	public static boolean updateStation(Station st)
	{
		boolean ok=false;
		try {
			trans=s.beginTransaction();
			s.update(st);
			trans.commit();
			ok=true;
		} catch (HibernateException e) {
			 trans.rollback();
		}
		return ok;
	}
	
	public static boolean deleteBorne(Borne b)
	{
		boolean ok=false;
		try {
			trans=s.beginTransaction();
			s.delete(b);
			trans.commit();
			ok=true;
		} catch (HibernateException e) {
			 trans.rollback();
		}
		return ok;
	}
	public static boolean updateBorne(Borne b)
	{
		boolean ok=false;
		try {
			
			trans=s.beginTransaction();
			s.update(b);
			trans.commit();
			ok=true;
		} catch (HibernateException e) {
			 trans.rollback();
		}
		return ok;
	}


	

}

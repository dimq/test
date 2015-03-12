package com.util;

import java.util.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VerifDate {
public static boolean ConvertChaineDate(String uneDate)
{ 
	boolean verif=false;
	// déclaration d'un format de date
	DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	// on essaie de parser la date
	try {
		// on vérifie le format dd/mm/aaaa
		date.setLenient(false);
		date.parse(uneDate);
		verif=true;
	} 
	catch (ParseException e) 
	{
		return false;
	}
	return verif;
}
}












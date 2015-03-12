package com.metier;

/**
 * Classe métier permettant d'agir sur les type de charge des bornes de recharge
 * défini par un codeTypeCharge, un libelleTypeCharge et une puissance
 * 
 * @author leguen-t
 * @version 1.0
 */

public class TypeCharge {
	private int codeTypeCharge;
	private String libelleTypeCharge;
	private int puissance;

	/**
	 * Constructeur de TypeCharge qui permet d'instancier des types de charges
	 * pour les bornes de recharge
	 * 
	 * @param codeTypeCharge
	 * @param libelleTypeCharge
	 * @param puissance
	 */

	public TypeCharge(int codeTypeCharge, String libelleTypeCharge,
			int puissance) {
		super();
		this.codeTypeCharge = codeTypeCharge;
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissance = puissance;
	}

	/**
	 * Constructeur surchargé de TypeCharge pour les instancier sans
	 * codeTypeCharge
	 * 
	 * @param libelleTypeCharge
	 * @param puissance
	 */

	public TypeCharge(String libelleTypeCharge, int puissance) {
		super();
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissance = puissance;
	}

	/**
	 * Accesseur sur la propriété codeTypeCharge
	 * 
	 * @return un entier codeTypeCharge, identifiant le type de charge
	 */

	public int getCodeTypeCharge() {
		return codeTypeCharge;
	}

	/**
	 * Accesseur sur la propriété libelleTypeCharge
	 * 
	 * @return une chaîne libelleTypeCharge, décrivant le type de charge
	 */

	public String getLibelleTypeCharge() {
		return libelleTypeCharge;
	}

	/**
	 * Mutateur sur la propriété libelleTypeCharge
	 * 
	 * @param libelleTypeCharge
	 */

	public void setLibelleTypeCharge(String libelleTypeCharge) {
		this.libelleTypeCharge = libelleTypeCharge;
	}

	/**
	 * Accesseur sur la propriété puissance
	 * 
	 * @return un entier équivalent à la puissance en kW/h
	 */

	public int getPuissance() {
		return puissance;
	}

	/**
	 * Mutateur sur la propriété puissance
	 * 
	 * @param puissance
	 */

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	/**
	 * Fonction renvoyant une chaîne contenant l'ensemble des informations dy
	 * type de charge
	 * 
	 * @return
	 */

	public String toString() {
		return "Code Type Charge : " + codeTypeCharge
				+ " Libelle Type Charge : " + libelleTypeCharge
				+ " Puissance : " + puissance;
	}
}

/***********************************************************************
 * Module:  TypeErreur.java
 * Author:  Morgane
 * Purpose: Defines the Class TypeErreur
 ***********************************************************************/

package metier;

public class TypeErreur {
	private String codeTypeErreur;
	private String nomTypeErreur;

	public TypeErreur(String codeTypeErreur, String nomTypeErreur) {
		super();
		this.codeTypeErreur = codeTypeErreur;
		this.nomTypeErreur = nomTypeErreur;
	}

	/**
	 * @return the codeTypeErreur
	 */
	public String getCodeTypeErreur() {
		return codeTypeErreur;
	}

	/**
	 * @param codeTypeErreur
	 *            the codeTypeErreur to set
	 */
	public void setCodeTypeErreur(String codeTypeErreur) {
		this.codeTypeErreur = codeTypeErreur;
	}

	/**
	 * @return the nomTypeErreur
	 */
	public String getNomTypeErreur() {
		return nomTypeErreur;
	}

	/**
	 * @param nomTypeErreur
	 *            the nomTypeErreur to set
	 */
	public void setNomTypeErreur(String nomTypeErreur) {
		this.nomTypeErreur = nomTypeErreur;
	}

}
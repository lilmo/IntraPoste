/***********************************************************************
 * Module:  Agence.java
 * Author:  Morgane
 * Purpose: Defines the Class Agence
 ***********************************************************************/

package metier;

import tools.Casse;

public class Agence {
	private String codeAgence;
	private String nomAgence;

	public Agence(String codeAgence, String nomAgence) {
		this.codeAgence = codeAgence.toLowerCase();
		this.nomAgence = Casse.toTitleCase( nomAgence);
	}

	/**
	 * @return the codeAgence
	 */
	public String getCodeAgence() {
		return codeAgence;
	}

	/**
	 * @param codeAgence
	 *            the codeAgence to set
	 */
	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	/**
	 * @return the nomAgence
	 */
	public String getNomAgence() {
		return nomAgence;
	}

	/**
	 * @param nomAgence
	 *            the nomAgence to set
	 */
	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

}
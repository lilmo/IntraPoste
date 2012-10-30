/***********************************************************************
 * Module:  TypeRegularisation.java
 * Author:  Morgane
 * Purpose: Defines the Class TypeRegularisation
 ***********************************************************************/

package metier;

public class TypeRegularisation {
	private String codeTypeRegularisation;
	private String nomTypeRegularisation;

	public TypeRegularisation(String codeTypeRegularisation,
			String nomTypeRegularisation) {
		super();
		this.codeTypeRegularisation = codeTypeRegularisation;
		this.nomTypeRegularisation = nomTypeRegularisation;
	}

	/**
	 * @return the codeTypeRegularisation
	 */
	public String getCodeTypeRegularisation() {
		return codeTypeRegularisation;
	}

	/**
	 * @param codeTypeRegularisation
	 *            the codeTypeRegularisation to set
	 */
	public void setCodeTypeRegularisation(String codeTypeRegularisation) {
		this.codeTypeRegularisation = codeTypeRegularisation;
	}

	/**
	 * @return the nomTypeRegularisation
	 */
	public String getNomTypeRegularisation() {
		return nomTypeRegularisation;
	}

	/**
	 * @param nomTypeRegularisation
	 *            the nomTypeRegularisation to set
	 */
	public void setNomTypeRegularisation(String nomTypeRegularisation) {
		this.nomTypeRegularisation = nomTypeRegularisation;
	}

}
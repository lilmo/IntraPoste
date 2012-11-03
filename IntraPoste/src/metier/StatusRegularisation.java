/***********************************************************************
 * Module:  StatusRegularisation.java
 * Author:  Morgane
 * Purpose: Defines the Class StatusRegularisation
 ***********************************************************************/

package metier;

public class StatusRegularisation {
	private int codeStatusRegularisation;
	private String nomStatusRegularisation;

	public StatusRegularisation(int codeStatusRegularisation,
			String nomStatusRegularisation) {
		super();
		this.codeStatusRegularisation = codeStatusRegularisation;
		this.nomStatusRegularisation = nomStatusRegularisation;
	}

	/**
	 * @return the codeStatusRegularisation
	 */
	public int getCodeStatusRegularisation() {
		return codeStatusRegularisation;
	}

	/**
	 * @param codeStatusRegularisation
	 *            the codeStatusRegularisation to set
	 */
	public void setCodeStatusRegularisation(int codeStatusRegularisation) {
		this.codeStatusRegularisation = codeStatusRegularisation;
	}

	/**
	 * @return the nomStatusRegularisation
	 */
	public String getNomStatusRegularisation() {
		return nomStatusRegularisation;
	}

	/**
	 * @param nomStatusRegularisation
	 *            the nomStatusRegularisation to set
	 */
	public void setNomStatusRegularisation(String nomStatusRegularisation) {
		this.nomStatusRegularisation = nomStatusRegularisation;
	}

}
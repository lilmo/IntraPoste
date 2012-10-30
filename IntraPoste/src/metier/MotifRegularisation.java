/***********************************************************************
 * Module:  MotifRegularisation.java
 * Author:  Morgane
 * Purpose: Defines the Class MotifRegularisation
 ***********************************************************************/

package metier;

public class MotifRegularisation {
	private String codeMotifRegularisation;
	private String nomMotifRegularisation;

	public MotifRegularisation(String codeMotifRegularisation,
			String nomMotifRegularisation) {
		super();
		this.codeMotifRegularisation = codeMotifRegularisation;
		this.nomMotifRegularisation = nomMotifRegularisation;
	}

	/**
	 * @return the codeMotifRegularisation
	 */
	public String getCodeMotifRegularisation() {
		return codeMotifRegularisation;
	}

	/**
	 * @param codeMotifRegularisation
	 *            the codeMotifRegularisation to set
	 */
	public void setCodeMotifRegularisation(String codeMotifRegularisation) {
		this.codeMotifRegularisation = codeMotifRegularisation;
	}

	/**
	 * @return the nomMotifRegularisation
	 */
	public String getNomMotifRegularisation() {
		return nomMotifRegularisation;
	}

	/**
	 * @param nomMotifRegularisation
	 *            the nomMotifRegularisation to set
	 */
	public void setNomMotifRegularisation(String nomMotifRegularisation) {
		this.nomMotifRegularisation = nomMotifRegularisation;
	}

}
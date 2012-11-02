/***********************************************************************
 * Module:  AgentGuichet.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentGuichet
 ***********************************************************************/

package metier;

public class AgentGuichet extends Agent {

	private Agence agence;

	public AgentGuichet(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse, Agence agence) {
		super(codeAgent, typeAgent, mail, nom, prenom, motDePasse);
		this.agence = agence;
	}

	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * @param agence
	 *            the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * @param codeAgent
	 * @param typeErreur
	 * @param statusErreur
	 * @param dateDebut
	 * @param dateFin
	 */
	public ErreurCaisse[] consulterErreursCaisseAgent_(String codeAgent,
			String typeErreur, int statusErreur, java.util.Date dateDebut,
			java.util.Date dateFin) {
		// TODO: implement
		return null;
	}

}
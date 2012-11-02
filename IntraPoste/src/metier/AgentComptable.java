/***********************************************************************
 * Module:  AgentComptable.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentComptable
 ***********************************************************************/

package metier;

public class AgentComptable extends AgentSuperieur {

	private Agence agence;

	public AgentComptable(String codeAgent, TypeAgent typeAgent, String mail,
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

	public AgentComptable(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse) {
		super(codeAgent, typeAgent, mail, nom, prenom, motDePasse);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codeAgence
	 * @param codeAgent
	 * @param dateVacation
	 * @param typeErreur
	 * @param montant
	 */
	public int declarerErreurCaisse(String codeAgence, String codeAgent,
			java.util.Date dateVacation, String typeErreur, float montant) {
		// TODO: implement
		return 0;
	}

	public boolean isBilanDepasse() {
		// TODO: implement
		return false;
	}

	/** @param mail */
	public void envoyerMail(String mail) {
		// TODO: implement
	}

}
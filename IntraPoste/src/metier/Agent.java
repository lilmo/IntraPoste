/***********************************************************************
 * Module:  Agent.java
 * Author:  Morgane
 * Purpose: Defines the Class Agent
 ***********************************************************************/

package metier;

public class Agent {
	private String codeAgent;
	private TypeAgent typeAgent;
	private String mail;
	private String nom;
	private String prenom;
	private String motDePasse;

	public Agent(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse) {
		this.codeAgent = codeAgent;
		this.typeAgent = typeAgent;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the codeAgent
	 */
	public String getCodeAgent() {
		return codeAgent;
	}

	/**
	 * @param codeAgent
	 *            the codeAgent to set
	 */
	public void setCodeAgent(String codeAgent) {
		this.codeAgent = codeAgent;
	}

	/**
	 * @return the typeAgent
	 */
	public TypeAgent getTypeAgent() {
		return typeAgent;
	}

	/**
	 * @param typeAgent
	 *            the typeAgent to set
	 */
	public void setTypeAgent(TypeAgent typeAgent) {
		this.typeAgent = typeAgent;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @param montantRegulation
	 * @param codeAgentRegulateur
	 * @param motifRegulation
	 */
	public int regulariserErreurCaisse(float montantRegulation,
			String codeAgentRegulateur, String motifRegulation) {
		// TODO: implement
		return 0;
	}

}
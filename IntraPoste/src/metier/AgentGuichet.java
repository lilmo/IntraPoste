/***********************************************************************
 * Module:  AgentGuichet.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentGuichet
 ***********************************************************************/

package metier;

public class AgentGuichet extends Agent {
	public AgentGuichet(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse) {
		super(codeAgent, typeAgent, mail, nom, prenom, motDePasse);
		// TODO Auto-generated constructor stub
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
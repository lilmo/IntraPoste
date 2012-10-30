/***********************************************************************
 * Module:  AgentSuperieur.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentSuperieur
 ***********************************************************************/

package metier;


public class AgentSuperieur extends Agent {
	public AgentSuperieur(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse) {
		super(codeAgent, typeAgent, mail, nom, prenom, motDePasse);
		// TODO Auto-generated constructor stub
	}

/** @param codeAgence 
    * @param typeErreur 
    * @param statusErreur 
    * @param dateDebut 
    * @param dateFin */
   public ErreurCaisse[] consulterErreursCaisseAgence(String codeAgence, String typeErreur, int statusErreur, java.util.Date dateDebut, java.util.Date dateFin) {
      // TODO: implement
      return null;
   }

}
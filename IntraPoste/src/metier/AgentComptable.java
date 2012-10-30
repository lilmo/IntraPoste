/***********************************************************************
 * Module:  AgentComptable.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentComptable
 ***********************************************************************/

package metier;


public class AgentComptable extends AgentSuperieur {
   /** @param codeAgence 
    * @param codeAgent 
    * @param dateVacation 
    * @param typeErreur 
    * @param montant */
   public int declarerErreurCaisse(String codeAgence, String codeAgent, java.util.Date dateVacation, String typeErreur, float montant) {
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
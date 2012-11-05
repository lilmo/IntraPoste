/***********************************************************************
 * Module:  AgentComptable.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentComptable
 ***********************************************************************/

package metier;

import java.sql.SQLException;
import java.util.ArrayList;

import bdd.AgentDAO;
import bdd.ErreurCaisseDAO;

public class AgentComptable extends AgentSuperieur {

	public AgentComptable(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse, Agence agence) {
		super(codeAgent, typeAgent, mail, nom, prenom, motDePasse, agence);
	}

	/**
	 * @param codeAgence
	 * @param codeAgent
	 * @param dateVacation
	 * @param codeTypeErreur
	 * @param montant
	 * @throws SQLException 
	 */
	public int declarerErreurCaisse(String codeAgence, String codeAgent,
			java.util.Date dateVacation, String codeTypeErreur, float montant) throws SQLException {
		ErreurCaisseDAO.insert(codeAgence, codeAgent, dateVacation,
				codeTypeErreur, montant);
		int maxMontant = 10;
		try {
			if (bilanErreursCaisse(codeAgence, dateVacation, null, -1) > maxMontant)
				envoyerMail(getMailsDirection(codeAgence));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/** @param mail 
	 * @throws SQLException */
	private ArrayList<String> getMailsDirection(String codeAgence) throws SQLException {
		ArrayList<String> mails = new ArrayList<String>();
		for (Agent a : AgentDAO.selectByAgence(codeAgence))
			if (!a.getMail().equals(""))
				mails.add(a.getMail());
		return mails;
	}
	
	/** @param mail */
	private void envoyerMail(ArrayList<String> mails) {
		// TODO: implement
		for (String mail : mails)
			//Envoyer mail avec JavaMail?
			;
		
	}

}
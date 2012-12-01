/***********************************************************************
 * Module:  AgentSuperieur.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentSuperieur
 ***********************************************************************/

package metier;

import java.sql.SQLException;
import java.util.ArrayList;

import bdd.ErreurCaisseDAO;

public class AgentSuperieur extends Agent {
	public AgentSuperieur(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse, Agence agence) {
		super(codeAgent, agence, typeAgent, mail, nom, prenom, motDePasse);
	}

	/**
	 * @param codeAgence
	 * @param typeErreur
	 * @param statusErreur
	 * @param dateDebut
	 * @param dateFin
	 * @throws SQLException
	 */
	public ArrayList<ErreurCaisse> consulterErreursCaisseAgence(
			String codeAgence, String codeTypeErreur,
			int codeStatusRegularisation, java.util.Date dateDebut,
			java.util.Date dateFin) throws SQLException {
		return ErreurCaisseDAO.selectErreursCaisseByAgence(codeAgence,
				dateDebut, dateFin, codeTypeErreur, codeStatusRegularisation);
	}

	/**
	 * @param codeAgence
	 * @param dateVacation
	 * @param codeTypeErreur
	 * @param codeStatusRegularisation
	 * @throws SQLException
	 */
	public float bilanJourneeErreursCaisse(String codeAgence,
			java.util.Date dateVacation, String codeTypeErreur,
			int codeStatusRegularisation) throws SQLException {
		float somme = 0;
		ArrayList<ErreurCaisse> erreurs = ErreurCaisseDAO
				.selectErreursCaisseForBilanJournee(codeAgence, dateVacation,
						codeTypeErreur, codeStatusRegularisation);
		if (erreurs != null)
			for (ErreurCaisse e : erreurs)
				if (e.getTypeErreur().getNomTypeErreur().equals("D"))
					somme -= e.getMontant();
				else
					somme += e.getMontant();
		return somme;
	}

	/**
	 * @param codeAgence
	 * @param dateVacation
	 * @param codeTypeErreur
	 * @param codeStatusRegularisation
	 * @throws SQLException
	 */
	public float bilanErreursCaisse(String codeAgence,
			java.util.Date dateVacation, String codeTypeErreur,
			int codeStatusRegularisation) throws SQLException {
		float somme = 0;
		ArrayList<ErreurCaisse> erreurs = ErreurCaisseDAO
				.selectErreursCaisseForBilan(codeAgence, dateVacation,
						codeTypeErreur, codeStatusRegularisation);
		if (erreurs != null)
			for (ErreurCaisse e : erreurs)
				if (e.getTypeErreur().getCodeTypeErreur().equals("D"))
					somme -= e.getMontant();
				else
					somme += e.getMontant();
		return somme;
	}
}
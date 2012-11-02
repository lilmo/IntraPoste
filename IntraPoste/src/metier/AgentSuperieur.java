/***********************************************************************
 * Module:  AgentSuperieur.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentSuperieur
 ***********************************************************************/

package metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bdd.UtilitairesDAO;

public class AgentSuperieur extends Agent {
	public AgentSuperieur(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse) {
		super(codeAgent, typeAgent, mail, nom, prenom, motDePasse);
	}

	/**
	 * @param codeAgence
	 * @param typeErreur
	 * @param statusErreur
	 * @param dateDebut
	 * @param dateFin
	 */
	public ErreurCaisse[] consulterErreursCaisseAgence(String codeAgence,
			String typeErreur, int statusErreur, java.util.Date dateDebut,
			java.util.Date dateFin) {
		// TODO: implement
		return null;
	}

	/**
	 * @param codeAgence
	 * @param dateVacation
	 * @param codeTypeErreur
	 * @param codeStatusRegularisation
	 */
	public float bilanJourneeErreursCaisse(String codeAgence,
			java.util.Date dateVacation, String codeTypeErreur,
			int codeStatusRegularisation) {
		// TODO: implement
		//TODO: déplacer dans AgentSupérieurDAO
		float somme = 0;
		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			String query = "SELECT MONTANT FROM ERREUR_CAISSE WHERE CODE_AGENCE = '"
					+ codeAgence
					+ "' AND DATE_VACATION = '"
					+ dateVacation
					+ "'";
			if ((codeTypeErreur.equals("D")) || (codeTypeErreur.equals("E")))
				query += "' AND CODE_TYPE_ERREUR = '" + codeTypeErreur + "'";
			if ((codeStatusRegularisation >= 0)
					&& (codeStatusRegularisation <= 2))
				query += " AND CODE_STATUT_REGULARISATION = '"
						+ codeStatusRegularisation + "'";
			ResultSet result = select.executeQuery(query);

			while (result.next()) {
				if (result.getString("CODE_TYPE_ERREUR") == "D")
					somme -= result.getFloat("MONTANT");
				else
					somme += result.getFloat("MONTANT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return somme;
	}

	/**
	 * @param codeAgence
	 * @param dateVacation
	 * @param typeErreur
	 * @param statusErreur
	 */
	public float bilanErreursCaisse(String codeAgence,
			java.util.Date dateVacation, String typeErreur, int statusErreur) {
		// TODO: implement
		return 0;
	}

}
/***********************************************************************
 * Module:  ErreurCaisse.java
 * Author:  Morgane
 * Purpose: Defines the Class ErreurCaisse
 ***********************************************************************/

package metier;

import java.util.Calendar;
import java.util.Date;

import bdd.AgenceDAO;
import bdd.AgentDAO;
import bdd.ErreurCaisseDAO;
import bdd.ErreurCaisseRegularisationDAO;
import bdd.StatusRegularisationDAO;
import bdd.TypeErreurDAO;

public class ErreurCaisse {
	private int erreurCaisseId;
	private Agent agent;
	private TypeErreur typeErreur;
	private Agence agence;
	private StatusRegularisation statusRegularisation;
	private java.util.Date dateVacation;
	private float montant;

	public ErreurCaisse(int erreurCaisseId, Agent agent, TypeErreur typeErreur,
			Agence agence, StatusRegularisation statusRegularisation,
			Date dateVacation, float montant) {
		this.erreurCaisseId = erreurCaisseId;
		this.agent = agent;
		this.typeErreur = typeErreur;
		this.agence = agence;
		this.statusRegularisation = statusRegularisation;
		this.dateVacation = dateVacation;
		this.montant = montant;
	}

	public ErreurCaisse(int erreurCaisseId, String codeAgent,
			String codeTypeErreur, String codeAgence,
			int codeStatusRegularisation, Date dateVacation, float montant) {
		this.erreurCaisseId = erreurCaisseId;
		this.agent = AgentDAO.selectByCode(codeAgent);
		this.typeErreur = TypeErreurDAO.selectByCode(codeTypeErreur);
		this.agence = AgenceDAO.selectByCode(codeAgence);
		this.statusRegularisation = StatusRegularisationDAO
				.selectByCode(codeStatusRegularisation);
		this.dateVacation = dateVacation;
		this.montant = montant;
	}

	/**
	 * @return int : 0 désigne la régularisation s’est effectuée avec Succès 1
	 *         Erreur de caisse déjà régularisée totallement 2 Régularisation
	 *         non autorisée (selon type de l'agent) 3 Erreur système (base de
	 *         données ou autre)
	 * @param montantRegulation
	 * @param codeAgentRegulateur
	 * @param motifRegulation
	 */
	public int regulariserErreurCaisse(float montantRegularisation,
			String codeAgentRegularisateur,
			MotifRegularisation motifRegularisation) {
		// TODO: implement
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();

		// TODO: mettre des enums au lieu des chiffres
		if (this.statusRegularisation.getCodeStatusRegularisation() != 2) // totallement
																			// régularisée
		{
			if (this.statusRegularisation.getCodeStatusRegularisation() == 0) // pas
																				// régularisée
			{
				if (this.montant == montantRegularisation) {
					// TODO: vérifier les droits en fonction de codeMotif
					this.setStatusRegularisation(StatusRegularisationDAO
							.selectByCode(2));
					if (ErreurCaisseDAO.updateStatus(this.erreurCaisseId, 2)) {
						// TODO: Si pas d'exception...
						ErreurCaisseRegularisationDAO.insert(
								new java.sql.Timestamp(now.getTime()),
								codeAgentRegularisateur, motifRegularisation,
								1, this.erreurCaisseId,
								montantRegularisation);
						return 0; // Tout s'est bien passé
					} else
						return 3; // Erreur base de données
				} else {

				}
			}
		} else
			return 1; // Déjà régularisée
		return 3; // Autre erreur
	}

	/**
	 * @return the erreurCaisseId
	 */
	public int getErreurCaisseId() {
		return erreurCaisseId;
	}

	/**
	 * @param erreurCaisseId
	 *            the erreurCaisseId to set
	 */
	public void setErreurCaisseId(int erreurCaisseId) {
		this.erreurCaisseId = erreurCaisseId;
	}

	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent
	 *            the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	/**
	 * @return the typeErreur
	 */
	public TypeErreur getTypeErreur() {
		return typeErreur;
	}

	/**
	 * @param typeErreur
	 *            the typeErreur to set
	 */
	public void setTypeErreur(TypeErreur typeErreur) {
		this.typeErreur = typeErreur;
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
	 * @return the statusRegularisation
	 */
	public StatusRegularisation getStatusRegularisation() {
		return statusRegularisation;
	}

	/**
	 * @param statusRegularisation
	 *            the statusRegularisation to set
	 */
	public void setStatusRegularisation(
			StatusRegularisation statusRegularisation) {
		this.statusRegularisation = statusRegularisation;
	}

	/**
	 * @return the dateVacation
	 */
	public java.util.Date getDateVacation() {
		return dateVacation;
	}

	/**
	 * @param dateVacation
	 *            the dateVacation to set
	 */
	public void setDateVacation(java.util.Date dateVacation) {
		this.dateVacation = dateVacation;
	}

	/**
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(float montant) {
		this.montant = montant;
	}

}
/***********************************************************************
 * Module:  ErreurCaisse.java
 * Author:  Morgane
 * Purpose: Defines the Class ErreurCaisse
 ***********************************************************************/

package metier;

import java.util.Date;

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
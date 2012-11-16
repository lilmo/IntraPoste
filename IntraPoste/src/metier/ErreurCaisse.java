/***********************************************************************
 * Module:  ErreurCaisse.java
 * Author:  Morgane
 * Purpose: Defines the Class ErreurCaisse
 ***********************************************************************/

package metier;

import java.sql.SQLException;
import java.util.ArrayList;
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
	 * @return int : 0 d�signe la r�gularisation s�est effectu�e avec Succ�s 1
	 *         Erreur de caisse d�j� r�gularis�e totalement 2 R�gularisation non
	 *         autoris�e (selon type de l'agent) 3 Erreur syst�me (base de
	 *         donn�es ou autre)
	 * @param montantRegulation
	 * @param codeAgentRegulateur
	 * @param motifRegulation
	 * @throws SQLException 
	 */
	public int regulariserErreurCaisseComptable(float montantRegularisation,
			String codeAgentRegularisateur,
			MotifRegularisation motifRegularisation) throws SQLException {
		// TODO: implement
		// TODO: mettre des enums au lieu des chiffres
		if (this.statusRegularisation.getCodeStatusRegularisation() != 2) // totalement
																			// r�gularis�e
		{
			if (this.statusRegularisation.getCodeStatusRegularisation() == 0) // pas
																				// r�gularis�e
			{
				// TODO: v�rifier les droits en fonction de codeMotif
				if (this.montant == montantRegularisation) // On fait une
															// r�gularisation
															// totalement
					return subRegularisation(1, 2, codeAgentRegularisateur,
							motifRegularisation, montantRegularisation);
				else
					// On fait une r�gularisation partielle
					return subRegularisation(0, 1, codeAgentRegularisateur,
							motifRegularisation, montantRegularisation);
			} else { // partiellement r�gularis�e
				if (resteARegulariser() == montantRegularisation) {
					return subRegularisation(0, 2, codeAgentRegularisateur,
							motifRegularisation, montantRegularisation);
				} else if (resteARegulariser() > montantRegularisation) {
					return subRegularisation(0, 1, codeAgentRegularisateur,
							motifRegularisation, montantRegularisation);
				} else
					return 3; // Le montant ne doit pas �tre sup�rieur au
								// montant restant � r�gulariser
			}
		} else
			return 1; // D�j� r�gularis�e
	}

	public int regulariserErreurCaisseGuichet(float montantRegularisation,
			String codeAgentRegularisateur,
			MotifRegularisation motifRegularisation) {
		// TODO: implement
		// TODO: mettre des enums au lieu des chiffres
		int maxRegul = 5;
		if (this.typeErreur.getCodeTypeErreur().equals("E"))
			if (this.montant < maxRegul)
				return subRegularisation(1, 2, codeAgentRegularisateur,
						motifRegularisation, montantRegularisation);
		return 2;

	}

	private int subRegularisation(int codeTypeRegularisation,
			int codeStatusRegularisation, String codeAgentRegularisateur,
			MotifRegularisation motifRegularisation, float montantRegularisation) {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();

		try {
			ErreurCaisseRegularisationDAO.insert(
					new java.sql.Timestamp(now.getTime()),
					codeAgentRegularisateur, motifRegularisation.getCodeMotifRegularisation(),
					codeTypeRegularisation, this.erreurCaisseId,
					montantRegularisation);
			this.statusRegularisation = ErreurCaisseDAO.updateStatus(
					this.erreurCaisseId, codeStatusRegularisation)
					.getStatusRegularisation();
			return 0; // Tout s'est bien pass�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 3;
		}
	}

	public float resteARegulariser() throws SQLException {
		ArrayList<ErreursCaisseRegularisation> reguls = ErreurCaisseRegularisationDAO
				.selectByErreurCaisse(this.erreurCaisseId);
		int dejaRegularise = 0;
		for (ErreursCaisseRegularisation e : reguls)
			dejaRegularise += e.getMontantRegularisation();
		return montant - dejaRegularise;
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
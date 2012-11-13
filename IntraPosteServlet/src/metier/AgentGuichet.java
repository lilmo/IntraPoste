/***********************************************************************
 * Module:  AgentGuichet.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentGuichet
 ***********************************************************************/

package metier;

import java.sql.SQLException;
import java.util.ArrayList;

import bdd.ErreurCaisseDAO;

public class AgentGuichet extends Agent {

	public AgentGuichet(String codeAgent, TypeAgent typeAgent, String mail,
			String nom, String prenom, String motDePasse, Agence agence) {
		super(codeAgent, agence, typeAgent, mail, nom, prenom, motDePasse);
	}

	public ArrayList<ErreurCaisse> consulterErreursCaisseAgent(
			String codeAgent, String codeTypeErreur,
			int codeStatusRegularisation, java.util.Date dateDebut,
			java.util.Date dateFin) throws SQLException {
		return (ErreurCaisseDAO.selectErreursCaisseByAgent(codeAgent,
				dateDebut, dateFin, codeTypeErreur, codeStatusRegularisation));
	}

}
package bdd;

import java.sql.Timestamp;
import java.util.ArrayList;

import metier.ErreursCaisseRegularisation;
import metier.MotifRegularisation;

public class ErreurCaisseRegularisationDAO {

	public static void insert(Timestamp timestamp,
			String codeAgentRegularisateur,
			MotifRegularisation motifRegularisation,
			int codeTypeRegularisation, 
			int erreurCaisseId, float montantRegularisation) {
		// TODO Auto-generated method stub
		
	}

	public static ArrayList<ErreursCaisseRegularisation> selectByErreurCaisse(
			int erreurCaisseId) {
		// TODO Auto-generated method stub
		return null;
	}

}

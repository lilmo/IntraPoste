package bdd;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import metier.ErreursCaisseRegularisation;
import metier.MotifRegularisation;

public class ErreurCaisseRegularisationDAO {

	public static void insert(Timestamp timestamp,
			String codeAgentRegularisateur,
			MotifRegularisation motifRegularisation,
			int codeTypeRegularisation, 
			int erreurCaisseId, float montantRegularisation) throws SQLException {
		
		Statement insert = null;
		try {
				insert = Connexion.getInstance().getConnection()
						.createStatement();
				insert.executeQuery("INSERT INTO ERREURS_CAISSES_REGULARISATIONS VALUES ('" + timestamp + "', '"
						+ codeAgentRegularisateur + "', " + motifRegularisation + ", " + erreurCaisseId + 
						", " + codeTypeRegularisation + ", " + montantRegularisation + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}

	public static ArrayList<ErreursCaisseRegularisation> selectByErreurCaisse(
			int erreurCaisseId) {
		// TODO Auto-generated method stub
		return null;
	}

}

package bdd;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.tomcat.util.buf.TimeStamp;

import metier.ErreursCaisseRegularisation;
import metier.MotifRegularisation;

public class ErreurCaisseRegularisationDAO {

	@SuppressWarnings("deprecation")
	public static void init() throws SQLException {
		
		// TODO init ErreurCaisse
		empty();
		insert(new Timestamp(0, 0, 0, 0, 0, 0, 0), "", 0, 0, 0, 0.0f);
		insert(new Timestamp(0, 0, 0, 0, 0, 0, 0), "", 0, 0, 0, 0.0f);
		insert(new Timestamp(0, 0, 0, 0, 0, 0, 0), "", 0, 0, 0, 0.0f);
		insert(new Timestamp(0, 0, 0, 0, 0, 0, 0), "", 0, 0, 0, 0.0f);
		insert(new Timestamp(0, 0, 0, 0, 0, 0, 0), "", 0, 0, 0, 0.0f);
		insert(new Timestamp(0, 0, 0, 0, 0, 0, 0), "", 0, 0, 0, 0.0f);
		insert(new Timestamp(0, 0, 0, 0, 0, 0, 0), "", 0, 0, 0, 0.0f);
		
	}	
	
	
	public static void insert(Timestamp timestamp,
			String codeAgentRegularisateur,
			int motifRegularisation,
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

	public static void empty() throws SQLException {
		Statement insert = null;
		try {
			insert = Connexion.getInstance().getConnection().createStatement();
			insert.executeQuery("DELETE FROM ERREURS_CAISSES_REGULARISATIONS");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}
	
}

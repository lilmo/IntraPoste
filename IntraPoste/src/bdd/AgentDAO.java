package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.Agent;
import metier.ErreurCaisse;

public class AgentDAO {

	public static Agent selectByCode(String codeAgent) {
			try {
				Statement select = Connexion.getInstance().getConnection().createStatement();
				ResultSet result = select
						.executeQuery("SELECT * FROM AGENT WHERE CODE_AGENT = '"
								+ codeAgent + "'");
				if (result.next())
				{
//					System.out.println(result.getString("CODE_AGENCE"));
					return (new Agent(result.getString("CODE_AGENT"), 
							AgenceDAO.selectByCode(result.getString("CODE_AGENCE")), 
							TypeAgentDAO.selectByCode(result.getInt("CODE_TYPE_AGENT")), 
							result.getString("MAIL"), 
							result.getString("NOM"), 
							result.getString("PRENOM"), 
							result.getString("MOT_DE_PASSE")));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}


	public static ArrayList<Agent> selectByAgence(String codeAgence) throws SQLException {
			ArrayList<Agent> results = new ArrayList<Agent>();
			Statement select = null;
			try {
				select = Connexion.getInstance().getConnection().createStatement();
				String query = "SELECT * FROM AGENT WHERE CODE_AGENCE = '"
						+ codeAgence + "'";
				ResultSet result = select.executeQuery(query);

				while (result.next()) {
					results.add(new Agent(result.getString("CODE_AGENT"), 
							AgenceDAO.selectByCode(result.getString("CODE_AGENCE")), 
							TypeAgentDAO.selectByCode(result.getInt("CODE_TYPE_AGENT")), 
							result.getString("MAIL"), 
							result.getString("NOM"), 
							result.getString("PRENOM"), 
							result.getString("MOT_DE_PASSE")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (select != null)
					select.close();
			}
			return results;
		}

}

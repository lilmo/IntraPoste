package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.Agent;

public class AgentDAO {

	public static void init() throws SQLException {
		empty();
		//2 agents dir, 1 agent comptable, 2 guichets
		
		//directrices Paris20
		insert("PAR201", 0, "MORGANE.LOPVET@LAPOSTE.FR", "toto", "LOPVET", "MORGANE");
		insert("PAR201", 0, "AUDREY.GUYONNET@LAPOSTE.FR", "toto", "GUYONNET", "AUDREY");
		//comptable paris20
		insert("PAR201", 1, "PICSOU.CANARD@LAPOSTE.FR", "toto", "CANARD", "PICSOU");
		//guichetiers paris20
		insert("PAR201", 2, "JEANNE.TARTINE@LAPOSTE.FR", "toto", "TARTINE", "JEANNE");
		insert("PAR201", 2, "GERMAIN.POULET@LAPOSTE.FR", "toto", "POULET", "GERMAIN");
		
		//directrices Antony
		insert("ANT001", 0, "EMILIE.BONNIN@LAPOSTE.FR", "toto", "BONNIN", "EMILIE");
		insert("ANT001", 0, "PRINCE.CHARMANT@LAPOSTE.FR", "toto", "CHARMANT", "PRINCE");
		//comptable Antony
		insert("ANT001", 1, "PICSETTE.CANARDE@LAPOSTE.FR", "toto", "CANARDE", "PICSETTE");
		//guichetiers Antony
		insert("ANT001", 2, "PAULETTE.LADOUILLE@LAPOSTE.FR", "toto", "LADOUILLE", "PAULETTE");
		insert("ANT001", 2, "PIERRE.CHOCAPIC@LAPOSTE.FR", "toto", "CHOCAPIC", "PIERRE");
				
	}	

	public static boolean insert(String codeAgence, 
			int codeTypeAgent, String mail, String nom, 
			String prenom, String motDePasse) throws SQLException {
		Statement insert = null;
		try {
			String codeAgent = null;
			codeAgent = generateCodeAgent(nom, prenom);
			if (selectByCode(codeAgent) == null) {
				insert = Connexion.getInstance().getConnection()
						.createStatement();
				insert.executeQuery("INSERT INTO AGENT VALUES ('" + codeAgent.toUpperCase() + "', '"
						+ codeAgence.toUpperCase() + "', " + codeTypeAgent + ", '" + mail.toLowerCase() + "', '" 
						+ motDePasse + "', '" + nom.toUpperCase() + "', '" + prenom.toUpperCase() + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
		return false;
	}
	
	public static String generateCodeAgent(String nom, String prenom)
	{
		String codeAgent = null;
		try {
			if (nom.length() >= 6)
				codeAgent = nom.substring(0, 6);
			else
				codeAgent = nom;
			codeAgent += "_";
			codeAgent += prenom.substring(0, 1);
			if (selectByCode(codeAgent) == null)
				return codeAgent;
			else
			{
				int num = 1;
				String codeAgentTemp = codeAgent;
				while ((selectByCode(codeAgentTemp += num)) != null)
				{
					num++;
					codeAgentTemp = codeAgent;
				}
				codeAgent = codeAgentTemp;
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codeAgent;
	}
	
	public static ArrayList<Agent> selectAll() {
		ArrayList<Agent> results = new ArrayList<Agent>();
		try {
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT * FROM AGENT");
			while (result.next())
				results.add(new Agent(result.getString("CODE_AGENT"), AgenceDAO
						.selectByCode(result.getString("CODE_AGENCE")),
						TypeAgentDAO.selectByCode(result
								.getInt("CODE_TYPE_AGENT")), result
								.getString("MAIL"), result.getString("NOM"),
						result.getString("PRENOM"), result
								.getString("MOT_DE_PASSE")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public static Agent selectByCode(String codeAgent) {
		try {
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT * FROM AGENT WHERE CODE_AGENT LIKE '"
							+ codeAgent.toUpperCase() + "'");
			if (result.next()) {
				// System.out.println(result.getString("CODE_AGENCE"));
				return (new Agent(result.getString("CODE_AGENT"), AgenceDAO
						.selectByCode(result.getString("CODE_AGENCE")),
						TypeAgentDAO.selectByCode(result
								.getInt("CODE_TYPE_AGENT")), result
								.getString("MAIL"), result.getString("NOM"),
						result.getString("PRENOM"), result
								.getString("MOT_DE_PASSE")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public static ArrayList<Agent> selectByNom(
			String nomAgent) throws SQLException {
		ArrayList<Agent> results = new ArrayList<Agent>();
		Statement select = null;
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT * FROM AGENT WHERE NOM LIKE '"
							+ nomAgent + "'");
			while (result.next())
				results.add(new Agent(result.getString("CODE_AGENT"), 
						AgenceDAO.selectByCode(result.getString("CODE_AGENCE")),
						TypeAgentDAO.selectByCode(result.getInt("CODE_TYPE_AGENT")),
						result.getString("MAIL"),
						result.getString("NOM"),
						result.getString("PRENOM"),
						result.getString("MOT_DE_PASSE")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (select != null)
				select.close();
		}
		return results;
	}
	
	public static ArrayList<Agent> selectByNom(
			String nomAgent, String prenomAgent) throws SQLException {
		ArrayList<Agent> results = new ArrayList<Agent>();
		Statement select = null;
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT * FROM AGENT WHERE NOM LIKE '"
							+ nomAgent + "' AND PRENOM LIKE '" + prenomAgent + "'");
			while (result.next())
				results.add(new Agent(result.getString("CODE_AGENT"), 
						AgenceDAO.selectByCode(result.getString("CODE_AGENCE")),
						TypeAgentDAO.selectByCode(result.getInt("CODE_TYPE_AGENT")),
						result.getString("MAIL"),
						result.getString("NOM"),
						result.getString("PRENOM"),
						result.getString("MOT_DE_PASSE")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (select != null)
				select.close();
		}
		return results;
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

	public static void empty() throws SQLException {
		Statement insert = null;
		try {
			insert = Connexion.getInstance().getConnection().createStatement();
			insert.executeQuery("DELETE FROM AGENT");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}
}

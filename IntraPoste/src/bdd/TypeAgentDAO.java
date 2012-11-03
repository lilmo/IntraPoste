package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.TypeAgent;

public class TypeAgentDAO {

	public static void init() {
		insert(0, "DIRECTION");
		insert(1, "COMPTABLE");
		insert(2, "GUICHET");
	}

	
	public static ArrayList<TypeAgent> selectAll() {
		ArrayList<TypeAgent> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_AGENT, NOM_TYPE_AGENT FROM TYPE_AGENT");
			while (result.next())
				results.add(new TypeAgent(result.getInt("CODE_TYPE_AGENT"), result
						.getString("NOM_TYPE_AGENT")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static TypeAgent selectByCode(int codeTypeAgent) {

		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_AGENT, NOM_TYPE_AGENT FROM TYPE_AGENT WHERE CODE_TYPE_AGENT = "
							+ codeTypeAgent);
			if (result.next())
				return (new TypeAgent(result.getInt("CODE_TYPE_AGENT"),
						result.getString("NOM_TYPE_AGENT")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<TypeAgent> selectByNom(String nomTypeAgent) {
		ArrayList<TypeAgent> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_AGENT, NOM_TYPE_AGENT FROM TYPE_AGENT WHERE NOM_TYPE_AGENT = '"
							+ nomTypeAgent + "'");
			while (result.next())
				results.add(new TypeAgent(result.getInt("CODE_TYPE_AGENT"), result
						.getString("NOM_TYPE_AGENT")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean insert(int codeTypeAgent, String nomTypeAgent) {

		try {
			if (selectByCode(codeTypeAgent) == null) {
				Statement insert = Connexion.getInstance().getConnection().createStatement();
				insert.executeQuery("INSERT INTO TYPE_AGENT VALUES (" + codeTypeAgent
						+ ", '" + nomTypeAgent + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void empty() throws SQLException {
		Statement insert = null;
		try {
			insert = Connexion.getInstance().getConnection().createStatement();
			insert.executeQuery("DELETE FROM TYPE_AGENT");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}
}

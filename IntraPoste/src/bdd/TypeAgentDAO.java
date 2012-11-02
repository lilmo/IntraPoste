package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.TypeAgent;

public class TypeAgentDAO {
	public static ArrayList<TypeAgent> selectAll() {
		ArrayList<TypeAgent> results = new ArrayList<>();
		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_AGENT, NOM_TYPE_AGENT FROM TYPE_AGENT");
			while (result.next())
				results.add(new TypeAgent(result.getString("CODE_TYPE_AGENT"), result
						.getString("NOM_TYPE_AGENT")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static TypeAgent selectByCode(String codeTypeAgent) {

		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_AGENT, NOM_TYPE_AGENT FROM TYPE_AGENT WHERE CODE_TYPE_AGENT = '"
							+ codeTypeAgent + "'");
			if (result.next())
				return (new TypeAgent(result.getString("CODE_TYPE_AGENT"),
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
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_AGENT, NOM_TYPE_AGENT FROM TYPE_AGENT WHERE NOM_TYPE_AGENT = '"
							+ nomTypeAgent + "'");
			while (result.next())
				results.add(new TypeAgent(result.getString("CODE_TYPE_AGENT"), result
						.getString("NOM_TYPE_AGENT")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean insert(String codeTypeAgent, String nomTypeAgent) {

		try {
			if (selectByCode(codeTypeAgent) == null) {
				Statement insert = UtilitairesDAO.connect().createStatement();
				insert.executeQuery("INSERT INTO TYPE_AGENT VALUES ('" + codeTypeAgent
						+ "', '" + nomTypeAgent + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(String codeTypeAgent, String nomTypeAgent) {

		try {
			if (selectByCode(codeTypeAgent) != null) {
				Statement insert = UtilitairesDAO.connect().createStatement();
				insert.executeQuery("UPDATE TYPE_AGENT SET NOM_TYPE_AGENT = '"
						+ nomTypeAgent + "' WHERE CODE_TYPE_AGENT = '" + codeTypeAgent
						+ "'");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
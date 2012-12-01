package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.Agence;

public class AgenceDAO {

	
	public static void init() throws SQLException {
		empty();
		insert("PAR011", "POSTE PARIS 1");
		insert("PAR201", "POSTE PARIS 20");
		insert("ANT001", "POSTE ANTONY GARE");
		insert("VIN001", "POSTE VINCENNES FONTENAY");
		insert("DEF001", "POSTE ARCHE DEFENSE");
		insert("DEF002", "POSTE LA DEFENSE CENTRE CIAL");
	}	
	
	public static ArrayList<Agence> selectAll() {
		ArrayList<Agence> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_AGENCE, NOM_AGENCE FROM AGENCE");
			while (result.next())
				results.add(new Agence(result.getString("CODE_AGENCE"), result
						.getString("NOM_AGENCE")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static Agence selectByCode(String codeAgence) {

		try {
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_AGENCE, NOM_AGENCE FROM AGENCE WHERE CODE_AGENCE = '"
							+ codeAgence + "'");
			if (result.next()) {
				// System.out.println(result.getString("CODE_AGENCE"));
				return (new Agence(result.getString("CODE_AGENCE"),
						result.getString("NOM_AGENCE")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public static ArrayList<Agence> selectByNom(String nomAgence) {
		ArrayList<Agence> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_AGENCE, NOM_AGENCE FROM AGENCE WHERE NOM_AGENCE = '"
							+ nomAgence + "'");
			while (result.next())
				results.add(new Agence(result.getString("CODE_AGENCE"), result
						.getString("NOM_AGENCE")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean existingByCode(String codeAgence) {

		try {
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_AGENCE FROM AGENCE WHERE EXISTS " +
							"(SELECT * FROM AGENCE WHERE CODE_AGENCE = '" + codeAgence + "')");
			if (result.next()) {
				// System.out.println(result.getString("CODE_AGENCE"));
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public static boolean insert(String codeAgence, String nomAgence) {

		try {
			if (selectByCode(codeAgence) == null) {
				Statement insert = Connexion.getInstance().getConnection()
						.createStatement();
				insert.executeQuery("INSERT INTO AGENCE VALUES ('" + codeAgence.toUpperCase()
						+ "', '" + nomAgence.toUpperCase() + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(String codeAgence, String nomAgence) {

		try {
			if (selectByCode(codeAgence) != null) {
				Statement insert = Connexion.getInstance().getConnection()
						.createStatement();
				insert.executeQuery("UPDATE AGENCE SET NOM_AGENCE = '"
						+ nomAgence.toUpperCase() + "' WHERE CODE_AGENCE = '" + codeAgence.toUpperCase()
						+ "'");
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
			insert.executeQuery("DELETE FROM AGENCE");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}
}

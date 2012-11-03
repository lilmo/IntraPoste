package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.Agence;

public class AgenceDAO {

	public static ArrayList<Agence> selectAll() {
		ArrayList<Agence> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
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
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_AGENCE, NOM_AGENCE FROM AGENCE WHERE CODE_AGENCE = '"
							+ codeAgence + "'");
			if (result.next())
			{
//				System.out.println(result.getString("CODE_AGENCE"));
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
			Statement select = Connexion.getInstance().getConnection().createStatement();
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

	public static boolean insert(String codeAgence, String nomAgence) {

		try {
			if (selectByCode(codeAgence) == null) {
				Statement insert = Connexion.getInstance().getConnection().createStatement();
				insert.executeQuery("INSERT INTO AGENCE VALUES ('" + codeAgence
						+ "', '" + nomAgence + "')");
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
				Statement insert = Connexion.getInstance().getConnection().createStatement();
				insert.executeQuery("UPDATE AGENCE SET NOM_AGENCE = '" + nomAgence + "' WHERE CODE_AGENCE = '" + codeAgence + "'");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

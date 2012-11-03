package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.TypeErreur;

public class TypeErreurDAO {

	public static void init() throws SQLException {
		empty();
		insert("E", "EXCEDENT");
		insert("D", "DEFICIT");
	}

	public static ArrayList<TypeErreur> selectAll() {
		ArrayList<TypeErreur> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_ERREUR, NOM_TYPE_ERREUR FROM TYPE_ERREUR");
			while (result.next())
				results.add(new TypeErreur(
						result.getString("CODE_TYPE_ERREUR"), result
								.getString("NOM_TYPE_ERREUR")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static TypeErreur selectByCode(String codeTypeErreur) {

		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_ERREUR, NOM_TYPE_ERREUR FROM TYPE_ERREUR WHERE CODE_TYPE_ERREUR = '"
							+ codeTypeErreur + "'");
			if (result.next())
				return (new TypeErreur(result.getString("CODE_TYPE_ERREUR"),
						result.getString("NOM_TYPE_ERREUR")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<TypeErreur> selectByNom(String nomTypeErreur) {
		ArrayList<TypeErreur> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_ERREUR, NOM_TYPE_ERREUR FROM TYPE_ERREUR WHERE NOM_TYPE_ERREUR = '"
							+ nomTypeErreur + "'");
			while (result.next())
				results.add(new TypeErreur(
						result.getString("CODE_TYPE_ERREUR"), result
								.getString("NOM_TYPE_ERREUR")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean insert(String codeTypeErreur, String nomTypeErreur) {

		try {
			if (selectByCode(codeTypeErreur) == null) {
				Statement insert = Connexion.getInstance().getConnection().createStatement();
				insert.executeQuery("INSERT INTO TYPE_ERREUR VALUES ('"
						+ codeTypeErreur + "', '" + nomTypeErreur + "')");
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
			insert.executeQuery("DELETE FROM TYPE_ERREUR");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}
}

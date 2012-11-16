package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.TypeRegularisation;

public class TypeRegularisationDAO {

	public static void init() throws SQLException {
		empty();
		insert(0, "PARTIELLE");
		insert(1, "TOTALE");
	}

	public static ArrayList<TypeRegularisation> selectAll() {
		ArrayList<TypeRegularisation> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_REGULARISATION, NOM_TYPE_REGULARISATION FROM TYPE_REGULARISATION");
			while (result.next())
				results.add(new TypeRegularisation(result
						.getInt("CODE_TYPE_REGULARISATION"), result
						.getString("NOM_TYPE_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static TypeRegularisation selectByCode(int codeTypeRegularisation) {

		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_REGULARISATION, NOM_TYPE_REGULARISATION FROM TYPE_REGULARISATION WHERE CODE_TYPE_REGULARISATION = "
							+ codeTypeRegularisation);
			if (result.next())
				return (new TypeRegularisation(
						result.getInt("CODE_TYPE_REGULARISATION"),
						result.getString("NOM_TYPE_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<TypeRegularisation> selectByNom(
			String nomTypeRegularisation) {
		ArrayList<TypeRegularisation> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_REGULARISATION, NOM_TYPE_REGULARISATION FROM TYPE_REGULARISATION WHERE NOM_TYPE_REGULARISATION = '"
							+ nomTypeRegularisation + "'");
			while (result.next())
				results.add(new TypeRegularisation(result
						.getInt("CODE_TYPE_REGULARISATION"), result
						.getString("NOM_TYPE_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean insert(int codeTypeRegularisation,
			String nomTypeRegularisation) {

		try {
			if (selectByCode(codeTypeRegularisation) == null) {
				Statement insert = Connexion.getInstance().getConnection().createStatement();
				insert.executeQuery("INSERT INTO TYPE_REGULARISATION VALUES ("
						+ codeTypeRegularisation + ", '"
						+ nomTypeRegularisation.toUpperCase() + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(int codeTypeRegul,
			String nomTypeRegul) throws SQLException {
		Statement insert = null;
		try {
			if (selectByCode(codeTypeRegul) != null) {
				insert = Connexion.getInstance().getConnection()
						.createStatement();
				insert.executeQuery("UPDATE TYPE_REGULARISATION SET NOM_TYPE_REGULARISATION = '"
						+ nomTypeRegul.toUpperCase()
						+ "' WHERE CODE_TYPE_REGULARISATION = "
						+ codeTypeRegul);
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
	
	public static void empty() throws SQLException {
		Statement insert = null;
		try {
			insert = Connexion.getInstance().getConnection().createStatement();
			insert.executeQuery("DELETE FROM TYPE_REGULARISATION");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}
	
}

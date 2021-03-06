package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.StatusRegularisation;

public class StatusRegularisationDAO {
	
	public static void init() throws SQLException
	{
		empty();
		insert(0, "DECLAREE");
		insert(1, "PARTIELLEMENT REGULARISEE");
		insert(2, "TOTALEMENT REGULARISEE");
	}
	
	public static ArrayList<StatusRegularisation> selectAll() {
		ArrayList<StatusRegularisation> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_STATUT_REGULARISATION, NOM_STATUS_REGULARISATION FROM STATUS_REGULARISATION");
			while (result.next())
				results.add(new StatusRegularisation(result
						.getInt("CODE_STATUT_REGULARISATION"), result
						.getString("NOM_STATUS_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean update(int codeStatusRegularisation,
			String nomStatusRegularisation) throws SQLException {
		Statement insert = null;
		try {
			if (selectByCode(codeStatusRegularisation) != null) {
				insert = Connexion.getInstance().getConnection()
						.createStatement();
				insert.executeQuery("UPDATE STATUS_REGULARISATION SET NOM_STATUS_REGULARISATION = '"
						+ nomStatusRegularisation.toUpperCase()
						+ "' WHERE CODE_STATUS_REGULARISATION = "
						+ codeStatusRegularisation);
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
	
	public static StatusRegularisation selectByCode(int codeStatusRegularisation) {

		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_STATUT_REGULARISATION, NOM_STATUS_REGULARISATION FROM STATUS_REGULARISATION WHERE CODE_STATUT_REGULARISATION = "
							+ codeStatusRegularisation);
			if (result.next())
				return (new StatusRegularisation(
						result.getInt("CODE_STATUT_REGULARISATION"),
						result.getString("NOM_STATUS_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<StatusRegularisation> selectByNom(
			String nomStatusRegularisation) {
		ArrayList<StatusRegularisation> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_STATUT_REGULARISATION, NOM_STATUS_REGULARISATION FROM STATUS_REGULARISATION WHERE NOM_STATUS_REGULARISATION = '"
							+ nomStatusRegularisation + "'");
			while (result.next())
				results.add(new StatusRegularisation(result
						.getInt("CODE_STATUT_REGULARISATION"), result
						.getString("NOM_STATUS_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean insert(int codeStatusRegularisation,
			String nomStatusRegularisation) {

		try {
			if (selectByCode(codeStatusRegularisation) == null) {
				if (codeStatusRegularisation >= 0
						&& codeStatusRegularisation <= 2) {
					Statement insert = Connexion.getInstance().getConnection().createStatement();
					insert.executeQuery("INSERT INTO STATUS_REGULARISATION VALUES ("
							+ codeStatusRegularisation
							+ ", '"
							+ nomStatusRegularisation.toUpperCase() + "')");
					return true;
				}
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
			insert.executeQuery("DELETE FROM STATUS_REGULARISATION");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}
}

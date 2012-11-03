package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.StatusRegularisation;

public class StatusRegularisationDAO {
	
	private static void init()
	{
		insert(0, "DECLAREE");
		insert(1, "PARTIELLEMENT REGULARISEE");
		insert(2, "TOTALEMENT REGULARISEE");
	}
	
	public static ArrayList<StatusRegularisation> selectAll() {
		ArrayList<StatusRegularisation> results = new ArrayList<>();
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_STATUT_REGULARISATION, NOM_STATUS_REGULARISATION FROM STATUS_REGULARISATION;");
			while (result.next())
				results.add(new StatusRegularisation(result
						.getInt("CODE_STATUT_REGULARISATION"), result
						.getString("NOM_STATUS_REGULARISATION")));
			if (results.size() == 0)
			{
				init();
				return selectAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static StatusRegularisation selectByCode(int codeStatusRegularisation) {

		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_STATUT_REGULARISATION, NOM_STATUS_REGULARISATION FROM STATUS_REGULARISATION WHERE CODE_STATUT_REGULARISATION = "
							+ codeStatusRegularisation + ";");
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
							+ nomStatusRegularisation + "';");
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

	private static boolean insert(int codeStatusRegularisation,
			String nomStatusRegularisation) {

		try {
			if (selectByCode(codeStatusRegularisation) == null) {
				if (codeStatusRegularisation >= 0
						&& codeStatusRegularisation <= 2) {
					Statement insert = Connexion.getInstance().getConnection().createStatement();
					insert.executeQuery("INSERT INTO STATUS_REGULARISATION VALUES ("
							+ codeStatusRegularisation
							+ ", '"
							+ nomStatusRegularisation + "');");
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

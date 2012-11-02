package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.StatusRegularisation;

public class StatusRegularisationDAO {
	public static ArrayList<StatusRegularisation> selectAll() {
		ArrayList<StatusRegularisation> results = new ArrayList<>();
		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_STATUT_REGULARISATION, NOM_REGULARISATION FROM STATUS_REGULARISATION");
			while (result.next())
				results.add(new StatusRegularisation(result.getString("CODE_STATUT_REGULARISATION"), result
						.getString("NOM_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static StatusRegularisation selectByCode(String codeStatusRegularisation) {

		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_STATUT_REGULARISATION, NOM_REGULARISATION FROM STATUS_REGULARISATION WHERE CODE_STATUT_REGULARISATION = '"
							+ codeStatusRegularisation + "'");
			if (result.next())
				return (new StatusRegularisation(result.getString("CODE_STATUT_REGULARISATION"),
						result.getString("NOM_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<StatusRegularisation> selectByNom(String nomMotifRegularisation) {
		ArrayList<StatusRegularisation> results = new ArrayList<>();
		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_STATUT_REGULARISATION, NOM_REGULARISATION FROM STATUS_REGULARISATION WHERE NOM_REGULARISATION = '"
							+ nomMotifRegularisation + "'");
			while (result.next())
				results.add(new StatusRegularisation(result.getString("CODE_STATUT_REGULARISATION"), result
						.getString("NOM_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean insert(String codeStatusRegularisation, String nomMotifRegularisation) {

		try {
			if (selectByCode(codeStatusRegularisation) == null) {
				Statement insert = UtilitairesDAO.connect().createStatement();
				insert.executeQuery("INSERT INTO STATUS_REGULARISATION VALUES ('" + codeStatusRegularisation
						+ "', '" + nomMotifRegularisation + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(String codeStatusRegularisation, String nomMotifRegularisation) {

		try {
			if (selectByCode(codeStatusRegularisation) != null) {
				Statement insert = UtilitairesDAO.connect().createStatement();
				insert.executeQuery("UPDATE STATUS_REGULARISATION SET NOM_REGULARISATION = '"
						+ nomMotifRegularisation + "' WHERE CODE_STATUT_REGULARISATION = '" + codeStatusRegularisation
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

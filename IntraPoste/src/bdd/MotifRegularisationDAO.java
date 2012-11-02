package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.MotifRegularisation;

public class MotifRegularisationDAO {
	public static ArrayList<MotifRegularisation> selectAll() {
		ArrayList<MotifRegularisation> results = new ArrayList<>();
		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_MOTIF_REGULARISATION, DESCRIPTION_MOTIF_REGUL FROM MOTIF_REGULARISATION");
			while (result.next())
				results.add(new MotifRegularisation(result.getString("CODE_MOTIF_REGULARISATION"), result
						.getString("DESCRIPTION_MOTIF_REGUL")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static MotifRegularisation selectByCode(String codeMotifRegularisation) {

		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_MOTIF_REGULARISATION, DESCRIPTION_MOTIF_REGUL FROM MOTIF_REGULARISATION WHERE CODE_MOTIF_REGULARISATION = '"
							+ codeMotifRegularisation + "'");
			if (result.next())
				return (new MotifRegularisation(result.getString("CODE_MOTIF_REGULARISATION"),
						result.getString("DESCRIPTION_MOTIF_REGUL")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<MotifRegularisation> selectByNom(String nomMotifRegularisation) {
		ArrayList<MotifRegularisation> results = new ArrayList<>();
		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_MOTIF_REGULARISATION, DESCRIPTION_MOTIF_REGUL FROM MOTIF_REGULARISATION WHERE DESCRIPTION_MOTIF_REGUL = '"
							+ nomMotifRegularisation + "'");
			while (result.next())
				results.add(new MotifRegularisation(result.getString("CODE_MOTIF_REGULARISATION"), result
						.getString("DESCRIPTION_MOTIF_REGUL")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean insert(String codeMotifRegularisation, String nomMotifRegularisation) {

		try {
			if (selectByCode(codeMotifRegularisation) == null) {
				Statement insert = UtilitairesDAO.connect().createStatement();
				insert.executeQuery("INSERT INTO MOTIF_REGULARISATION VALUES ('" + codeMotifRegularisation
						+ "', '" + nomMotifRegularisation + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(String codeMotifRegularisation, String nomMotifRegularisation) {

		try {
			if (selectByCode(codeMotifRegularisation) != null) {
				Statement insert = UtilitairesDAO.connect().createStatement();
				insert.executeQuery("UPDATE MOTIF_REGULARISATION SET DESCRIPTION_MOTIF_REGUL = '"
						+ nomMotifRegularisation + "' WHERE CODE_MOTIF_REGULARISATION = '" + codeMotifRegularisation
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

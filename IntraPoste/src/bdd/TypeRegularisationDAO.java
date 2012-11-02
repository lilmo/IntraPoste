package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.TypeRegularisation;

public class TypeRegularisationDAO {
	public static ArrayList<TypeRegularisation> selectAll() {
		ArrayList<TypeRegularisation> results = new ArrayList<>();
		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_REGULARISATION, NOM_TYPE_REGULARISATION FROM TYPE_REGULARISATION");
			while (result.next())
				results.add(new TypeRegularisation(result.getString("CODE_TYPE_REGULARISATION"), result
						.getString("NOM_TYPE_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static TypeRegularisation selectByCode(String codeTypeRegularisation) {

		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_REGULARISATION, NOM_TYPE_REGULARISATION FROM TYPE_REGULARISATION WHERE CODE_TYPE_REGULARISATION = '"
							+ codeTypeRegularisation + "'");
			if (result.next())
				return (new TypeRegularisation(result.getString("CODE_TYPE_REGULARISATION"),
						result.getString("NOM_TYPE_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<TypeRegularisation> selectByNom(String nomTypeRegularisation) {
		ArrayList<TypeRegularisation> results = new ArrayList<>();
		try {
			Statement select = UtilitairesDAO.connect().createStatement();
			ResultSet result = select
					.executeQuery("SELECT CODE_TYPE_REGULARISATION, NOM_TYPE_REGULARISATION FROM TYPE_REGULARISATION WHERE NOM_TYPE_REGULARISATION = '"
							+ nomTypeRegularisation + "'");
			while (result.next())
				results.add(new TypeRegularisation(result.getString("CODE_TYPE_REGULARISATION"), result
						.getString("NOM_TYPE_REGULARISATION")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public static boolean insert(String codeTypeRegularisation, String nomTypeRegularisation) {

		try {
			if (selectByCode(codeTypeRegularisation) == null) {
				Statement insert = UtilitairesDAO.connect().createStatement();
				insert.executeQuery("INSERT INTO TYPE_REGULARISATION VALUES ('" + codeTypeRegularisation
						+ "', '" + nomTypeRegularisation + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(String codeTypeRegularisation, String nomTypeRegularisation) {

		try {
			if (selectByCode(codeTypeRegularisation) != null) {
				Statement insert = UtilitairesDAO.connect().createStatement();
				insert.executeQuery("UPDATE TYPE_REGULARISATION SET NOM_TYPE_REGULARISATION = '"
						+ nomTypeRegularisation + "' WHERE CODE_TYPE_REGULARISATION = '" + codeTypeRegularisation
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

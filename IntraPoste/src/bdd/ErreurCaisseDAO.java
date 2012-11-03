package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import metier.ErreurCaisse;

public class ErreurCaisseDAO {

	public static ArrayList<ErreurCaisse> selectErreursCaisseForBilanJournee(
			String codeAgence, java.util.Date dateVacation,
			String codeTypeErreur, int codeStatusRegularisation)
			throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			String query = "SELECT MONTANT FROM ERREUR_CAISSE WHERE CODE_AGENCE = '"
					+ codeAgence
					+ "' AND DATE_VACATION = '"
					+ dateVacation
					+ "'";
			if ((codeTypeErreur.equals("D")) || (codeTypeErreur.equals("E")))
				query += "' AND CODE_TYPE_ERREUR = '" + codeTypeErreur + "'";
			if ((codeStatusRegularisation >= 0)
					&& (codeStatusRegularisation <= 2))
				query += " AND CODE_STATUT_REGULARISATION = '"
						+ codeStatusRegularisation + "'";
			ResultSet result = select.executeQuery(query);

			while (result.next()) {
				results.add(new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), result
								.getString("CODE_TYPE_ERREUR"), result
								.getString("CODE_AGENCE"), result
								.getInt("STATUS_REGULARISATION"), result
								.getDate("DATE_VACATION"), result
								.getFloat("MONTANT")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (select != null)
				select.close();
		}
		return results;
	}

	@SuppressWarnings({ "deprecation" })
	public static ArrayList<ErreurCaisse> selectErreursCaisseForBilan(
			String codeAgence, Date dateVacation, String codeTypeErreur,
			int codeStatusRegularisation) throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			Date debut = new Date(Calendar.getInstance().get(Calendar.YEAR), 1,
					1);
			String query = "SELECT MONTANT FROM ERREUR_CAISSE WHERE CODE_AGENCE = '"
					+ codeAgence
					+ "' AND DATE_VACATION BETWEEN '"
					+ debut
					+ "' AND '" + dateVacation + "'";
			if ((codeTypeErreur.equals("D")) || (codeTypeErreur.equals("E")))
				query += "' AND CODE_TYPE_ERREUR = '" + codeTypeErreur + "'";
			if ((codeStatusRegularisation >= 0)
					&& (codeStatusRegularisation <= 2))
				query += " AND CODE_STATUT_REGULARISATION = '"
						+ codeStatusRegularisation + "'";
			ResultSet result = select.executeQuery(query);

			while (result.next()) {
				results.add(new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), result
								.getString("CODE_TYPE_ERREUR"), result
								.getString("CODE_AGENCE"), result
								.getInt("STATUS_REGULARISATION"), result
								.getDate("DATE_VACATION"), result
								.getFloat("MONTANT")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (select != null)
				select.close();
		}
		return results;
	}

	public static ArrayList<ErreurCaisse> selectErreursCaisseByAgent(
			String codeAgent, Date dateDebut, Date dateFin, String codeTypeErreur,
			int codeStatusRegularisation) throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			String query = "SELECT MONTANT FROM ERREUR_CAISSE WHERE CODE_AGENT = '"
					+ codeAgent
					+ "' AND DATE_VACATION BETWEEN '"
					+ dateDebut
					+ "' AND '" + dateFin + "'";
			if ((codeTypeErreur.equals("D")) || (codeTypeErreur.equals("E")))
				query += "' AND CODE_TYPE_ERREUR = '" + codeTypeErreur + "'";
			if ((codeStatusRegularisation >= 0)
					&& (codeStatusRegularisation <= 2))
				query += " AND CODE_STATUT_REGULARISATION = '"
						+ codeStatusRegularisation + "'";
			ResultSet result = select.executeQuery(query);

			while (result.next()) {
				results.add(new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), result
								.getString("CODE_TYPE_ERREUR"), result
								.getString("CODE_AGENCE"), result
								.getInt("STATUS_REGULARISATION"), result
								.getDate("DATE_VACATION"), result
								.getFloat("MONTANT")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (select != null)
				select.close();
		}
		return results;
	}
	
	public static ArrayList<ErreurCaisse> selectErreursCaisseByAgence(
			String codeAgence, Date dateDebut, Date dateFin, String codeTypeErreur,
			int codeStatusRegularisation) throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			String query = "SELECT MONTANT FROM ERREUR_CAISSE WHERE CODE_AGENCE = '"
					+ codeAgence
					+ "' AND DATE_VACATION BETWEEN '"
					+ dateDebut
					+ "' AND '" + dateFin + "'";
			if ((codeTypeErreur.equals("D")) || (codeTypeErreur.equals("E")))
				query += "' AND CODE_TYPE_ERREUR = '" + codeTypeErreur + "'";
			if ((codeStatusRegularisation >= 0)
					&& (codeStatusRegularisation <= 2))
				query += " AND CODE_STATUT_REGULARISATION = '"
						+ codeStatusRegularisation + "'";
			ResultSet result = select.executeQuery(query);

			while (result.next()) {
				results.add(new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), result
								.getString("CODE_TYPE_ERREUR"), result
								.getString("CODE_AGENCE"), result
								.getInt("STATUS_REGULARISATION"), result
								.getDate("DATE_VACATION"), result
								.getFloat("MONTANT")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (select != null)
				select.close();
		}
		return results;
	}
	
	public static void insert(String codeAgence, String codeAgent,
			Date dateVacation, String typeErreur, float montant) {
		// TODO Auto-generated method stub
		// Ne pas oublier de mettre le "CODE_STATUS_REGULARISATION" � 0 (erreur
		// d�clar�e et non encore r�gularis�e)
	}

	public static boolean updateStatus(int erreurCaisseId, int nouveauCodeStatusRegularisation) {
		return false;
		// TODO Auto-generated method stub
		
	}
}

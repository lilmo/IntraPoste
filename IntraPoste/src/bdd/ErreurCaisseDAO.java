package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import metier.ErreurCaisse;

public class ErreurCaisseDAO {

	public static void init() throws SQLException {
		
		// TODO init ErreurCaisse
		empty();
		insert("", "", new Date() , "", 0);
		insert("", "", new Date() , "", 0);
		insert("", "", new Date() , "", 0);
		insert("", "", new Date() , "", 0);
		insert("", "", new Date() , "", 0);
		insert("", "", new Date() , "", 0);
	}	
	
	public static ErreurCaisse selectByCode(String codeErreurCaisse) {

		try {
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT * FROM ERREUR_CAISSE WHERE ERREUR_CAISSE_ID = '"
							+ codeErreurCaisse + "'");
			if (result.next()) {
				// System.out.println(result.getString("ERREUR_CAISSE_ID"));
				return (new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"),
						result.getString("CODE_TYPE_ERREUR"),
						result.getString("CODE_AGENCE"),
						result.getInt("CODE_STATUT_REGULARISATION"),
						result.getDate("DATE_VACATION"),
						result.getFloat("MONTANT")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

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
			String codeAgent, Date dateDebut, Date dateFin,
			String codeTypeErreur, int codeStatusRegularisation)
			throws SQLException {
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

	public static ArrayList<ErreurCaisse> selectErreursCaisseByAgent(
			String codeAgent, Date dateVacation, String codeTypeErreur)
			throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			String query = "SELECT * FROM ERREUR_CAISSE WHERE CODE_AGENT = '"
					+ codeAgent + "' AND DATE_VACATION = '" + dateVacation
					+ "' AND CODE_TYPE_ERREUR = '" + codeTypeErreur + "'";

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
			String codeAgence, Date dateDebut, Date dateFin,
			String codeTypeErreur, int codeStatusRegularisation)
			throws SQLException {
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
			Date dateVacation, String typeErreur, float montant)
			throws SQLException {
		Statement insert = null;
		try {
			if (selectErreursCaisseByAgent(codeAgent, dateVacation, typeErreur) == null) {
				insert = Connexion.getInstance().getConnection()
						.createStatement();
				insert.executeQuery("INSERT INTO ERREUR_CAISSE VALUES ('', '"
						+ codeAgent + "', '" + typeErreur + "', '" + codeAgence
						+ "', 0 , '" + dateVacation + "', " + montant + ")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}

	public static ErreurCaisse updateStatus(int erreurCaisseId,
			int nouveauCodeStatusRegularisation) throws SQLException {
		String query = "UPDATE TABLE ERREUR_CAISSE SET CODE_STATUS_REGULARISATION = "
				+ nouveauCodeStatusRegularisation
				+ "WHERE ERREUR_CAISSE_ID = "
				+ erreurCaisseId;
		Statement select = null;
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			select.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (select != null)
				select.close();
		}
		return selectErreursCaisseById(erreurCaisseId);
	}

	private static ErreurCaisse selectErreursCaisseById(int erreurCaisseId) {
		try {
			Statement select = Connexion.getInstance().getConnection().createStatement();
			ResultSet result = select
					.executeQuery("SELECT * FROM ERREUR_CAISSE WHERE ERREUR_CAISSE_ID = '"
							+ erreurCaisseId + "'");
			if (result.next())
			{
//				System.out.println(result.getInt("ERREUR_CAISSE_ID"));
				return (new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), 
						result.getString("CODE_TYPE_ERREUR"), 
						result.getString("CODE_AGENCE"), 
						result.getInt("CODE_STATUT_REGULARISATION"),
						result.getDate("DATE_VACATION"),
						result.getFloat("MONTANT")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void empty() throws SQLException {
		Statement insert = null;
		try {
			insert = Connexion.getInstance().getConnection().createStatement();
			insert.executeQuery("DELETE FROM ERREUR_CAISSE");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (insert != null)
				insert.close();
		}
	}
	
}

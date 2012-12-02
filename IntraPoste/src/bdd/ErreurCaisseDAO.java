package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import metier.ErreurCaisse;

public class ErreurCaisseDAO {

	public static void init() throws SQLException {

		// TODO init ErreurCaisse
		empty();
		insert("PAR201", "lopvet_m", new Date(), "E",
				Math.round(Math.random() * 10));
		insert("ANT001", "bonnin_e", new Date(), "E",
				Math.round(Math.random() * 10));
		insert("PAR201", "lopvet_m", new Date(), "D",
				Math.round(Math.random() * 10));
		insert("ANT001", "bonnin_e", new Date(), "D",
				Math.round(Math.random() * 10));
		insert("ANT001", "bonnin_e", new Date(), "E",
				Math.round(Math.random() * 10));
	}

	public static ErreurCaisse selectById(int idErreurCaisse) {

		try {
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT * FROM ERREUR_CAISSE WHERE ERREUR_CAISSE_ID = '"
							+ idErreurCaisse + "'");
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
			String query = "SELECT * FROM ERREUR_CAISSE WHERE CODE_AGENCE = '"
					+ codeAgence.toUpperCase() + "' AND DATE_VACATION = to_date('"
					+ new SimpleDateFormat("yyyy/MM/dd").format(dateVacation)
					+ "', 'yyyy/mm/dd')";
			if (codeTypeErreur != null
					&& ((codeTypeErreur.equals("D")) || (codeTypeErreur
							.equals("E"))))
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
								.getInt("CODE_STATUT_REGULARISATION"), result
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
			Date debut = new Date(
					Calendar.getInstance().get(Calendar.YEAR) - 1900, 0, 1);
			String query = "SELECT * FROM ERREUR_CAISSE WHERE CODE_AGENCE = '"
					+ codeAgence.toUpperCase()
					+ "' AND DATE_VACATION BETWEEN to_date('"
					+ new SimpleDateFormat("yyyy/MM/dd").format(debut)
					+ "', 'yyyy/mm/dd') AND to_date('"
					+ new SimpleDateFormat("yyyy/MM/dd").format(dateVacation)
					+ "', 'yyyy/mm/dd')";
			if (codeTypeErreur != null
					&& ((codeTypeErreur.equals("D")) || (codeTypeErreur
							.equals("E"))))
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
								.getInt("CODE_STATUT_REGULARISATION"), result
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
			String codeAgent) throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			String query = "SELECT * FROM ERREUR_CAISSE WHERE CODE_AGENT LIKE '"
					+ codeAgent.toUpperCase() + "'";
			ResultSet result = select.executeQuery(query);

			while (result.next()) {

				results.add(new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), result
								.getString("CODE_TYPE_ERREUR"), result
								.getString("CODE_AGENCE"), result
								.getInt("CODE_STATUT_REGULARISATION"), result
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
			String query = "SELECT * FROM ERREUR_CAISSE WHERE CODE_AGENT = '"
					+ codeAgent.toUpperCase() + "'";

			if (dateDebut != null && dateFin != null)
				query += " AND DATE_VACATION BETWEEN to_date('"
						+ new SimpleDateFormat("yyyy/MM/dd").format(dateDebut)
						+ "', 'yyyy/mm/dd') AND to_date('"
						+ new SimpleDateFormat("yyyy/MM/dd").format(dateFin)
						+ "', 'yyyy/mm/dd')";

			else if (dateDebut != null)
				query += " AND DATE_VACATION => to_date('"
						+ new SimpleDateFormat("yyyy/MM/dd").format(dateDebut)
						+ "', 'yyyy/mm/dd')";

			else if (dateFin != null)
				query += " AND DATE_VACATION <= to_date('"
						+ new SimpleDateFormat("yyyy/MM/dd").format(dateFin)
						+ "', 'yyyy/mm/dd')";

			if (codeTypeErreur != null
					&& ((codeTypeErreur.equals("D")) || (codeTypeErreur
							.equals("E"))))
				query += " AND CODE_TYPE_ERREUR LIKE '" + codeTypeErreur + "'";
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
								.getInt("CODE_STATUT_REGULARISATION"), result
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
			String query = "SELECT * FROM ERREUR_CAISSE WHERE CODE_AGENT LIKE '"
					+ codeAgent.toUpperCase()
					+ "' AND DATE_VACATION = to_date('"
					+ new SimpleDateFormat("yyyy/MM/dd").format(dateVacation)
					+ "', 'yyyy/mm/dd') AND CODE_TYPE_ERREUR LIKE '"
					+ codeTypeErreur.toUpperCase() + "'";

			ResultSet result = select.executeQuery(query);

			while (result.next()) {
				results.add(new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), result
								.getString("CODE_TYPE_ERREUR"), result
								.getString("CODE_AGENCE"), result
								.getInt("CODE_STATUT_REGULARISATION"), result
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

	@SuppressWarnings("deprecation")
	public static ArrayList<ErreurCaisse> selectErreursCaisseByAgence(
			String codeAgence, Date dateDebut, Date dateFin,
			String codeTypeErreur, int codeStatusRegularisation)
			throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();

			if (dateFin != null)
				dateFin.setDate(dateFin.getDate() + 1);

			String query = "SELECT * FROM ERREUR_CAISSE WHERE CODE_AGENCE = '"
					+ codeAgence.toUpperCase()
					+ "' AND DATE_VACATION BETWEEN to_date('"
					+ new SimpleDateFormat("yyyy/MM/dd").format(dateDebut)
					+ "', 'yyyy/mm/dd') AND to_date('"
					+ new SimpleDateFormat("yyyy/MM/dd").format(dateFin)
					+ "', 'yyyy/mm/dd')";
			if ((codeTypeErreur != null) && ((codeTypeErreur.equals("D")) || (codeTypeErreur.equals("E"))))
				query += "' AND CODE_TYPE_ERREUR = '" + codeTypeErreur.toUpperCase() + "'";
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
								.getInt("CODE_STATUT_REGULARISATION"), result
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

	@SuppressWarnings("deprecation")
	public static ArrayList<ErreurCaisse> selectErreursCaisseAgentSup(
			String codeAgence, String codeAgent, Date dateDebut, Date dateFin,
			String codeTypeErreur, int codeStatusRegularisation)
			throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();

			if (dateFin != null)
				dateFin.setDate(dateFin.getDate() + 1);
			String queryAnd = " WHERE ";
			String query = "SELECT * FROM ERREUR_CAISSE";
			if (codeAgence != null)
			{
				query += queryAnd + "CODE_AGENCE LIKE '"	+ codeAgence.toUpperCase() + "'";
				queryAnd = " AND ";
			}
			if (codeAgent != null)
			{
				query += queryAnd + "CODE_AGENT LIKE '"	+ codeAgent.toUpperCase() + "'";
				queryAnd = " AND ";
			}
			if (dateDebut != null && dateFin != null)
			{
				query += queryAnd + "DATE_VACATION BETWEEN to_date('"
						+ new SimpleDateFormat("yyyy/MM/dd").format(dateDebut)
						+ "', 'yyyy/mm/dd') AND to_date('"
						+ new SimpleDateFormat("yyyy/MM/dd").format(dateFin)
						+ "', 'yyyy/mm/dd')";
				queryAnd = " AND ";
			}
			else if (dateDebut != null)
			{
				query += queryAnd + "DATE_VACATION => to_date('"
						+ new SimpleDateFormat("yyyy/MM/dd").format(dateDebut)
						+ "', 'yyyy/mm/dd')";
				queryAnd = " AND ";
			}

			else if (dateFin != null)
			{
				query += queryAnd + "DATE_VACATION <= to_date('"
						+ new SimpleDateFormat("yyyy/MM/dd").format(dateFin)
						+ "', 'yyyy/mm/dd')";
				queryAnd = " AND ";
			}
			if ((codeTypeErreur != null) && ((codeTypeErreur.equals("D")) || (codeTypeErreur.equals("E"))))
			{
				query += queryAnd + "CODE_TYPE_ERREUR LIKE '" + codeTypeErreur + "'";
				queryAnd = " AND ";
			}
			if ((codeStatusRegularisation >= 0)	&& (codeStatusRegularisation <= 2))
			{
				query += queryAnd + "CODE_STATUT_REGULARISATION = '"
						+ codeStatusRegularisation + "'";
			}
			ResultSet result = select.executeQuery(query);

			while (result.next()) {
				results.add(new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), result
								.getString("CODE_TYPE_ERREUR"), result
								.getString("CODE_AGENCE"), result
								.getInt("CODE_STATUT_REGULARISATION"), result
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
			insert = Connexion.getInstance().getConnection().createStatement();
			insert.executeQuery("INSERT INTO ERREUR_CAISSE VALUES ('', '"
					+ codeAgent.toUpperCase() + "', '"
					+ typeErreur.toUpperCase() + "', '"
					+ codeAgence.toUpperCase() + "', 0 , to_date('"
					+ new SimpleDateFormat("yyyy/MM/dd").format(dateVacation)
					+ "', 'yyyy/mm/dd'), " + montant + ")");
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
		String query = "UPDATE ERREUR_CAISSE SET CODE_STATUT_REGULARISATION = "
				+ nouveauCodeStatusRegularisation
				+ " WHERE ERREUR_CAISSE_ID = " + erreurCaisseId;
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
			Statement select = Connexion.getInstance().getConnection()
					.createStatement();
			ResultSet result = select
					.executeQuery("SELECT * FROM ERREUR_CAISSE WHERE ERREUR_CAISSE_ID = '"
							+ erreurCaisseId + "'");
			if (result.next()) {
				// System.out.println(result.getInt("ERREUR_CAISSE_ID"));
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

	public static ArrayList<ErreurCaisse> selectAll() throws SQLException {
		Statement select = null;
		ArrayList<ErreurCaisse> results = new ArrayList<ErreurCaisse>();
		try {
			select = Connexion.getInstance().getConnection().createStatement();
			String query = "SELECT * FROM ERREUR_CAISSE";

			ResultSet result = select.executeQuery(query);

			while (result.next()) {
				results.add(new ErreurCaisse(result.getInt("ERREUR_CAISSE_ID"),
						result.getString("CODE_AGENT"), result
								.getString("CODE_TYPE_ERREUR"), result
								.getString("CODE_AGENCE"), result
								.getInt("CODE_STATUT_REGULARISATION"), result
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

}

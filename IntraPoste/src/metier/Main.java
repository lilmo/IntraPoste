package metier;

import java.sql.SQLException;
import java.util.ArrayList;

import bdd.AgenceDAO;
import bdd.MotifRegularisationDAO;

public class Main {

	public static void main(String args[]) throws SQLException {
		// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// System.out.println("Connecting to the database...");
		// Connection connection = DriverManager.getConnection(
		// "jdbc:oracle:thin:@localhost:1521:", "MORGANE", "a");
		// Statement select = connection.createStatement();
		// ResultSet result = select
		// .executeQuery("SELECT CODE_AGENCE, NOM_AGENCE FROM AGENCE");
		//
		// System.out.println("Got results:");
		// while (result.next()) { // process results one row at a time
		// String key = result.getString(1);
		// String val = result.getString(2);
		//
		// System.out.println("key = " + key);
		// System.out.println("val = " + val);
		// }
//		ArrayList<Agence> agences = AgenceDAO.selectByNom("Marseille");
		
		MotifRegularisationDAO.empty();
		MotifRegularisationDAO.selectAll();
		MotifRegularisationDAO.insert("BANANE");

		MotifRegularisation m = MotifRegularisationDAO.selectByCode(MotifRegularisationDAO.selectByNom("BANANE").get(0).getCodeMotifRegularisation());
		if (m != null)
			System.out.println(m.toString());
		
		MotifRegularisationDAO.update(m.getCodeMotifRegularisation(), "OSSI");
		
		m = MotifRegularisationDAO.selectByCode(MotifRegularisationDAO.selectByNom("OSSI").get(0).getCodeMotifRegularisation());
		if (m != null)
			System.out.println(m.toString());
		System.out.println(m.toString());
		
		AgenceDAO.insert("ABC", "CD");
		ArrayList<Agence> agences = AgenceDAO.selectAll();
		for (Agence a : agences) {
			System.out.println(a.getCodeAgence());
			System.out.println(a.getNomAgence());
		}
		AgenceDAO.update("AB", "CDEF");
		agences = AgenceDAO.selectAll();
		for (Agence a : agences) {
			System.out.println(a.getCodeAgence());
			System.out.println(a.getNomAgence());
		}
	}
}

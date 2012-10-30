package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bdd.AgenceDAO;

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
		ArrayList<Agence> agences = AgenceDAO.selectByNom("Marseille");
		for (Agence a : agences) {
			System.out.println(a.getCodeAgence());
			System.out.println(a.getNomAgence());
		}
	}
}

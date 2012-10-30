/**
 * ConnectOracle.java
 */
package com.javaworkspace.connectoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author www.javaworkspace.com
 * 
 */
public class ConnectOracle {

	public static void main(String[] args) {

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("Connecting to the database...");
			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:", "MORGANE", "a");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select 'Connected' from dual");
			resultset.next();
			String s = resultset.getString(1);
			System.out.println(s);
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("The exception raised is:" + e);
		}
	}
	
}

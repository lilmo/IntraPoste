package metier;

import java.sql.SQLException;

import bdd.MotifRegularisationDAO;
import bdd.StatusRegularisationDAO;
import bdd.TypeAgentDAO;
import bdd.TypeErreurDAO;
import bdd.TypeRegularisationDAO;

public class Main {

	public static void main(String args[]) throws SQLException {
		initialiserBase();
	}
	
	private static void initialiserBase() throws SQLException
	{
		MotifRegularisationDAO.init();
		StatusRegularisationDAO.init();
		TypeAgentDAO.init();
		TypeErreurDAO.init();
		TypeRegularisationDAO.init();
	}
}

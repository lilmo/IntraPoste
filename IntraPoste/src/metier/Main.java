package metier;

import java.sql.SQLException;

import bdd.AgenceDAO;
import bdd.AgentDAO;
import bdd.ErreurCaisseDAO;
import bdd.ErreurCaisseRegularisationDAO;
import bdd.MotifRegularisationDAO;
import bdd.StatusRegularisationDAO;
import bdd.TypeAgentDAO;
import bdd.TypeErreurDAO;
import bdd.TypeRegularisationDAO;

public class Main {

	public static void main(String args[]) throws SQLException, InterruptedException {
		emptyBase();
		initialiserBase();
		System.out.println("Done !");
	}
	
	public static void initFromServlet() throws SQLException, InterruptedException
	{
	    emptyBase();
        initialiserBase();
	}
	
	private static void initialiserBase() throws SQLException, InterruptedException
	{
		MotifRegularisationDAO.init();
		StatusRegularisationDAO.init();
		TypeAgentDAO.init();
		TypeErreurDAO.init();
		TypeRegularisationDAO.init();
		AgenceDAO.init();
		AgentDAO.init();
		ErreurCaisseDAO.init();
		ErreurCaisseRegularisationDAO.init();
	}
	
	private static void emptyBase() throws SQLException
	{
		ErreurCaisseRegularisationDAO.empty();
		ErreurCaisseDAO.empty();
		MotifRegularisationDAO.empty();
		AgentDAO.empty();
		AgenceDAO.empty();
		TypeAgentDAO.empty();
		TypeErreurDAO.empty();
		TypeRegularisationDAO.empty();
		StatusRegularisationDAO.empty();
	}
}

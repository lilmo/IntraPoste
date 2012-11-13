/**
 * 
 */
package tests.bdd.agent;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import metier.Agent;

import org.junit.Before;
import org.junit.Test;

import bdd.AgentDAO;

/**
 * @author Emilie
 *
 */
public class InsertTest {

	ArrayList<Agent> agents;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		AgentDAO.init();

		agents = AgentDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(agents.size() == 10);
		for (Agent m : agents)
			assertTrue(m.getNom().equals("LOPVET")
					|| m.getNom().equals("GUYONNET")
					|| m.getNom().equals("CANARD")
					|| m.getNom().equals("TARTINE")
					|| m.getNom().equals("POULET")
					|| m.getNom().equals("BONNIN")
					|| m.getNom().equals("CHARMANT")
					|| m.getNom().equals("CANARDE")
					|| m.getNom().equals("LADOUILLE")
					|| m.getNom().equals("CHOCAPIC"));
	}

}

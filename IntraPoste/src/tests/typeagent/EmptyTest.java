package tests.typeagent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeAgent;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeAgentDAO;

public class EmptyTest {

	ArrayList<TypeAgent> types;

	@Before
	public void setUp() throws Exception {
		TypeAgentDAO.insert(0, "DIRECTION");
		TypeAgentDAO.insert(1, "COMPTABLE");
		TypeAgentDAO.insert(2, "GUICHET");

		types = TypeAgentDAO.selectAll();
		assertFalse(types.isEmpty());

		TypeAgentDAO.empty();
		types = TypeAgentDAO.selectAll();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(types.isEmpty());
	}

}

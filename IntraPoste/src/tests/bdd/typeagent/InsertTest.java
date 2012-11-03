package tests.bdd.typeagent;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import metier.TypeAgent;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeAgentDAO;

public class InsertTest {

	ArrayList<TypeAgent> types;

	@Before
	public void setUp() throws Exception {
		TypeAgentDAO.empty();

		TypeAgentDAO.insert(0, "DIRECTION");
		TypeAgentDAO.insert(1, "COMPTABLE");
		TypeAgentDAO.insert(2, "GUICHET");

		types = TypeAgentDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(types.size() == 3);
		for (TypeAgent s : types)
			assertTrue(s.getNomTypeAgent().equals("DIRECTION")
					|| s.getNomTypeAgent().equals(
							"COMPTABLE")
					|| s.getNomTypeAgent().equals(
							"GUICHET"));
	}
}

package tests.typeagent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeAgent;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeAgentDAO;

public class SelectByCodeTest {

	ArrayList<TypeAgent> types;
	int codeStatus;

	@Before
	public void setUp() throws Exception {
		TypeAgentDAO.empty();

		TypeAgentDAO.insert(0, "DIRECTION");

		types = TypeAgentDAO.selectAll();

		codeStatus = types.get(0).getCodeTypeAgent();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(TypeAgentDAO.selectByCode(codeStatus) != null);
		assertFalse(TypeAgentDAO.selectByCode(codeStatus + 1) != null);
	}
}

package tests.typeagent;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeAgent;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeAgentDAO;

public class SelectByNomTest {

	ArrayList<TypeAgent> types;
	String nomTypes;

	@Before
	public void setUp() throws Exception {
		TypeAgentDAO.empty();
		
		TypeAgentDAO.insert(0, "DIRECTION");

		types = TypeAgentDAO.selectAll();
		nomTypes = types.get(0).getNomTypeAgent();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(TypeAgentDAO.selectByNom(nomTypes).size() == 1);
		assertTrue(TypeAgentDAO.selectByNom("B").isEmpty());
	}
}

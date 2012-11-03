package tests.agence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.Agence;

import org.junit.Before;
import org.junit.Test;

import bdd.AgenceDAO;

public class SelectByCodeTest {

	ArrayList<Agence> agences;
	String codeAgence;

	@Before
	public void setUp() throws Exception {
		AgenceDAO.empty();

		AgenceDAO.insert("AB", "AGNEAU");

		agences = AgenceDAO.selectAll();

		codeAgence = agences.get(0).getCodeAgence();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(AgenceDAO.selectByCode(codeAgence) != null);
		assertFalse(AgenceDAO.selectByCode("D") != null);
	}
}

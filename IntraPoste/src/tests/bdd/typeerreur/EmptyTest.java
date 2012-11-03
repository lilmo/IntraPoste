package tests.bdd.typeerreur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeErreur;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeErreurDAO;

public class EmptyTest {

	ArrayList<TypeErreur> types;

	@Before
	public void setUp() throws Exception {
		TypeErreurDAO.insert("E", "EXCEDENT");
		TypeErreurDAO.insert("D", "DEFICIT");

		types = TypeErreurDAO.selectAll();
		assertFalse(types.isEmpty());

		TypeErreurDAO.empty();
		types = TypeErreurDAO.selectAll();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(types.isEmpty());
	}

}

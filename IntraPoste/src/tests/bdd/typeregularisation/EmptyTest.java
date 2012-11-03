package tests.bdd.typeregularisation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeRegularisationDAO;

public class EmptyTest {

	ArrayList<TypeRegularisation> types;

	@Before
	public void setUp() throws Exception {
		TypeRegularisationDAO.insert(0, "PARTIELLE");
		TypeRegularisationDAO.insert(1, "TOTALE");

		types = TypeRegularisationDAO.selectAll();
		assertFalse(types.isEmpty());

		TypeRegularisationDAO.empty();
		types = TypeRegularisationDAO.selectAll();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(types.isEmpty());
	}

}

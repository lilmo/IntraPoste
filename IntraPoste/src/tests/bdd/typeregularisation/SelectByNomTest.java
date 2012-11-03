package tests.bdd.typeregularisation;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeRegularisationDAO;

public class SelectByNomTest {

	ArrayList<TypeRegularisation> types;
	String nomTypes;

	@Before
	public void setUp() throws Exception {
		TypeRegularisationDAO.empty();

		TypeRegularisationDAO.insert(1, "TOTALE");

		types = TypeRegularisationDAO.selectAll();
		nomTypes = types.get(0).getNomTypeRegularisation();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(TypeRegularisationDAO.selectByNom(nomTypes).size() == 1);
		assertTrue(TypeRegularisationDAO.selectByNom("B").isEmpty());
	}
}

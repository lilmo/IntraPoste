package tests.bdd.typeregularisation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeRegularisationDAO;

public class SelectByCodeTest {

	ArrayList<TypeRegularisation> types;
	int codeStatus;

	@Before
	public void setUp() throws Exception {
		TypeRegularisationDAO.empty();

		TypeRegularisationDAO.insert(0, "PARTIELLE");

		types = TypeRegularisationDAO.selectAll();

		codeStatus = types.get(0).getCodeTypeRegularisation();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(TypeRegularisationDAO.selectByCode(codeStatus) != null);
		assertFalse(TypeRegularisationDAO.selectByCode(codeStatus + 1) != null);
	}
}

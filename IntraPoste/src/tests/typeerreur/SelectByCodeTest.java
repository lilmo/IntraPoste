package tests.typeerreur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeErreur;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeErreurDAO;

public class SelectByCodeTest {

	ArrayList<TypeErreur> types;
	String codeType;

	@Before
	public void setUp() throws Exception {
		TypeErreurDAO.empty();

		TypeErreurDAO.insert("E", "EXCEDENT");

		types = TypeErreurDAO.selectAll();

		codeType = types.get(0).getCodeTypeErreur();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(TypeErreurDAO.selectByCode(codeType) != null);
		assertFalse(TypeErreurDAO.selectByCode("D") != null);
	}
}

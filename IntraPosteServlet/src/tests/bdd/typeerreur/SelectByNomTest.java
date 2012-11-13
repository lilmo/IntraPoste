package tests.bdd.typeerreur;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.TypeErreur;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeErreurDAO;

public class SelectByNomTest {

	ArrayList<TypeErreur> types;
	String nomTypes;

	@Before
	public void setUp() throws Exception {
		TypeErreurDAO.empty();
		
		TypeErreurDAO.insert("E", "EXCEDENT");

		types = TypeErreurDAO.selectAll();
		nomTypes = types.get(0).getNomTypeErreur();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(TypeErreurDAO.selectByNom(nomTypes).size() == 1);
		assertTrue(TypeErreurDAO.selectByNom("B").isEmpty());
	}
}

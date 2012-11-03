package tests.bdd.typeerreur;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import metier.TypeErreur;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeErreurDAO;

public class InsertTest {

	ArrayList<TypeErreur> types;

	@Before
	public void setUp() throws Exception {
		TypeErreurDAO.empty();

		TypeErreurDAO.insert("E", "EXCEDENT");
		TypeErreurDAO.insert("D", "DEFICIT");

		types = TypeErreurDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(types.size() == 2);
		for (TypeErreur s : types)
			assertTrue(s.getNomTypeErreur().equals("EXCEDENT")
					|| s.getNomTypeErreur().equals(
							"DEFICIT"));
	}
}

package tests.typeregularisation;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import metier.TypeRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.TypeRegularisationDAO;

public class InsertTest {

	ArrayList<TypeRegularisation> types;

	@Before
	public void setUp() throws Exception {
		TypeRegularisationDAO.empty();

		TypeRegularisationDAO.insert(0, "PARTIELLE");
		TypeRegularisationDAO.insert(1, "TOTALE");

		types = TypeRegularisationDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(types.size() == 2);
		for (TypeRegularisation s : types)
			assertTrue(s.getNomTypeRegularisation().equals("PARTIELLE")
					|| s.getNomTypeRegularisation().equals(
							"TOTALE"));
	}
}

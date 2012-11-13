package tests.bdd.statusregularisation;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import metier.StatusRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.StatusRegularisationDAO;

public class InsertTest {

	ArrayList<StatusRegularisation> status;

	@Before
	public void setUp() throws Exception {
		StatusRegularisationDAO.empty();

		StatusRegularisationDAO.insert(0, "DECLAREE");
		StatusRegularisationDAO.insert(1, "PARTIELLEMENT REGULARISEE");
		StatusRegularisationDAO.insert(2, "TOTALEMENT REGULARISEE");

		status = StatusRegularisationDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(status.size() == 3);
		for (StatusRegularisation s : status)
			assertTrue(s.getNomStatusRegularisation().equals("DECLAREE")
					|| s.getNomStatusRegularisation().equals(
							"PARTIELLEMENT REGULARISEE")
					|| s.getNomStatusRegularisation().equals(
							"TOTALEMENT REGULARISEE"));
	}
}

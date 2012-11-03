package tests.bdd.statusregularisation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.StatusRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.StatusRegularisationDAO;

public class EmptyTest {

	ArrayList<StatusRegularisation> status;

	@Before
	public void setUp() throws Exception {
		StatusRegularisationDAO.insert(0, "DECLAREE");
		StatusRegularisationDAO.insert(1, "PARTIELLEMENT REGULARISEE");
		StatusRegularisationDAO.insert(2, "TOTALEMENT REGULARISEE");

		status = StatusRegularisationDAO.selectAll();
		assertFalse(status.isEmpty());
		
		StatusRegularisationDAO.empty();
		status = StatusRegularisationDAO.selectAll();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(status.isEmpty());
	}

}

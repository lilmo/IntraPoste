package tests.statusregularisation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.StatusRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.StatusRegularisationDAO;

public class SelectByCodeTest {

	ArrayList<StatusRegularisation> status;
	int codeStatus;

	@Before
	public void setUp() throws Exception {
		StatusRegularisationDAO.empty();

		StatusRegularisationDAO.insert(0, "DECLAREE");

		status = StatusRegularisationDAO.selectAll();

		codeStatus = status.get(0).getCodeStatusRegularisation();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(StatusRegularisationDAO.selectByCode(codeStatus) != null);
		assertFalse(StatusRegularisationDAO.selectByCode(codeStatus + 1) != null);
	}
}

package tests.statusregularisationtests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.StatusRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.StatusRegularisationDAO;

public class SelectByNomTest {

	ArrayList<StatusRegularisation> status;
	String nomStatus;

	@Before
	public void setUp() throws Exception {
		StatusRegularisationDAO.empty();
		
		StatusRegularisationDAO.insert(0, "DECLAREE");

		status = StatusRegularisationDAO.selectAll();
		nomStatus = status.get(0).getNomStatusRegularisation();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(StatusRegularisationDAO.selectByNom(nomStatus).size() == 1);
		assertTrue(StatusRegularisationDAO.selectByNom("B").isEmpty());
	}
}

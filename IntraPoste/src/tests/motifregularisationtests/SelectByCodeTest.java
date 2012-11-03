package tests.motifregularisationtests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.MotifRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.MotifRegularisationDAO;

public class SelectByCodeTest {

	ArrayList<MotifRegularisation> motifs;
	int codeMotif;

	@Before
	public void setUp() throws Exception {
		MotifRegularisationDAO.empty();
		
		MotifRegularisationDAO.insert("REJET REGULARISE");

		motifs = MotifRegularisationDAO.selectAll();
		codeMotif = motifs.get(0).getCodeMotifRegularisation();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(MotifRegularisationDAO.selectByCode(codeMotif) != null);
		assertFalse(MotifRegularisationDAO.selectByCode(codeMotif + 1) != null);
	}
}

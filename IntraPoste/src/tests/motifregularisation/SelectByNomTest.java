package tests.motifregularisation;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.MotifRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.MotifRegularisationDAO;

public class SelectByNomTest {

	ArrayList<MotifRegularisation> motifs;
	String nomMotif;

	@Before
	public void setUp() throws Exception {
		MotifRegularisationDAO.empty();
		
		MotifRegularisationDAO.insert("REJET REGULARISE");

		motifs = MotifRegularisationDAO.selectAll();
		nomMotif = motifs.get(0).getNomMotifRegularisation();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(MotifRegularisationDAO.selectByNom(nomMotif).size() == 1);
		assertTrue(MotifRegularisationDAO.selectByNom("B").isEmpty());
	}
}

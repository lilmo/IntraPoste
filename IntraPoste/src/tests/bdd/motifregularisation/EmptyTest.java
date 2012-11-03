package tests.bdd.motifregularisation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import metier.MotifRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.MotifRegularisationDAO;

public class EmptyTest {
	
	ArrayList<MotifRegularisation> motifs;

	@Before
	public void setUp() throws Exception {
		MotifRegularisationDAO.insert("REJET REGULARISE");
		MotifRegularisationDAO.insert("ERREUR RETROUVEE");
		MotifRegularisationDAO.insert("COMBLEE EN NUMERAIRE");
		MotifRegularisationDAO.insert("PRISE EN RECETTE");
		MotifRegularisationDAO.insert("REMBOURSEE A L UTILISATEUR");
		MotifRegularisationDAO.insert("ERREUR DE COMPTABILITE RETROUVEE");
		MotifRegularisationDAO.empty();
		motifs = MotifRegularisationDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(motifs.isEmpty());
	}

}

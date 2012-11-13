package tests.bdd.motifregularisation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import metier.MotifRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.MotifRegularisationDAO;

public class InsertTest {

	ArrayList<MotifRegularisation> motifs;

	@Before
	public void setUp() throws Exception {
		MotifRegularisationDAO.empty();
		
		MotifRegularisationDAO.insert("REJET REGULARISE");
		MotifRegularisationDAO.insert("ERREUR RETROUVEE");
		MotifRegularisationDAO.insert("COMBLEE EN NUMERAIRE");
		MotifRegularisationDAO.insert("PRISE EN RECETTE");
		MotifRegularisationDAO.insert("REMBOURSEE A L UTILISATEUR");
		MotifRegularisationDAO.insert("ERREUR DE COMPTABILITE RETROUVEE");

		motifs = MotifRegularisationDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(motifs.size() == 6);
		for (MotifRegularisation m : motifs)
			assertTrue(m.getNomMotifRegularisation().equals("REJET REGULARISE")
					|| m.getNomMotifRegularisation().equals("ERREUR RETROUVEE")
					|| m.getNomMotifRegularisation().equals("COMBLEE EN NUMERAIRE")
					|| m.getNomMotifRegularisation().equals("PRISE EN RECETTE")
					|| m.getNomMotifRegularisation().equals("REMBOURSEE A L UTILISATEUR")
					|| m.getNomMotifRegularisation().equals("ERREUR DE COMPTABILITE RETROUVEE"));
	}
}

package tests.bdd.motifregularisation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import metier.MotifRegularisation;

import org.junit.Before;
import org.junit.Test;

import bdd.MotifRegularisationDAO;

public class UpdateTest {

	ArrayList<MotifRegularisation> motifs = null;
	int codeMotifRegularisationRejet = -1;
	int codeMotifRegularisationComble = -1;

	@Before
	public void setUp() throws Exception {
		MotifRegularisationDAO.empty();
		
		MotifRegularisationDAO.insert("REJET REGULARISE");
		MotifRegularisationDAO.insert("COMBLE EN NUMERAIRE");
		
		motifs = MotifRegularisationDAO.selectAll();
		
		for (MotifRegularisation m : motifs)
			if (m.getNomMotifRegularisation().equals("REJET REGULARISE"))
				codeMotifRegularisationRejet = m.getCodeMotifRegularisation();
			else
				codeMotifRegularisationComble = m.getCodeMotifRegularisation();
		
		MotifRegularisationDAO.update(codeMotifRegularisationRejet, "HELLO");
		
		motifs = MotifRegularisationDAO.selectAll();
	}

	@Test
	public void test() {
		for (MotifRegularisation m : motifs)
		{
			assertFalse(m.getNomMotifRegularisation().equals("REJET REGULARISE"));
			if (m.getNomMotifRegularisation().equals("HELLO"))
				assertTrue(m.getCodeMotifRegularisation() == codeMotifRegularisationRejet);
			else
			{
				assertTrue(m.getCodeMotifRegularisation() == codeMotifRegularisationComble);
				assertTrue(m.getNomMotifRegularisation().equals("COMBLE EN NUMERAIRE"));
			}
		}
	}
}

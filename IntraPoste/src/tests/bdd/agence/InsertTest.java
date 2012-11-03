package tests.bdd.agence;

import static org.junit.Assert.*;

import java.util.ArrayList;

import metier.Agence;

import org.junit.Before;
import org.junit.Test;

import bdd.AgenceDAO;

public class InsertTest {

	ArrayList<Agence> agences;

	@Before
	public void setUp() throws Exception {
		AgenceDAO.empty();
		
		AgenceDAO.insert("AB", "AGNEAU");
		AgenceDAO.insert("CD", "BOEUF");
		AgenceDAO.insert("EF", "POULE");

		agences = AgenceDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(agences.size() == 3);
		for (Agence m : agences)
			assertTrue(m.getNomAgence().equals("AGNEAU")
					|| m.getNomAgence().equals("BOEUF")
					|| m.getNomAgence().equals("POULE"));
	}
}

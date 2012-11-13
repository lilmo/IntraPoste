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
		AgenceDAO.init();

		agences = AgenceDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(agences.size() == 6);
		for (Agence m : agences)
			assertTrue(m.getNomAgence().equals("POSTE PARIS 1")
					|| m.getNomAgence().equals("POSTE PARIS 20")
					|| m.getNomAgence().equals("POSTE ANTONY GARE")
					|| m.getNomAgence().equals("POSTE VINCENNES FONTENAY")
					|| m.getNomAgence().equals("POSTE ARCHE DEFENSE")
					|| m.getNomAgence().equals("POSTE LA DEFENSE CENTRE CIAL"));
	}
}

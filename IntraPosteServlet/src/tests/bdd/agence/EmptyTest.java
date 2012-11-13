package tests.bdd.agence;

import static org.junit.Assert.*;

import java.util.ArrayList;

import metier.Agence;

import org.junit.Before;
import org.junit.Test;

import bdd.AgenceDAO;

public class EmptyTest {
	
	ArrayList<Agence> agences;

	@Before
	public void setUp() throws Exception {
		AgenceDAO.insert("AB", "AGNEAU");
		AgenceDAO.insert("CD", "BOEUF");
		AgenceDAO.insert("EF", "POULE");
		
		AgenceDAO.empty();
		agences = AgenceDAO.selectAll();
	}

	@Test
	public void test() {
		assertTrue(agences.isEmpty());
	}

}

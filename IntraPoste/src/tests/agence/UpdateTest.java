package tests.agence;

import static org.junit.Assert.*;

import java.util.ArrayList;

import metier.Agence;

import org.junit.Before;
import org.junit.Test;

import bdd.AgenceDAO;

public class UpdateTest {

	ArrayList<Agence> agences = null;
	String codeAgenceAgneau = null;
	String codeAgenceBoeuf = null;

	@Before
	public void setUp() throws Exception {
		AgenceDAO.empty();
		
		AgenceDAO.insert("AB", "AGNEAU");
		AgenceDAO.insert("CD", "BOEUF");
		
		agences = AgenceDAO.selectAll();
		
		for (Agence a : agences)
			if (a.getNomAgence().equals("AGNEAU"))
				codeAgenceAgneau = a.getCodeAgence();
			else
				codeAgenceBoeuf = a.getCodeAgence();
		
		AgenceDAO.update(codeAgenceAgneau, "HELLO");
		
		agences = AgenceDAO.selectAll();
	}

	@Test
	public void test() {
		for (Agence m : agences)
		{
			assertFalse(m.getNomAgence().equals("AGNEAU"));
			if (m.getNomAgence().equals("HELLO"))
				assertTrue(m.getCodeAgence().equals(codeAgenceAgneau));
			else
			{
				assertTrue(m.getCodeAgence().equals(codeAgenceBoeuf));
				assertTrue(m.getNomAgence().equals("BOEUF"));
			}
		}
	}
}

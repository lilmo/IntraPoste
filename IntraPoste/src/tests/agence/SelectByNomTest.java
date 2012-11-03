package tests.agence;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import metier.Agence;

import org.junit.Before;
import org.junit.Test;

import bdd.AgenceDAO;

public class SelectByNomTest {

	ArrayList<Agence> agences;
	String nomAgences;

	@Before
	public void setUp() throws Exception {
		AgenceDAO.empty();
		
		AgenceDAO.insert("AB", "AGNEAU");

		agences = AgenceDAO.selectAll();
		nomAgences = agences.get(0).getNomAgence();
	}

	@Test
	public void test() throws SQLException {
		assertTrue(AgenceDAO.selectByNom(nomAgences).size() == 1);
		assertTrue(AgenceDAO.selectByNom("B").isEmpty());
	}
}

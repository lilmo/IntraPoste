package tests.bdd.motifregularisation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmptyTest.class, InsertTest.class, SelectByCodeTest.class,
		SelectByNomTest.class, UpdateTest.class })
public class AllTests {

}

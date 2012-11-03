package tests.typeagent;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmptyTest.class, InsertTest.class, SelectByCodeTest.class,
		SelectByNomTest.class })
public class AllTests {

}

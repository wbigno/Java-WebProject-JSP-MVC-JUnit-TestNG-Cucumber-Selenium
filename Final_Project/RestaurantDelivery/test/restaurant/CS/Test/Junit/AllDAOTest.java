package restaurant.CS.Test.Junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({UserDAOTest.class, ReviewDAOTest.class, PaymentDAOTest.class, OrderDAOTest.class, LocationDAOTest.class, ItemDAOTest.class})
public class AllDAOTest {

}

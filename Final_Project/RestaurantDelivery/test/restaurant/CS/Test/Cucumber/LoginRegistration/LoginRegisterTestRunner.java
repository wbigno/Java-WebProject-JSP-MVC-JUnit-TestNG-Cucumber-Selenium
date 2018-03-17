package restaurant.CS.Test.Cucumber.LoginRegistration;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="test/restaurant/CS/Test/Cucumber/LoginRegistration/LoginRegisterFunctionality.feature",
		glue="Cucumber/RestaurantDelivery/LoginRegisterFunctionality",
		plugin= {"pretty", "html:target/cucumber"},
		tags="@LoginUser-DataDriven, @RegisterNewUser-DataDriven"
		)
public class LoginRegisterTestRunner {

}

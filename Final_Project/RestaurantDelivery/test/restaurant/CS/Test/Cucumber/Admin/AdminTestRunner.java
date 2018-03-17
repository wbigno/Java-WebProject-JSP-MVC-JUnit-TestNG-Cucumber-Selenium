package restaurant.CS.Test.Cucumber.Admin;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="test/restaurant/CS/Test/Cucumber/Admin/AdminReport.feature",
		glue="Cucumber/RestaurantDelivery/AdminReport",
		plugin= {"pretty", "html:target/cucumber"},
		tags="@AdminUser-DataDriven, @AdminItemList-DataDriven, "
				+ "@AdminLocationList-DataDriven "
		)
public class AdminTestRunner {

}

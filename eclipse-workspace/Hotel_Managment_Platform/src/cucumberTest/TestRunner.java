package cucumberTest;
 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",
		glue={"stepDefinitions"},
		monochrome = true,
		plugin = {"pretty"}
		)
 
public class TestRunner {
 
}

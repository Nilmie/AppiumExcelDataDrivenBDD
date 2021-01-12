package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		
		glue = {"StepDefinition"},//Your step definitions package.
		features = {"src/main/java/Features"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}

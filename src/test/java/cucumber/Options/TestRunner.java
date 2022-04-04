package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (strict=true
		,features="src/test/java/Features"
		,plugin={"json:target/jsonReports/cucumber-report.json", "html:target/cucumber-reports"}
		,glue={"StepDefinitions"}
		,tags={"@DeletePlace or @UpdatePlace"}
		)
public class TestRunner {

}
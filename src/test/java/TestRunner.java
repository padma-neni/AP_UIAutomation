import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import gherkin.formatter.Reporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
                glue = {"com/automationpractice/stepDefinitions"},
                plugin = {"pretty",
                        "json:target/Json-reports/cucumber-json-report.json",
                        "html:target/site/cucumber-pretty",
                        "com.cucumber.listener.ExtentCucumberFormatter:target/site/extent-reports/index.html"},
                monochrome = true)
public class TestRunner {

}

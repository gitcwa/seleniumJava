package Stepdefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"Stepdefinition"},
monochrome = true,
plugin = {"pretty","html:target/HtmlReports.html",
		"json:target/Report.json",
		"junit:target/Report.xml"
		}
//tags = "@smoketest"
		)
public class TestRunner {
	

}

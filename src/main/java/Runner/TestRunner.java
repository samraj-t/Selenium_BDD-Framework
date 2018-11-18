package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.runtime.model.CucumberFeature;
import org.testng.annotations.*;
@CucumberOptions(
			
			glue = {"stepdefs"},//Your step definitions package.
			features = {"E:\\Selenium\\PageObject_DataDriven_ExtendReport_BDD\\src\\main\\java\\Features"})//Give the location of feature package

	public class TestRunner extends AbstractTestNGCucumberTests {

	}


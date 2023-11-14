package testRunner;
// This is the utilities package

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//feature/AddNewCustomer.feature", 
         glue = "stepDefinition", 
         dryRun = false,
		/*
		 * To check in console whether all the steps in feature file is implemented or
		 * not Set 'dryRun=true' and RunAs J unit Test - Once we see all the steps are
		 * implemented Then set 'dryRun=false' normally set it to 'false'
		 * 
		 */
		monochrome = true, 
        plugin = { "pretty", "html:Cucumber-Reports/report_html.html" })
//		plugin = { "pretty", "json:Cucumber-Reports/report_json.json" })



public class Run {
	/* THIS CLASS WILL BE KEPT EMPTY */

}

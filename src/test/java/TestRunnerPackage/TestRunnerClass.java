

package TestRunnerPackage;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
				features="src/test/java/features",
		        glue= {"stepdefination","hooks"},
		        monochrome=true,          //for reporting in proper format in console
		        dryRun=false,              //to check the mapping between features and stepdefination files  
		        tags= {"@tag1"},
		        plugin= {"pretty","html:reports/htmlreport"})    //to generate reporting

public class TestRunnerClass {	

}

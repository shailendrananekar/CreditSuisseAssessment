package RunnerFiles;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/java/FeatureFiles"},
        format = {"pretty", "html:target/cucumber-html-report"},
        glue = {"StepDefinitions"},
        tags = {"@Applicationlog"})

public class TestRunner {


}

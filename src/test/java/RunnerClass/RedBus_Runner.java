package RunnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Feature/RedBus.feature"}, glue = "StepDefinition")
public class RedBus_Runner extends AbstractTestNGCucumberTests {

}

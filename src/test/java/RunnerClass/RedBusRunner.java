package RunnerClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature/RedBus.feature"},
        glue = "StepDefinition",
        plugin = {"pretty", "html:reports/cucumber-html-report.html",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)

public class RedBusRunner extends AbstractTestNGCucumberTests {


}

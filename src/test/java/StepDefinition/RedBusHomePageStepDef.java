package StepDefinition;

import Manager.DriverManager;
import PageObject.RedBusHomePage;
import Utils.BaseUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RedBusHomePageStepDef {

        WebDriver driver;
        RedBusHomePage redbusHomePage;
        BaseUtils baseUtils;

        public RedBusHomePageStepDef()
        {
            driver = DriverManager.getDriver();
            redbusHomePage = new RedBusHomePage(driver);
            baseUtils = new BaseUtils();
        }
    @Given("user is inside redbus homepage")
    public void userIsInsideRedbusHomepage() {
        redbusHomePage.homePage();
    }

    @When("user enters from city for source")
    public void userEntersFromCity() {
        redbusHomePage.enterFromDetails(baseUtils.getjsonData("From"));
    }

    @And("user enters to city for destination")
    public void userEntersToCity(){
        redbusHomePage.enterToDetails(baseUtils.getjsonData("To"));
    }

    @And("user select date for journey")
    public void userSelectForJourney() {
        redbusHomePage.enterDate(baseUtils.getjsonData("Date"));
    }

    @Then("user click on search buses")
    public void userClickOnSearchBuses() {
        redbusHomePage.searchBuses();
    }

}

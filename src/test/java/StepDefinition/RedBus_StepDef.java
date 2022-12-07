package StepDefinition;

import Manager.DriverManager;
import PageObject.RedBus_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RedBus_StepDef {

        WebDriver driver;
        RedBus_Page redbus;

        public RedBus_StepDef()
        {
            driver = DriverManager.getDriver();
            redbus = new RedBus_Page(driver);
        }
    @Given("user is inside redbus homepage")
    public void userIsInsideRedbusHomepage() {
        redbus.homePage();
    }

    @When("user enters {string} city")
    public void userEntersFromCity(String from) {
        redbus.enterFromDetails(from);
    }

    @And("user enters {string} city\"")
    public void userEntersToCity(String to){
        redbus.enterToDetails(to);
    }

    @And("user select {string} for journey")
    public void userSelectForJourney(String date) {
         redbus.enterDate(date);
    }

    @Then("user click on search buses")
    public void userClickOnSearchBuses() {
          redbus.searchBuses();
    }

    @Then("user click on view seats for {string}")
    public void userClickOnViewSeatsFor(String bus) {
            redbus.clickOnViewSeats(bus);
    }

    @And("user selected the seat")
    public void userSelectedTheSeat() {
            redbus.selectSeat();
    }
}

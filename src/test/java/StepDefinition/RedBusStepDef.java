package StepDefinition;

import Manager.DriverManager;
import PageObject.RedBusPage;
import Utils.BaseUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RedBusStepDef {

        WebDriver driver;
        RedBusPage redbus;
        BaseUtils baseUtils;

        public RedBusStepDef()
        {
            driver = DriverManager.getDriver();
            redbus = new RedBusPage(driver);
            baseUtils = new BaseUtils();
        }
    @Given("user is inside redbus homepage")
    public void userIsInsideRedbusHomepage() {
        redbus.homePage();
    }

    @When("user enters from city for source")
    public void userEntersFromCity() {
        redbus.enterFromDetails(baseUtils.getjsonData("From"));
    }

    @And("user enters to city for destination")
    public void userEntersToCity(){
        redbus.enterToDetails(baseUtils.getjsonData("To"));
    }

    @And("user select date for journey")
    public void userSelectForJourney() {
        redbus.enterDate(baseUtils.getjsonData("Date"));
    }

    @Then("user click on search buses")
    public void userClickOnSearchBuses() {
          redbus.searchBuses();
    }

    @Then("user click on view seats")
    public void userClickOnViewSeatsFor() {
        redbus.clickOnViewSeats(baseUtils.getjsonData("Bus"));
    }

    @And("user selected the seat")
    public void userSelectedTheSeat() {
            redbus.selectSeat();
    }

    @Then("user selected the boarding point of source")
    public void userSelectedThe() {
        redbus.selectBoardingPoint(baseUtils.getjsonData("Boarding Point"));
    }

    @And("user selected the dropping point of destination")
    public void userSelectedTheOfDestination() {
        redbus.selectDroppingPoint(baseUtils.getjsonData("Dropping Point"));
    }

    /*
    @And("user click on continue button")
    public void userClickOnContinueButton() {
        redbus.clickOnContinue();
    }
    */

    @Then("user click on Proceed To Book")
    public void userClickOnProceedToBook() {
        redbus.proceedTGoBook();
        baseUtils.hardWait(2000);
    }

}

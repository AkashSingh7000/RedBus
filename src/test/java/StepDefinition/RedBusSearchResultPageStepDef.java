package StepDefinition;

import Manager.DriverManager;
import PageObject.RedBusHomePage;
import PageObject.RedBusSearchResultPage;
import Utils.BaseUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class RedBusSearchResultPageStepDef {

        WebDriver driver;
        RedBusSearchResultPage redBusSearchResultPage;
        BaseUtils baseUtils;

        public RedBusSearchResultPageStepDef()
        {
            driver = DriverManager.getDriver();
            redBusSearchResultPage = new RedBusSearchResultPage(driver);
            baseUtils = new BaseUtils();
        }
    @Then("user click on view seats")
    public void userClickOnViewSeatsFor() {
        redBusSearchResultPage.clickOnViewSeats(baseUtils.getjsonData("Bus"));
    }

    @And("user selected the seat")
    public void userSelectedTheSeat() {
        redBusSearchResultPage.selectSeat();
    }

    @Then("user selected the boarding point of source")
    public void userSelectedThe() {
        redBusSearchResultPage.selectBoardingPoint(baseUtils.getjsonData("Boarding Point"));
    }

    @And("user selected the dropping point of destination")
    public void userSelectedTheOfDestination() {
        redBusSearchResultPage.selectDroppingPoint(baseUtils.getjsonData("Dropping Point"));
    }

    /*
    @And("user click on continue button")
    public void userClickOnContinueButton() {
        redBusSearchResultPage.clickOnContinue();
    }
    */

    @Then("user click on Proceed To Book")
    public void userClickOnProceedToBook() {
        redBusSearchResultPage.proceedTGoBook();
    }

}

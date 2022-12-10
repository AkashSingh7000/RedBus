package PageObject;

import Utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class RedBusSearchResultPage {

    String VIEW_SEATS = "//div[text()='$value$']/ancestor::li/div/div/following-sibling::div/child::div";
    String DATE = "//label[text()='Date']/preceding-sibling::input";
    String LOWER_DECK = "//canvas[@data-type='lower']";
    String BOARDING_POINT = "//div[text()='$value$']";
    String DROPPING_POINT = "//button[text()='continue']/preceding-sibling::div/div/div/following-sibling::div/following-sibling::div/ul/li/div/following-sibling::div/following-sibling::div/div[text()='$value$']";
    String CONTINUE = "//button[text()='continue']";
    String PROCEED_TO_BOOK = "//button[text()='Proceed to book']";
    WebDriver driver;
    BaseUtils baseUtils;
    Duration duration;
    JavascriptExecutor js;

    public RedBusSearchResultPage(WebDriver driver){
       this.driver = driver;
       baseUtils = new BaseUtils();
       duration = baseUtils.getDuration();
       js = (JavascriptExecutor) driver;
    }

    public void clickOnViewSeats(String bus) {
        By loc = By.xpath(VIEW_SEATS.replace("$value$", bus));
        WebElement eleBus = baseUtils.untilVisible(driver, loc, duration);
        eleBus.click();
    }

    public void selectSeat() {
        WebElement ele = baseUtils.untilVisible(driver, By.xpath(LOWER_DECK), duration);
        js.executeScript("arguments[0].scrollIntoView(true)", ele);
        Actions act = new Actions(driver);
        act.moveToElement(ele, 5, 45).click().perform();
    }

    public void selectBoardingPoint(String boardingpoint) {
        By by = By.xpath(BOARDING_POINT.replace("$value$", boardingpoint));
        WebElement selectBoaring = baseUtils.untilVisible(driver, by, duration);
        selectBoaring.click();
    }

    public void selectDroppingPoint(String droppingpoint) {
        By by = By.xpath(DROPPING_POINT.replace("$value$", droppingpoint));
        WebElement selectDropping = baseUtils.untilVisible(driver, by, duration);
        selectDropping.click();
    }

/*
    public void clickOnContinue() {
        By by = By.xpath(CONTINUE);
        WebElement eleContinue = baseUtils.untilVisible(driver, by, duration);
        eleContinue.click();
    }
*/
    public void proceedTGoBook() {
        By by = By.xpath(PROCEED_TO_BOOK);
        WebElement eleProceedToBook = baseUtils.untilVisible(driver, by, duration);
        eleProceedToBook.click();
        baseUtils.hardWait(5000);
    }

}

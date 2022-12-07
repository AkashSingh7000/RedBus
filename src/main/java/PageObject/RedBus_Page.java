package PageObject;

import Utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class RedBus_Page {

    String SEARCH_BUSES = "//button[text()='Search Buses']";
    String FROM = "//input[@data-message = 'Please enter a source city']";
    String TO = "//input[@data-message = 'Please enter a destination city']";
    String SUGGESTED_VALUE = "//li[text()='$value$']";

    String VIEW_SEATS = "//div[text()='$value$']/ancestor::li/div/div/following-sibling::div/child::div";
    String DATE = "//label[text()='Date']/preceding-sibling::input";
    String LOWER_DECK = "//canvas[@data-type='lower']";
    WebDriver driver;
    BaseUtils baseUtils;
    Duration duration;
    JavascriptExecutor js;

    public RedBus_Page(WebDriver driver){
       this.driver = driver;
       baseUtils = new BaseUtils();
       duration = baseUtils.getDuration();
       js = (JavascriptExecutor) driver;
    }
    public void homePage() {
        driver.get(baseUtils.getURL());
        driver.manage().window().maximize();
        By byElement = By.xpath(SEARCH_BUSES);
        WebElement search = baseUtils.untilVisible(driver, byElement, duration);
        Assert.assertTrue(search.isDisplayed());
    }

    public void enterFromDetails(String from) {
        WebElement fromField = driver.findElement(By.xpath(FROM));
        fromField.sendKeys(from);
        By loc = By.xpath(SUGGESTED_VALUE.replace("$value$", from));
        WebElement suggestion = baseUtils.untilVisible(driver, loc, duration);
        js.executeScript("arguments[0].click()", suggestion);
    }

    public void enterToDetails(String to) {
        WebElement toField = driver.findElement(By.xpath(TO));
        toField.sendKeys(to);
        By loc = By.xpath(SUGGESTED_VALUE.replace("$value$", to));
        WebElement suggestion = baseUtils.untilVisible(driver, loc, duration);
        js.executeScript("arguments[0].click()", suggestion);
    }

    public void enterDate(String date) {
        WebElement dateField = driver.findElement(By.xpath(DATE));
        js.executeScript("arguments[0].value=arguments[1]", dateField, date);


    }

    public void searchBuses() {
        WebElement searchBuses = driver.findElement(By.xpath(SEARCH_BUSES));
        searchBuses.click();
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
}
package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import static Manager.DriverManager.driver;

public class BaseUtils {

    private final String configPath = "config/config.properties";
    Properties properties = new Properties();;

    public BaseUtils()
    {
        readPropertyFile();
    }

    private void readPropertyFile()
    {
        FileInputStream reader = null;
        try {
            reader = new FileInputStream(configPath);
            try {
                properties.load(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ;
    }
    public String getBrowser()
    {
        String browser = properties.getProperty("browser");
        return browser;
    }

    public String getURL()
    {
        String url = properties.getProperty("url");
        return url;
    }

    public Duration getDuration()
    {
        Duration duration = Duration.ofSeconds(Long.parseLong(properties.getProperty("duration")));
        return duration;
    }

    public WebElement untilVisible(WebDriver driver, By ob, Duration ofSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ob));
        return (driver.findElement(ob));
    }

}

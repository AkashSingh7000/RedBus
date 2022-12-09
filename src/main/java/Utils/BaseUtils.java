package Utils;

import Manager.DriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;


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
        if(browser!=null) {
            return browser;
        }
        else{
            throw new RuntimeException("browser is not specified in config.properties file");
        }
    }

    public String getURL()
    {
        String url = properties.getProperty("url");
        if(url!=null) {
            return url;
        }
        else{
            throw new RuntimeException("url is not specified in config.properties file");
        }
    }

    public Duration getDuration()
    {
        Duration duration = Duration.ofSeconds(Long.parseLong(properties.getProperty("duration")));
        if(duration!=null) {
            return duration;
        }
        else{
            throw new RuntimeException("duration is not specified in config.properties file");
        }
    }

    public WebElement untilVisible(WebDriver driver, By ob, Duration ofSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ob));
        return (driver.findElement(ob));
    }

    public void hardWait(int i) {

            try {
                WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(i));
                synchronized (wait) {
                    wait.wait(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public String getJsonFilePath()
    {
        String dataPath = properties.getProperty("jsonFilePath");
        if(dataPath!=null)
        {
            return  dataPath;
        }
        else{
            throw new RuntimeException("jsonFilePath is not specified in config.properties file");
        }

    }

    public String getjsonData(String s){
        try {
        String path = getJsonFilePath();
        JSONParser parser = new JSONParser();
        Object obj= parser.parse(new FileReader(System.getProperty("user.dir")+path));
        JSONObject jsonObject = (JSONObject) obj;
        return ((String) jsonObject.get(s));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

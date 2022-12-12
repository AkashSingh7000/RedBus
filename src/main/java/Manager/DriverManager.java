package Manager;

import Utils.BaseUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class DriverManager {

    public static WebDriver driver;
    static BaseUtils baseUtils = new BaseUtils();
    private static WebDriver createDriver()
    {
        String browser = baseUtils.getBrowser();
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions op = new ChromeOptions();
            op.setHeadless(true);
            driver = new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }
        else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxBinary f = new FirefoxBinary(new File("C:\\Users\\akumarsing017\\AppData\\Local\\Mozilla Firefox\\firefox.exe"));
            FirefoxOptions op = new FirefoxOptions();
            op.setBinary(f);
            driver = new FirefoxDriver(op);

        }

        else{
            System.out.println("Enter the valid browser name");
        }
        return driver;
    }
    public static WebDriver getDriver()
    {
        if(driver==null) {
            driver = createDriver();
            return  driver;
        }
        else {
            return driver;
        }
    }

}

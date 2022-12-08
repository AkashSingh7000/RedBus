package Manager;

import Utils.BaseUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver driver;
    static BaseUtils baseUtils = new BaseUtils();
    private static WebDriver createDriver()
    {
        String browser = baseUtils.getBrowser();
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

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

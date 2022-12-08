package StepDefinition;

import Manager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Hooks {

    WebDriver driver;

    public Hooks()
    {
        driver = DriverManager.getDriver();
    }

    @After(order = 1)
    public void capture(Scenario sc) throws IOException {
        if(sc.isFailed())
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(System.getProperty("user.dir")+"\\screenshots\\"+System.currentTimeMillis()+".png");
            FileUtils.copyFile(src, dest);

        }
    }

    @After(order = 0)
    public void afterExecutionsFinished(){
        driver.close();
    }
}

package StepDefinition;

import Manager.DriverManager;
import Utils.BaseUtils;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hooks {

    WebDriver driver;

    public Hooks()
    {
        driver = DriverManager.getDriver();
    }

    @After(order = 2)
    public void capture(Scenario sc) throws IOException {
        if(sc.isFailed())
        {
            /*
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(System.getProperty("user.dir")+"\\screenshots\\"+System.currentTimeMillis()+".png");
            FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "\\screenshots\\"));
            FileUtils.copyFile(src, dest);
            */

            // Taking Screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            sc.attach(Files.readAllBytes(src.toPath()), "image/png", "Screenshot");
        }
    }

    @After(order = 1)
    public void printDataFromDB() throws SQLException {
        ResultSet rs = BaseUtils.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getString("name") + "=" + rs.getInt("id"));
        }

        BaseUtils.closeCon();
    }
    @After(order = 0)
    public void afterExecutionsFinished(){
        driver.close();
    }
}

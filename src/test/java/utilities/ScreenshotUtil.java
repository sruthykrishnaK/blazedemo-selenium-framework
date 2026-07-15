package utilities;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String fileName) throws Exception {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File(System.getProperty("user.dir")
                + "/screenshots/" + fileName + ".png");

        FileHandler.copy(src, dest);
    }
}

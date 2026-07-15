package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class FlightsPage {

    WebDriver driver;

    By flightRows = By.xpath("//table//tr");
    By flightPrices = By.xpath("//table//tr/td[6]");

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFlightTableDisplayed() {
        return driver.findElement(By.tagName("table")).isDisplayed();
    }

    public void selectCheapestFlight(ExtentTest test) {

        List<WebElement> prices = driver.findElements(By.xpath("//table//tr/td[6]"));

        double minPrice = Double.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < prices.size(); i++) {

            String priceText = prices.get(i).getText();
            test.info("Flight price found: " + priceText);

            double price = Double.parseDouble(priceText.replace("$", ""));

            if (price < minPrice) {
                minPrice = price;
                minIndex = i;
            }
        }

        test.pass("Cheapest flight price: $" + minPrice);

        driver.findElements(By.xpath("//table//tr/td[1]/input"))
                .get(minIndex).click();
    }
}
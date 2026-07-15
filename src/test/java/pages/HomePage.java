package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;

    By fromCity = By.name("fromPort");
    By toCity = By.name("toPort");
    By findFlightsBtn = By.xpath("//input[@value='Find Flights']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromCity(String city) {
        new Select(driver.findElement(fromCity)).selectByVisibleText(city);
    }

    public void selectToCity(String city) {
        new Select(driver.findElement(toCity)).selectByVisibleText(city);
    }

    public void clickFindFlights() {
        driver.findElement(findFlightsBtn).click();
    }
}

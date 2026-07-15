package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    By successMsg = By.tagName("h1");
    By bookingId = By.xpath("//table//tr[1]/td[2]");

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public String getBookingId() {
        return driver.findElement(bookingId).getText();
    }
}

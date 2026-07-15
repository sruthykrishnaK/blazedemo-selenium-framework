package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zip = By.id("zipCode");
    By cardType = By.id("cardType");
    By cardNumber = By.id("creditCardNumber");
    By nameOnCard = By.id("nameOnCard");
    By purchaseBtn = By.xpath("//input[@value='Purchase Flight']");

    public void fillPassengerDetails(String n, String add, String c, String s, String z,
                                     String cardT, String cardNum, String nameCard) {

        driver.findElement(name).sendKeys(n);
        driver.findElement(address).sendKeys(add);
        driver.findElement(city).sendKeys(c);
        driver.findElement(state).sendKeys(s);
        driver.findElement(zip).sendKeys(z);

        new Select(driver.findElement(cardType)).selectByVisibleText(cardT);

        driver.findElement(cardNumber).sendKeys(cardNum);
        driver.findElement(nameOnCard).sendKeys(nameCard);
    }

    public void clickPurchase() {

        WebElement btn = driver.findElement(purchaseBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", btn);
    
    }
}
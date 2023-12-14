package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiTest.drivers.DriverFactory;

import java.time.Duration;


public class BasePO{
    public BasePO(){
        WebDriver driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, Duration timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
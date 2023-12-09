package uiTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uiTest.drivers.DriverFactory;

public class BasePO {
    public BasePO() {
        WebDriver driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}
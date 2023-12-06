package uiTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uiTest.drivers.DriverFactory;

import java.time.Duration;

public class BasePO {

    public BasePO() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        PageFactory.initElements(driver, this);
    }
}

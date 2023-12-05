package uiTest.pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uiTest.drivers.DriverFactory;

public class BasePO {

    public BasePO() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));

        PageFactory.initElements(driver, this);
    }
}

package uiTest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import uiTest.drivers.DriverFactory;


public class uiTestRunner extends AbstractTestNGCucumberTests {

    @AfterTest
    public void quitBrowser() {
        DriverFactory.teardown();
    }
}

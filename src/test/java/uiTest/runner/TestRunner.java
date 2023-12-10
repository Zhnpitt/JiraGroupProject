package uiTest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import uiTest.drivers.DriverFactory;


public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterTest
    public void quitBrowser() {
        System.out.println();
        DriverFactory.teardown();
    }
}

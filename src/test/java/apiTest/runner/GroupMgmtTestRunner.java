package apiTest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import uiTest.drivers.DriverFactory;


@CucumberOptions(
        features = {"src/test/resources/feature/api/groupMgmtAPI.feature"
        },
        glue = {"apiTest.stepDef"}
)
public class GroupMgmtTestRunner extends AbstractTestNGCucumberTests {

    @AfterTest
    public void quitBrowser() {
        DriverFactory.teardown();
    }
}

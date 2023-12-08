package uiTest.runner.groupMgmt;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import uiTest.drivers.DriverFactory;
import uiTest.runner.UiTestRunner;
@CucumberOptions(
        features = {"src/test/resources/feature/ui/groupMgmt.feature"
        },
        glue = {"uiTest.stepDef.groupMgmt","uiTest.stepDef.login"}
)
public class GroupMgmtUiTestRunner extends UiTestRunner {

}

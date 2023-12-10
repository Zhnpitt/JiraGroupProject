package uiTest.runner.issueMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.UiTestRunner;

@CucumberOptions(
        features = {"src/test/resources/feature/ui/developerUserIssueMgmt.feature"
        },
        glue = {"uiTest.stepDef.issueMgmt","uiTest.stepDef.login"}
)
public class IssueMgmtDeveloperUiTestRunner extends UiTestRunner {
}

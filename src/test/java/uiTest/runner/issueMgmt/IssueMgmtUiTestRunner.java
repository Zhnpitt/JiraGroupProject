package uiTest.runner.issueMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.UiTestRunner;
@CucumberOptions(
        features = {"src/test/resources/feature/ui/teamLeaderUserIssueMgmt.feature",
                "src/test/resources/feature/ui/developerUserIssueMgmt.feature"
        },
        glue = {"uiTest.stepDef.groupMgmt","uiTest.stepDef.login"}
)
public class IssueMgmtUiTestRunner extends UiTestRunner {
}

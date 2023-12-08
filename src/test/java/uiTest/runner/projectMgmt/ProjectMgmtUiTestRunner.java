package uiTest.runner.projectMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.UiTestRunner;

@CucumberOptions(
        features = {"src/test/resources/feature/ui/projectMgmt.feature"},
        glue = {"uiTest.stepDef.projectMgmt"}
)
public class ProjectMgmtUiTestRunner extends UiTestRunner {


}

//features = {"src/test/resources/feature/ui/teamLeaderUserIssueMgmt.feature",
//        "src/test/resources/feature/ui/developerUserIssueMgmt.feature"
//        },
//        glue = {"uiTest.stepDef.groupMgmt","uiTest.stepDef.login"}

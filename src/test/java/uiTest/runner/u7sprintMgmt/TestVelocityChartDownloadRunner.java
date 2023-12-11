package uiTest.runner.u7sprintMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = {"src/test/resources/feature/ui/u7sprintMgmt/velocityChartDownload.feature"
      },
      glue = {"uiTest.stepDef.sprintMgmt", "uiTest.stepDef.login"}
)
public class TestVelocityChartDownloadRunner extends TestRunner{
}
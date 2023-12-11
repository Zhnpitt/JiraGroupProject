package uiTest.runner.u5projectMgmt;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
      features = "src/test/resources/feature/ui/u5projectMgmt/applySchemeToProject.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.projectMgmt"}
)
public class TestApplySchemeToProjectRunner{
}
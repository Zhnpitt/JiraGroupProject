package apiTest.runner.a1userMgmt;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
      features = {"src/test/resources/feature/api/1userMgmt/login.feature"
      },
      glue = {"apiTest.stepDef"}
)
public class TestLoginLoginRunner extends apiTest.runner.TestLoginRunner{

}
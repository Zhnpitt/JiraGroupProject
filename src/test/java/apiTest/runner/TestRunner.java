//package apiTest.runner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.AfterTest;
//import uiTest.drivers.DriverFactory;
//
//
//@CucumberOptions(
//      features = "classpath:features",
//      glue = "classpath:stepDef"
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//
//    @AfterTest
//    public void quitBrowser() {
//        DriverFactory.teardown();
//    }
//}
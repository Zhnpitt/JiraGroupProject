package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiTest.drivers.DriverFactory;

import java.util.List;

//http://localhost:8080/secure/BrowseProjects.jspa
public class BrowseProjectsPO extends BasePO {
    @FindBy(xpath = "//div[@id=\"projects\"]/div/table/tbody")
    public WebElement projectList;


    public void clickProjectByName(String projectName) {
        String path = ".//a[text()=\"" + projectName + "\"]";
        projectList.findElement(By.xpath(path)).click();
    }

}

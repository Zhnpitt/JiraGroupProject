package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import utility.ApplicationProperties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();

    private static void createWebDriver() {

        switch (ApplicationProperties.get("driver").toLowerCase()) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");

                driverLocal.set(new ChromeDriver(options));
                break;
            }
            case "safari": {

                driverLocal.set(new SafariDriver());
                break;
            }
            default: {
                throw new IllegalArgumentException("browser type is not supported!");
            }
        }
        driverLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverLocal.get().manage().window().maximize();

//        return driver;
    }

    public static WebDriver getDriver() {
        if (driverLocal.get() == null) {
            createWebDriver();
        }
        return driverLocal.get();
    }

    public static void teardown() {
        if (driverLocal.get() != null) {
            driverLocal.get().quit();
            driverLocal.remove();
        }
    }
}

package com.demo.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.demo.Constants.DriverTypes;
import java.util.concurrent.TimeUnit;


public class BrowserUtils {

    public WebDriver driver;
    public static PropertyUtils propertyUtils;

    public WebDriver openBrowser(String browserName) {
        if(browserName.toUpperCase().equalsIgnoreCase(DriverTypes.CHROME.toString())) {
            String path = propertyUtils.getConfigProperty("chromeDriverPath");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + path);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } else {
            System.out.println("Invalid Browser!");
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver(WebDriver driver) {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

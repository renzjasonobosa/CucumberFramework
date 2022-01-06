package com.demo.StepDefinitions.Commons;

import com.demo.Utils.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TestHooks {
    public WebDriver driver;
    BrowserUtils browserUtils = new BrowserUtils();

    @Before
    public void setUp() {
        driver = browserUtils.openBrowser("CHROME");
    }

    @After
    public void tearDown() {
        browserUtils.closeDriver(driver);
    }
}

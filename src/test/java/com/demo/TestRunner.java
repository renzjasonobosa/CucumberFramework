package com.demo;
import com.demo.Utils.BrowserUtils;
import com.demo.Utils.PropertyUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },
        features = {"src/test/resources/features/VodaFone"},
        glue = {"com.demo.StepDefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}


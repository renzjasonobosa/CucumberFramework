package com.demo.StepDefinitions.Newspaper;

import com.demo.Helpers.LoginHelper;
import com.demo.StepDefinitions.Commons.TestHooks;
import com.demo.Utils.BrowserUtils;
import com.demo.Utils.PropertyUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginStepDefs extends BrowserUtils {

    public WebDriver driver;

    public LoginStepDefs(TestHooks hooks) {
        driver = hooks.driver;
    }

    @Given("^the user is in the Newspaper Homepage$")
    public void OpenNewspaperHomepage()  {
        //Open the browser and navigate to URL.
        driver.get(PropertyUtils.getProperty("URL"));
    }

    @Given("^the user clicks the Sign-in button$")
    public void clickSignInLink() {
        //Click Sign-in button.
        driver.findElement(By.id("signinlink")).click();
    }

    @Given("^the user is logged-in \"(.*)\" and \"(.*)\" to Newspapers page$")
    public void loginToNewspapers(String username, String password) {
        //Open the browser and navigate to URL.
        driver.get(PropertyUtils.getProperty("URL"));
        LoginHelper login = new LoginHelper();
        login.loginToNewspapersApplication(driver,username,password);
    }

    @When("^the user inputs \"(.*)\" and \"(.*)\"$")
    public void enterUsernameAndPassword(String username, String password) {
        //Enter Username and Password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("^the user clicks the Sign with Newspapers.com button$")
    public void clickSignInWithNewspaperButton() {
        //Click Sign-in with Newspapers.com button.
        driver.findElement(By.xpath("//button[@class='btn icon-news btn-si ncom-btn btn-primary icon-n']")).click();
    }

    @Then("^the user is redirected to Newspaper Dashboard page$")
    public void verifyUserIsInDashboardPage() {
        Boolean avatarExist = driver.findElement(By.xpath("//a[contains(@class,'avatar')]")).isDisplayed();
        Assert.assertTrue(avatarExist, "The user did not redirected to dashboard page.");
    }
}

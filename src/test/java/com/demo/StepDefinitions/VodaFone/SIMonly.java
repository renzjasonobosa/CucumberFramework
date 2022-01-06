package com.demo.StepDefinitions.VodaFone;

import com.demo.Helpers.LoginHelper;
import com.demo.StepDefinitions.Commons.TestHooks;
import com.demo.Utils.BrowserUtils;
import com.demo.Utils.PropertyUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.demo.Utils.APIUtils;

import java.io.IOException;

public class SIMonly extends BrowserUtils {

    public WebDriver driver;
    public APIUtils api = new APIUtils();
    public SIMonly(TestHooks hooks) {
        driver = hooks.driver;
    }

    @Given("^the user is in the VodafoneAustralia Sim Only Page$")
    public void openVodaFoneSimOnlyPage()  {
        //Open the browser and navigate to URL.
        driver.get(PropertyUtils.getProperty("URL"));
    }

    @When("^the user execute \"(.*)\" request$")
    public void getPlanInfoAPIRequest(String APIurl) throws IOException {
        //execute API request
        api.ExecuteGetRequest(APIurl);


    }

    @When("^the user checks the add to cart button label$")
    public void checkAddToCartButton() {
        //Check add to cart button

    }

    @Then("^the cta add to cart button in the UI matches with the ctaLabel field$")
    public void verifyAddToCartButtonLabel() {
        //Assert.assertTrue(avatarExist, "The user did not redirected to dashboard page.");
    }
}

package com.demo.StepDefinitions.VodaFone;

import com.demo.StepDefinitions.Commons.TestHooks;
import com.demo.Utils.APIUtils;
import com.demo.Utils.BrowserUtils;
import com.demo.Utils.CoreUtils;
import com.demo.Utils.PropertyUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class SIMonly extends BrowserUtils {

    public WebDriver driver;
    public APIUtils api = new APIUtils();
    public CoreUtils core = new CoreUtils();

    String getPlanInfoResponseText = "";
    String expected_ctaLabelVal = "";
    JSONObject jSONResponse = null;

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
        getPlanInfoResponseText = api.ExecuteGetRequest(APIurl);


    }

    @When("^the user checks the add to cart button label of plan (.*) in the UI$")
    public void checkAddToCartButton(String planName) throws InterruptedException {
        //WebElement of add to cart buttton of the current plan
        WebElement plan_addToCartButton = driver.findElement(By.xpath("(//div[@data-testid='plan-card-summary' and contains(text(),'" + planName + "')]/ancestor::div[contains(@id,'plan-card-')]/descendant::div[@data-testid='plan-card-actions-desktop']/button[text()='Add to cart'])[1]"));

        if(planName.equalsIgnoreCase("SIM Only Super+ Plan") || planName.equalsIgnoreCase("SIM Only Ultra+ Plan")) {
            WebElement plan_nextButton = driver.findElement(By.xpath("//div[contains(@class,'slick-arrow slick-next')]"));
            plan_nextButton.click();
            core.wait(2);
            plan_nextButton.click();
            core.wait(2);
        }

        //Get Add to cart button text.
        expected_ctaLabelVal = plan_addToCartButton.getText();
    }

    @Then("^the add to cart button text of plan (.*) in the UI matches with the ctaLabel field in the API response")
    public void verifyAddToCartButtonLabel(String planName) {
        String ctaLabel = "";

        //Convert string http response to json.
        jSONResponse = api.convertHTTPResponseToJSON(getPlanInfoResponseText);

        //Get PlanListing JSON.
        JSONObject plansListing = jSONResponse.getJSONObject("planListing");

        //Get plans JSON.
        JSONArray plans = plansListing.getJSONArray("plans");

        //Iterate to plans JSON Content.
        int n = plans.length();
        for (int i = 0; i < n; i++) {
            // Get Individual JSON object to plans JSON Array.
            JSONObject jo = plans.getJSONObject(i);

            //Get planName from API Response.
            String api_planName = jo.getString("planName");

            //Get CTA label value if the current iteration plan name from the API is the plan name under test.
            if (api_planName.equalsIgnoreCase(planName)) {
                ctaLabel = jo.getString("ctaLabel");
                break;
            }
        }

        //Verify that the Add to cart button text in the UI is equal to CTALabel field value of the plan.
        Assert.assertEquals(expected_ctaLabelVal, ctaLabel);
    }

    @When("^clicks the add to cart button of the \"(.*)\"$")
    public void clickAddToCartButton(String planName) throws InterruptedException {

        //WebElement of add to cart buttton of the curent plan
        WebElement plan_addToCartButton = driver.findElement(By.xpath("(//div[@data-testid='plan-card-summary' and contains(text(),'" + planName + "')]/ancestor::div[contains(@id,'plan-card-')]/descendant::div[@data-testid='plan-card-actions-desktop']/button[text()='Add to cart'])[1]"));

        //Click add to cart button
        core.forceClick(driver, plan_addToCartButton);
        core.wait(2);
    }

    @Then("^the \"(.*)\" shown in the sticky cart is the same as the selected \"(.*)\"$")
    public void verifyPriceInStickyCart(String price, String planName) {
        //WebElement of the sticky cart price text.
        WebElement stickyCartPrice = driver.findElement(By.xpath("//text[@data-testid='sticky-cart-cost']/strong"));

        //Get the price of the sticky cart text.
        String stickyCartPriceText = stickyCartPrice.getText();

        Boolean verifyStickyCartPrice = false;

        //Set boolean to true if the sticky cart text is equal to the expected plan price
        if (stickyCartPriceText.contains(price)) {
            verifyStickyCartPrice = true;
        }

        //Assertion
        Assert.assertTrue(verifyStickyCartPrice, "the price shown in the sticky cart was not the same as he selected plan price.");
    }

    @When("^the user clicks the continue to cart button in the sticky cart$")
    public void clickConinueToCartButton() throws InterruptedException {

        //WebElement of Continue to cart buttton.
        WebElement plan_contToCartButton = driver.findElement(By.xpath("//text[text()='Continue to cart']/parent::button"));

        //Click Continue to cart button
        core.forceClick(driver, plan_contToCartButton);
        core.wait(5);
    }

    @Then("^the user should be redirected to cart page$")
    public void verifyUserIsOnCartPage() {
        //WebElement of Continue to cart buttton.
        WebElement cartHeader = driver.findElement(By.xpath("//h1[@data-testid='cart-summary-title']"));

        //Verify that the user is redirected to cart page.
        Assert.assertTrue(cartHeader.isDisplayed(), "The user was not redirected to cart page");
    }

    @Then("^the added product should be (.*) with the price of (.*)$")
    public void verifyCartProductDetails(String planName, String price) {
        //WebElement of Cart Record Title.
        WebElement cartRecordTitle = driver.findElement(By.xpath("//h4[contains(@data-testid,'cart-card-title')]/descendant::div[contains(@class,'RichText')]"));

        //WebElement of Cart Record Price.
        WebElement cartRecordPrice = driver.findElement(By.xpath("//div[@data-testid='display-price']"));

        //Get the value of Cart record title element.
        String cartRecordTitleText = cartRecordTitle.getText();

        //Get the value of Cart record price element.
        String cartRecordPriceText = cartRecordPrice.getText();

        Boolean verifyCartRecordTitle = false;
        Boolean verifyCartRecordPrice = false;

        //Set boolean to true if the product name is correct.
        if (cartRecordTitleText.contains(planName)) {
            verifyCartRecordTitle = true;
        }

        //Set boolean to true if the product price is correct.
        if (cartRecordPriceText.contains(price)) {
            verifyCartRecordPrice = true;
        }

        //Assertion for Cart Record Title.
        Assert.assertTrue(verifyCartRecordTitle, "The product name was not equal to added plan.");

        //Assertion for Cart Record Price.
        Assert.assertTrue(verifyCartRecordPrice, "The product price was not equal to added plan price.");
    }
}

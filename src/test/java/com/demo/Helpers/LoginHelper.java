package com.demo.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper {
    public void loginToNewspapersApplication(WebDriver driver, String username, String password) {
        //Click Sign-in button.
        driver.findElement(By.id("signinlink")).click();

        //Enter Username and Password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        //Click Sign-in with Newspapers.com button.
        driver.findElement(By.xpath("//button[@class='btn icon-news btn-si ncom-btn btn-primary icon-n']")).click();
    }
}

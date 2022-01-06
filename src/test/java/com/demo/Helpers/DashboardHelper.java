package com.demo.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardHelper {
    public void navigateToEditProfilePage(WebDriver driver) {
        //Click User's Avatar.
        driver.findElement(By.xpath("//a[contains(@class,'avatar')]")).click();

        //Click Account Details option.
        driver.findElement(By.xpath("//div[@id='member-info']/a[@href='https://www.newspapers.com/account/']")).click();

        //Click Edit Profile Nav Link.
        driver.findElement(By.xpath("//a[@class='nav-link' and text()='Edit Profile']")).click();
    }

    public void navigateToAccountInfoPage(WebDriver driver) {
        //Click User's Avatar.
        driver.findElement(By.xpath("//a[contains(@class,'avatar')]")).click();

        //Click Account Details option.
        driver.findElement(By.xpath("//div[@id='member-info']/a[@href='https://www.newspapers.com/account/']")).click();

        //Click Account Info Nav Link.
        driver.findElement(By.xpath("//a[@class='nav-link' and text()='Account Info']")).click();
    }
}

package com.demo.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoreUtils {

    public void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

}


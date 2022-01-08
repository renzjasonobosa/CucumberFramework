package com.demo.Utils;

import org.openqa.selenium.*;

public class CoreUtils {

    public void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
    public void forceClick(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

}


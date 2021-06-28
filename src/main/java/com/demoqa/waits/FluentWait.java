package com.demoqa.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FluentWait {
    public static void main(String[] args) {
        String url ="https://www.demoqa.com/dynamic-properties";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).
                pollingEvery(200,TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

        driver.get(url);
        driver.manage().window().maximize();

        try{
            WebElement button = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id("visibleAfter"));
                }
            });
                    driver.findElement(By.id("visibleAfter"));
            button.click();
            System.out.println("Button clicked with fluent wait!!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

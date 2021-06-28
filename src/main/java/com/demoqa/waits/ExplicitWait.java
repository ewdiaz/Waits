package com.demoqa.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    public static void main(String[] args) {
        String url ="https://www.demoqa.com/dynamic-properties";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get(url);
        driver.manage().window().maximize();

        try{
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("visibleAfter")));
            WebElement button = driver.findElement(By.id("visibleAfter"));
            button.click();
            System.out.println("Button clicked with explicit wait!!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

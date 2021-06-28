package com.demoqa.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    public static void main(String[] args) {
        String url ="https://demoqa.com/droppable";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        try{
            WebElement button = driver.findElement(By.id("visibleAfter"));
            button.click();
            System.out.println("Button clicked with implicit wait!!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

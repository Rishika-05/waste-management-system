package com.se.wastemanagementsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    @Test
    public void login_test() throws InterruptedException {
        ChromeOptions co =new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/login");
        driver.findElement(By.className("phone")).sendKeys("7004478436" , Keys.ENTER);
        driver.findElement(By.className("password")).sendKeys("password" , Keys.ENTER);
        driver.findElement(By.className("login-btn")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(10000);
        driver.quit();
    }
}

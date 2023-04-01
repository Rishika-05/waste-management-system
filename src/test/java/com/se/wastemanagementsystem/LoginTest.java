package com.se.wastemanagementsystem;

import org.junit.FixMethodOrder;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.*;
import java.awt.event.KeyEvent;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

    public void zoom_out(WebDriver driver) throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    @Test
    public void test1_register() throws InterruptedException, AWTException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/register");
        zoom_out(driver);
        driver.findElement(By.className("phone")).sendKeys("70044784362", Keys.ENTER);
        driver.findElement(By.className("password")).sendKeys("password", Keys.ENTER);
        driver.findElement(By.className("rpassword")).sendKeys("password", Keys.ENTER);
        driver.findElement(By.className("name")).sendKeys("Rohit", Keys.ENTER);
        driver.findElement(By.className("role")).click();
        driver.findElement(By.className("wc")).click();
        driver.findElement(By.className("register-btn")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
    }

//    @Test
//    public void test2_logout() throws InterruptedException, AWTException {
//        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--remote-allow-origins=*");
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver(co);
//        driver.manage().window().maximize();
//        driver.get("http://localhost:3000");
//        zoom_out(driver);
//        driver.findElement(By.className("dropdown-toggle")).click();
//        driver.findElement(By.className("logout-btn")).click();
//        System.out.println(driver.getTitle());
//        Thread.sleep(10000);
//    }

    @Test
    public void test3_login() throws InterruptedException, AWTException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/login");
        zoom_out(driver);
        driver.findElement(By.className("phone")).sendKeys("70044784362", Keys.ENTER);
        driver.findElement(By.className("password")).sendKeys("password", Keys.ENTER);
        driver.findElement(By.className("login-btn")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }
}

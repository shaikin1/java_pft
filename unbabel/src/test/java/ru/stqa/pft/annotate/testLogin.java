package ru.stqa.pft.annotate;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class testLogin {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void Login() {
        wd.get("https://staging.annotation.tools.unbabel.com/");
        wd.findElement(By.xpath("//div[@class='svg-wrapper']/img")).click();
        wd.findElement(By.linkText("Sign In")).click();
        wd.findElement(By.id("username")).click();
        wd.findElement(By.id("username")).sendKeys("emanuel+annotator1@unbabel.com");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).sendKeys("GHF66sznaw%23ref34Q");
        wd.findElement(By.xpath("//form[@class='form-signin']//button[.='Sign in']")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}

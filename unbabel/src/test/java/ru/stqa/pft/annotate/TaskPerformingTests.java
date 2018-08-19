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

public class TaskPerformingTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testTaskPerforming() {
    wd.get("https://staging.annotation.tools.unbabel.com/");
    wd.findElement(By.xpath("//div[@class='svg-wrapper']/img")).click();
    wd.findElement(By.linkText("Sign In")).click();
    wd.findElement(By.id("username")).click();
    wd.findElement(By.id("username")).sendKeys("emanuel+annotator1@unbabel.com");
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).sendKeys("GHF66sznaw%23ref34Q");
    wd.findElement(By.xpath("//form[@class='form-signin']//button[.='Sign in']")).click();
    wd.findElement(By.linkText("EN to RU")).click();
    wd.switchTo().activeElement().findElement(By.cssSelector("span.c-TopBar__circle.is-untouched")).click();
    wd.switchTo().activeElement().findElement(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Annotations']")).click();
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@class='c-AnnotateApp__content']/div[1]/div[4]/div[2]/div[2]/div[1]/p"))).build().perform();
    wd.switchTo().activeElement().findElement(By.id("searchErrorTypes")).clear();
    wd.switchTo().activeElement().findElement(By.id("searchErrorTypes")).sendKeys("Addition");
    wd.switchTo().activeElement().findElement(By.xpath("//ol[@class='c-MarkError__subList']//span[.='Addition']")).click();
    wd.switchTo().activeElement().findElement(By.id("minorSeverity")).click();
    wd.switchTo().activeElement().findElement(By.cssSelector("button.c-Button.c-Button--cta")).click();
    wd.switchTo().activeElement().findElement(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Propose Glossary Terms']")).click();
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@class='c-AnnotateApp__content']/div[1]/div[4]/div[1]/div[2]/div[1]/p"))).build().perform();
    wd.switchTo().activeElement().findElement(By.name("proposedTranslation")).click();
    wd.findElement(By.name("proposedTranslation")).clear();
    wd.findElement(By.name("proposedTranslation")).sendKeys("о которой");
    wd.switchTo().activeElement().findElement(By.xpath("//div[@class='c-MarkGTM__buttons']//button[.='Add']")).click();
    wd.switchTo().activeElement().findElement(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Finish or Report']")).click();
    wd.findElement(By.xpath("(//div[@class='c-StarGroup']/*[@class='c-StarGroup__star'])[5]")).click();
    wd.switchTo().activeElement().findElement(By.xpath("//div[@class='c-TaskFeedback__finish']//button[.='Finish']")).click();
    wd.switchTo().activeElement().findElement(By.xpath("//div[@id='js-modal-footer']//button[.='Yes']")).click();
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

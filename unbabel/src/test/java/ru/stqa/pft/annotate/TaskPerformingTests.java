package ru.stqa.pft.annotate;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class TaskPerformingTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    login("emanuel+annotator1@unbabel.com", "GHF66sznaw%23ref34Q");

  }

  private void login(String username, String password) {
    wd.get("https://staging.annotation.tools.unbabel.com/");
    wd.findElement(By.linkText("Sign In")).click();
    wd.findElement(By.id("username")).click();
    wd.findElement(By.id("username")).clear();
    wd.findElement(By.id("username")).sendKeys(username);
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys(password);
    wd.findElement(By.xpath("//form[@class='form-signin']//button[.='Sign in']")).click();
  }

  @Test
  public void testTaskPerforming() {
    gotoInterface();
    initTask();
    selectionRussianText();
    chooseErrorType();
    chooseSeverity();
    submitAnnotate();
    gotoProposeGlossaryTerms();
    selectionEnglishText();
    fillProposedTranslationField();
    submitProposeGlossaryTerms();
    gotoFinishOrReport();
    chooseTaskFluency();
    sumbitFinishOrReport();
    acceptFinishingJob();
  }

  private void acceptFinishingJob() {
    wd.findElement(By.xpath("//div[@id='js-modal-footer']//button[.='No']")).click();
  }

  private void sumbitFinishOrReport() {
    wd.findElement(By.xpath("//div[@class='c-TaskFeedback__finish']//button[.='Finish']")).click();
  }

  private void chooseTaskFluency() {
    wd.findElement(By.xpath("(//div[@class='c-StarGroup']/*[@class='c-StarGroup__star'])[5]")).click();
  }

  private void gotoFinishOrReport() {
    wd.findElement(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Finish or Report']")).click();
  }

  private void submitProposeGlossaryTerms() {
    wd.findElement(By.xpath("//div[@class='c-MarkGTM__buttons']//button[.='Add']")).click();
  }

  private void fillProposedTranslationField() {
    wd.findElement(By.name("proposedTranslation")).click();
    wd.findElement(By.name("proposedTranslation")).clear();
    wd.findElement(By.name("proposedTranslation")).sendKeys("о которой");
  }

  private void selectionEnglishText() {
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@class='c-AnnotateApp__content']/div[1]/div[5]/div[1]/div[2]/div[1]/p"))).build().perform();
  }

  private void gotoProposeGlossaryTerms() {
    wd.findElement(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Propose Glossary Terms']")).click();
  }

  private void submitAnnotate() {
    wd.findElement(By.cssSelector("button.c-Button.c-Button--cta")).click();
  }

  private void chooseSeverity() {
    wd.findElement(By.id("minorSeverity")).click();
  }

  private void chooseErrorType() {
    wd.findElement(By.xpath("//div[@class='c-MarkError__errorType']/span[.='Accuracy']")).click();
    wd.findElement(By.xpath("//ol[@class='c-MarkError__subList']//span[.='Addition']")).click();
  }

  private void selectionRussianText() {
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@class='c-AnnotateApp__content']/div[1]/div[5]/div[2]/div[2]/div[1]/p"))).build().perform();
  }

  private void initTask() {
    wd.switchTo().activeElement().findElement(By.xpath("//div[@class='c-TopBar__navWrapper']/div[2]")).click();
  }

  private void gotoInterface() {
    wd.findElement(By.linkText("EN to RU")).click();
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

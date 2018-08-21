package ru.stqa.pft.annotate.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import ru.stqa.pft.annotate.model.ProposeData;

public class TaskHelper {
  private FirefoxDriver wd;

  public TaskHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void acceptFinishingJob() {
    wd.findElement(By.xpath("//div[@id='js-modal-footer']//button[.='No']")).click();
  }

  public void submitFinishOrReport() {
    wd.findElement(By.xpath("//div[@class='c-TaskFeedback__finish']//button[.='Finish']")).click();
  }

  public void chooseTaskFluency() {
    wd.findElement(By.xpath("(//div[@class='c-StarGroup']/*[@class='c-StarGroup__star'])[5]")).click();
  }

  public void gotoFinishOrReport() {
    wd.findElement(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Finish or Report']")).click();
  }

  public void submitProposeGlossaryTerms() {
    wd.findElement(By.xpath("//div[@class='c-MarkGTM__buttons']//button[.='Add']")).click();
  }

  public void fillProposedTranslationField(ProposeData proposeData) {
    wd.findElement(By.name("proposedTranslation")).click();
    wd.findElement(By.name("proposedTranslation")).clear();
    wd.findElement(By.name("proposedTranslation")).sendKeys(proposeData.getText());
  }

  public void selectionEnglishText() {
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@class='c-AnnotateApp__content']/div[1]/div[2]/div[1]/div[2]/div[1]/p"))).build().perform();
  }

  public void gotoProposeGlossaryTerms() {
    wd.findElement(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Propose Glossary Terms']")).click();
  }

  public void submitAnnotate() {
    wd.findElement(By.cssSelector("button.c-Button.c-Button--cta")).click();
  }

  public void chooseSeverity() {
    wd.findElement(By.id("minorSeverity")).click();
  }

  public void chooseErrorType() {
    wd.findElement(By.xpath("//div[@class='c-MarkError__errorType']/span[.='Accuracy']")).click();
    wd.findElement(By.xpath("//ol[@class='c-MarkError__subList']//span[.='Addition']")).click();
  }

  public void selectionRussianText() {
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@class='c-AnnotateApp__content']/div[1]/div[2]/div[2]/div[2]/div[1]/p"))).build().perform();
  }

  public void initTask() {
    wd.switchTo().activeElement().findElement(By.xpath("//div[@class='c-TopBar__navWrapper']/div[2]")).click();
  }
}

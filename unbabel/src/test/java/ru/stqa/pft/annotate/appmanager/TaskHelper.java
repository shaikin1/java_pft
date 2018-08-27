package ru.stqa.pft.annotate.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import ru.stqa.pft.annotate.model.ProposeData;

public class TaskHelper extends HelperBase {

  public TaskHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void acceptFinishingJob() {
    click(By.xpath("//div[@id='js-modal-footer']//button[.='No']"));
  }

  public void submitFinishOrReport() {
    click(By.xpath("//div[@class='c-TaskFeedback__finish']//button[.='Finish']"));
  }

  public void chooseTaskFluency() {
    click(By.xpath("(//div[@class='c-StarGroup']/*[@class='c-StarGroup__star'])[5]"));
  }

  public void gotoFinishOrReport() {
    click(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Finish or Report']"));
  }

  public void submitProposeGlossaryTerms() {
    click(By.xpath("//div[@class='c-MarkGTM__buttons']//button[.='Add']"));
  }

  public void fillProposedTranslationField(ProposeData proposeData) {
    type(By.name("proposedTranslation"), proposeData.getText());
  }

  public void selectionEnglishText() {
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@class='c-AnnotateApp__content']/div[1]/div[2]/div[1]/div[2]/div[1]/p"))).build().perform();
  }

  public void gotoProposeGlossaryTerms() {
    click(By.xpath("//div[@class='c-AnnotateApp']//div[normalize-space(.)='-+ Propose Glossary Terms']"));
  }

  public void submitAnnotate() {
    click(By.cssSelector("button.c-Button.c-Button--cta"));
  }

  public void chooseSeverity() {
    click(By.id("minorSeverity"));
  }

  public void chooseErrorType() {
    click(By.xpath("//div[@class='c-MarkError__errorType']/span[.='Accuracy']"));
    click(By.xpath("//ol[@class='c-MarkError__subList']//span[.='Addition']"));
  }

  public void selectionRussianText() {
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@class='c-AnnotateApp__content']/div[1]/div[2]/div[2]/div[2]/div[1]/p"))).build().perform();
  }

  public void initTask() {
    wd.switchTo().activeElement().findElement(By.xpath("//div[@class='c-TopBar__navWrapper']/div[2]")).click();
  }

  public void fillTaskComment() {
    click(By.xpath("//textarea[@class='c-TaskFeedback__comment']"));

  }
}

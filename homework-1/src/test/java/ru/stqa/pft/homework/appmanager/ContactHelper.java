package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.homework.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToContactPage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("home"), contactData.getHome());
    type(By.name("email"), contactData.getEmail());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void acceptDeletionContact() {
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));
    }
  }
}

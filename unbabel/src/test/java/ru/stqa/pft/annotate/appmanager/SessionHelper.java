package ru.stqa.pft.annotate.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    click(By.linkText("Sign In"));
    type(By.id("username"), username);
    type(By.id("password"), password);
    click(By.xpath("//form[@class='form-signin']//button[.='Sign in']"));
  }


}

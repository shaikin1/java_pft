package ru.stqa.pft.annotate.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoInterface() {
    click(By.linkText("EN to RU"));
  }
}

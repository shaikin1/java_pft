package ru.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
  private FirefoxDriver wd;
  protected ContactHelper contactHelper;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoContactPage() {
    contactHelper.returnToContactPage();
  }
}

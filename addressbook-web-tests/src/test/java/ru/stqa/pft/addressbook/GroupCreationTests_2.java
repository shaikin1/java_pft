package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTests_2 extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupGreation();
    fillGroupForm(new GroupData("test4", "test5", "test6"));
    submitGroupCreation();
    returnToGroupPage();
  }

}

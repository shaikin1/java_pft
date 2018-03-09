package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class CroupDeletionTests extends TestBase {

  @Test
  public void testCroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}


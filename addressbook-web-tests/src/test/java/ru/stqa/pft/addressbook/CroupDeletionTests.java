package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class CroupDeletionTests extends TestBase {

  @Test
  public void testCroupDeletion() {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}


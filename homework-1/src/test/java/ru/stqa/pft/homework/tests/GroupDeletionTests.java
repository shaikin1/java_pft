package ru.stqa.pft.homework.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test

  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectAnyGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().gotoGroupPage();
  }
}

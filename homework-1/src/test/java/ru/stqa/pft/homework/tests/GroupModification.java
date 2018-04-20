package ru.stqa.pft.homework.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

public class GroupModification extends TestBase {

  @Test

  public void testGroupModification() {
    app.getGroupHelper().gotoGroupPage();
    app.getGroupHelper().selectAnyGroup();
    app.getGroupHelper().editSelectedGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("test4", "test5", "test6"));
    app.getGroupHelper().updateGroupEdition();
    app.getGroupHelper().returnToGroupPage();
  }
}

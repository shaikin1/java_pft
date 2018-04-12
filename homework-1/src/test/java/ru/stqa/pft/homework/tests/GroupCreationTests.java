package ru.stqa.pft.homework.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test

  public void testGroupCreation() {
    app.getGroupHelper().gotoGroupPage();
    app.getGroupHelper().addNewGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("test", "test1", "test2"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
}

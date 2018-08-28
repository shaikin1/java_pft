package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void addNewGroup() {
    click(By.name("new"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
  }

  public void selectAnyGroupById(int id) {
    wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
  }

  public void deleteSelectedGroup() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void editSelectedGroup() {
    click(By.name("edit"));
  }

  public void updateGroupEdition() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    addNewGroup();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();

  }

  public void modify(GroupData group) {
    selectAnyGroupById(group.getId());
    editSelectedGroup();
    fillGroupForm(group);
    updateGroupEdition();
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectAnyGroupById(group.getId());
    deleteSelectedGroup();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Groups all() {
    Groups groups = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }

}

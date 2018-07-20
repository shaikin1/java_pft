package ru.stqa.pft.homework.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Sergei", "Shaikin", "Engineer", "Google", "+79876391174", "shaikins@yahoo.com", "test4"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
  }

}

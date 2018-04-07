package ru.tests;

import org.testng.annotations.Test;
import ru.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().initContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Sergei", "Shaikin", "Engineer", "Google", "+79876391174", "shaikins@yahoo.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
  }

}

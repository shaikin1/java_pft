package ru.stqa.pft.homework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Sergei", "Shaikin", "Engineer", "Google", "+79876391174", "shaikins@yahoo.com", "test1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Liliia", "Shaikina", "Designer", "Skype", "+79876391173", "shaikinal@yahoo.com", null), false);
    app.getContactHelper().updateContactModification();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }

}

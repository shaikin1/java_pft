package ru.stqa.pft.homework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Sergei", "Shaikin", "Engineer", "Google", "+79876391174", "shaikins@yahoo.com", "test1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptDeletionContact();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }

}

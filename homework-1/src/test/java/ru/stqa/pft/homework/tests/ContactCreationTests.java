package ru.stqa.pft.homework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().gotoHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Sergei").withLastname("Shaikin").withTitle("Engineer").withCompany("Google").withHome("+79876391174").withEmail("shaikins@yahoo.com").withGroup("test1");
    app.contact().create(contact, true);
    app.contact().returnToContactPage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);


    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }

}

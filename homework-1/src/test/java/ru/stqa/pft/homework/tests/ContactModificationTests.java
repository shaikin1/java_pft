package ru.stqa.pft.homework.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;
import ru.stqa.pft.homework.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Sergei").withLastname("Shaikin").withTitle("Engineer").withCompany("Google").withHome("+79876391174").withEmail("shaikins@yahoo.com").withGroup("test1"), true);
    }
  }

  @Test(enabled = true)
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Sergei").withLastname("Shaikin").withTitle("Engineer").withCompany("Google").withHome("+79876391174").withEmail("shaikins@yahoo.com");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    before.remove(modifiedContact);
    before.add(contact);
    assertEquals(before, after);
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}

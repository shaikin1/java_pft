package ru.stqa.pft.homework.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;
import ru.stqa.pft.homework.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().gotoHomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Liliia").withLastname("Shaikina").withTitle("Designer").withCompany("Apple").withHome("+79876391173").withEmail("shaikinal@yahoo.com").withGroup("test2");
    app.contact().create(contact, true);
    app.contact().returnToContactPage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() + 1);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}

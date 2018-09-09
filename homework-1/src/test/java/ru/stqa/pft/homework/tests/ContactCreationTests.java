package ru.stqa.pft.homework.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;
import ru.stqa.pft.homework.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().gotoHomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Sergei").withLastname("Shaikin").withTitle("Engineer").withCompany("Google").withHome("+79876391174").withEmail("shaikins@yahoo.com").withGroup("test1");
    app.contact().create(contact, true);
    app.contact().returnToContactPage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() + 1);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}

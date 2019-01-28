package ru.stqa.pft.homework.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;
import ru.stqa.pft.homework.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstname("firstname1").withLastname("lastname 1").withTitle("title 1").withCompany("company 1").withHome("home 1").withAddress("address 1").withEmail("email 1").withGroup("test 1")});
    list.add(new Object[] {new ContactData().withFirstname("firstname2").withLastname("lastname 2").withTitle("title 2").withCompany("company 2").withHome("home 2").withAddress("address 2").withEmail("email 2").withGroup("test 2")});
    list.add(new Object[] {new ContactData().withFirstname("firstname3").withLastname("lastname 3").withTitle("title 3").withCompany("company 3").withHome("home 3").withAddress("address 3").withEmail("email 3").withGroup("test 3")});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().gotoHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    app.contact().create(contact, true);
    app.contact().returnToContactPage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() + 1);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}

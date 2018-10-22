package ru.stqa.pft.homework.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Sergei").withLastname("Shaikin").withAddress("Lanskoye Shosse 6, 106, Saint Petersburg").withTitle("Engineer").withCompany("Google").withHome("+79876391174").withMobilePhone("8(927)8161161").withWorkPhone("8 842 35 7 51 34").withEmail("shaikins@yahoo.com").withEmail2("q@qa.team").withEmail3("a@gmail.com").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactAddress() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

  }

}

package ru.stqa.pft.homework.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.selectContact();
    app.deleteSelectedContact();
    app.acceptDeletionContact();
  }

}

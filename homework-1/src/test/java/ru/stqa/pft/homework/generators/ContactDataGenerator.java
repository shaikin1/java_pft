package ru.stqa.pft.homework.generators;

import ru.stqa.pft.homework.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname(), contact.getTitle(), contact.getCompany(), contact.getHome(),
                    contact.getAddress(), contact.getHomePhone(), contact.getEmail(), contact.getGroup()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("Tom %s", i)).withLastname(String.format("Bo %s", i)).withTitle(String.format("Boss %s", i))
                    .withCompany(String.format("Apple %s", i)).withHome(String.format("+7-987-639-11-7%s", i)).withAddress(String.format("Wall Street %s", i)).withHomePhone(String.format("7-51-3%s", i))
                    .withEmail(String.format("shaikin%s@yahoo.com", i)).withGroup(String.format("test %s", i)));
        }
        return contacts;
    }
}

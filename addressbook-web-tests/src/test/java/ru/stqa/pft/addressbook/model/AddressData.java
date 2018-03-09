package ru.stqa.pft.addressbook.model;

public class AddressData {
  private final String street;
  private final String street_city;
  private final String street_city_country;

  public AddressData(String street, String street_city, String street_city_country) {
    this.street = street;
    this.street_city = street_city;
    this.street_city_country = street_city_country;
  }

  public String getStreet() {
    return street;
  }

  public String getStreet_city() {
    return street_city;
  }

  public String getStreet_city_country() {
    return street_city_country;
  }
}

package com.example.springbooteventmanaging.models;

public class Organizer {
    private int Org_id;
    private String NameOrganizer;
    private String Address;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private int PostalCode;
    private String Phone;
    private String Fax;
    private String Url;

    public Organizer(String NameOrganizer, String Address, String City, int PostalCode, String Url)
    {
        this.NameOrganizer  = NameOrganizer;
        this.Address        = Address;
        this.PostalCode     = PostalCode;
        this.Url = Url;
        this.city = City;
    }

    public void AddContactData(String phone, String fax)
    {

        this.Phone = phone;
        this.Fax = fax;
    }
    /**
     *  o = new Organizer
     *  o.AddContactData("07031/603086","07030/606060")
     */
    public String getNameOrganizer() {
        return NameOrganizer;
    }

    public void setNameOrganizer(String nameOrganizer) {
        NameOrganizer = nameOrganizer;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(int postalCode) {
        PostalCode = postalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }


}

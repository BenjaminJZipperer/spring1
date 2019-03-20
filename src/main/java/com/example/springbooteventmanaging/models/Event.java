package com.example.springbooteventmanaging.models;

import java.util.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class Event {
    private int Id;
    private String EventDescription;
    private double Price;
    private String Location;
    private Date   ScheduleDate;
    private Organizer Provider;

    @Override
    public String toString() {
        return "   Event{" +
                "  Event-Beschreibung='" + EventDescription + '\'' +
                ", Preis=" + Price +
                ", Veranstaltungsort='" + Location + '\'' +
                ", Datum=" + ScheduleDate +
                ", Veranstalter='" + Provider.getNameOrganizer() +
                "'}";
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Date getScheduleDate() {
        return ScheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        ScheduleDate = scheduleDate;
    }

    public Organizer getProvider() {
        return Provider;
    }

    public void setProvider(Organizer provider) {
        Provider = provider;
    }
}

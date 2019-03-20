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

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String EventDescription;
    private BigDecimal Price;
    private String Location;

    @CreationTimestamp
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

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
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

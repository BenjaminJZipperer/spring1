package com.example.springbooteventmanaging.models;

import java.util.*;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
@Table(name = "events") // schema: klein,mehrzahl
public class Event implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotNull
    @Size(max = 185)
    @Column(name = "description")
    private String EventDescription;

    @NotNull
    @Column(name = "price")
    private BigDecimal Price;

    @NotNull
    @Size(max = 80)
    @Column(name = "location")
    private String Location;

    @CreationTimestamp
    private Date   ScheduleDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ORGANIZER_ID")
    private Organizer Provider;


    public Event(){}

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

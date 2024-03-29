package com.epam.training.dataaccess.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "room", schema = "", catalog = "hrs")
public class RoomEntity {
    private int id;
    private int cost;
    private int number;
    private Collection<BookingEntity> bookingsById;
    private SuiteEntity suiteBySuiteId;
    private BedEntity bedByBedId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomEntity)) return false;

        RoomEntity that = (RoomEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<BookingEntity> getBookingsById() {
        return bookingsById;
    }

    public void setBookingsById(Collection<BookingEntity> bookingsById) {
        this.bookingsById = bookingsById;
    }

    @ManyToOne
    @JoinColumn(name = "suite_id", referencedColumnName = "id", nullable = false)
    public SuiteEntity getSuiteBySuiteId() {
        return suiteBySuiteId;
    }

    public void setSuiteBySuiteId(SuiteEntity suiteBySuiteId) {
        this.suiteBySuiteId = suiteBySuiteId;
    }

    @ManyToOne
    @JoinColumn(name = "bed_id", referencedColumnName = "id", nullable = false)
    public BedEntity getBedByBedId() {
        return bedByBedId;
    }

    public void setBedByBedId(BedEntity bedByBedId) {
        this.bedByBedId = bedByBedId;
    }
}

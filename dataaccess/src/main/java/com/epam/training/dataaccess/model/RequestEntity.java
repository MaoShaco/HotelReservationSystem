package com.epam.training.dataaccess.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "request", schema = "", catalog = "hrs")
public class RequestEntity {
    private int id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private BookingEntity bookingsById;
    private SuiteEntity suiteBySuiteId;
    private ClientEntity clientByClientId;
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
    @Column(name = "check_in")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "check_out")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestEntity)) return false;

        RequestEntity that = (RequestEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToOne(mappedBy = "requestByRequestId")
    public BookingEntity getBookingsById() {
        return bookingsById;
    }

    public void setBookingsById(BookingEntity bookingsById) {
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
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
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

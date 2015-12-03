package com.epam.training.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "request", schema = "", catalog = "example")
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
        if (o == null || getClass() != o.getClass()) return false;

        RequestEntity that = (RequestEntity) o;

        if (id != that.id) return false;
        if (checkIn != null ? !checkIn.equals(that.checkIn) : that.checkIn != null) return false;
        if (checkOut != null ? !checkOut.equals(that.checkOut) : that.checkOut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
        result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
        return result;
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

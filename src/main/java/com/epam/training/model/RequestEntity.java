package com.epam.training.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "request", schema = "", catalog = "example")
public class RequestEntity {
    private int id;
    private Date checkIn;
    private Date checkOut;
    private ClientEntity clientByClientEntityId;
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
    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "check_out")
    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
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

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByClientEntityId() {
        return clientByClientEntityId;
    }

    public void setClientByClientEntityId(ClientEntity clientByClientEntityId) {
        this.clientByClientEntityId = clientByClientEntityId;
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

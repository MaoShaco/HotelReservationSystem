package com.epam.training.model;

import javax.persistence.*;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "room", schema = "", catalog = "example")
public class RoomEntity {
    private int id;
    private int cost;
    private int number;
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
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (id != that.id) return false;
        if (cost != that.cost) return false;
        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cost;
        result = 31 * result + number;
        return result;
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
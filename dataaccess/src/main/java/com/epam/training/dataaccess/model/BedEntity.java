package com.epam.training.dataaccess.model;

import javax.persistence.*;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "bed", schema = "", catalog = "hrs")
public class BedEntity {
    private int id;
    private String bed;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bed")
    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BedEntity)) return false;

        BedEntity bedEntity = (BedEntity) o;

        return id == bedEntity.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}

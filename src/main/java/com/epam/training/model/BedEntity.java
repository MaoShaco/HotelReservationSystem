package com.epam.training.model;

import javax.persistence.*;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "bed", schema = "", catalog = "example")
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
        if (o == null || getClass() != o.getClass()) return false;

        BedEntity bedEntity = (BedEntity) o;

        if (id != bedEntity.id) return false;
        if (bed != null ? !bed.equals(bedEntity.bed) : bedEntity.bed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bed != null ? bed.hashCode() : 0);
        return result;
    }
}

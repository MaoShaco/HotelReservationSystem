package com.epam.training.dataaccess.model;

import javax.persistence.*;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "suite", schema = "", catalog = "hrs")
public class SuiteEntity {
    private int id;
    private String suite;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "suite")
    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuiteEntity)) return false;

        SuiteEntity that = (SuiteEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}

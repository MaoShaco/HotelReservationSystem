package com.epam.training.model;

import javax.persistence.*;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "suite", schema = "", catalog = "example")
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
        if (o == null || getClass() != o.getClass()) return false;

        SuiteEntity that = (SuiteEntity) o;

        if (id != that.id) return false;
        if (suite != null ? !suite.equals(that.suite) : that.suite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (suite != null ? suite.hashCode() : 0);
        return result;
    }
}

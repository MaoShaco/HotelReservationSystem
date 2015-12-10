package com.epam.training.dataaccess.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "client", schema = "", catalog = "example")
public class ClientEntity {
    private int id;
    private String name;
    private String password;
    private String email;
    private String cardNumber;
    private Collection<RequestEntity> requestsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientEntity)) return false;

        ClientEntity that = (ClientEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<RequestEntity> getRequestsById() {
        return requestsById;
    }

    public void setRequestsById(Collection<RequestEntity> requestsById) {
        this.requestsById = requestsById;
    }
}

package com.epam.training.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=30)
    @Column(name = "name", unique=true, nullable = false)
    private String name;

    @Size(min=7, max=30)
    @Column(name = "password", nullable = false)
    private String password;

    @Size(min=8, max=30)
    @Column(name = "email", nullable = false)
    private String email;

    @Size(min=13, max=19)
    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        return id == client.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}

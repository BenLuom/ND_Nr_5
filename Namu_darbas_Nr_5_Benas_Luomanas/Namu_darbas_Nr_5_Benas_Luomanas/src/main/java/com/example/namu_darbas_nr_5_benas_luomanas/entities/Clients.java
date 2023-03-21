package com.example.namu_darbas_nr_5_benas_luomanas.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private Integer personal_number;

    public Clients() {
    }

    public Clients(String name, String surname, String email, String phone, Integer personal_number) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.personal_number = personal_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPersonal_number() {
        return personal_number;
    }

    public void setPersonal_number(Integer personal_number) {
        this.personal_number = personal_number;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname=" + surname + '\'' +
                ", surname=" + email + '\'' +
                ", surname=" + phone + '\'' +
                ", surname=" + personal_number +
                '}';
    }
}

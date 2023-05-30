package com.example.namu_darbas_nr_5_benas_luomanas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name="clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Laukelis neturi būti tuščias")
    @Length(min = 3, max = 20, message = "Vardas turi būti netrumpesnis už 3 ir neilgesnis už 20 simbolių")
    @Column
    private String name;

    @NotEmpty(message = "Laukelis neturi būti tuščias")
    @Length(min = 3, max = 25, message = "Pavardė turi būti netrumpesnė už 3 ir neilgesnė už 25 simbolius")
    @Column
    private String surname;

    @NotEmpty(message = "Laukelis neturi būti tuščias")
    @Email(message = "Turi būti tinkamas elektroninio pašto adresas")
    @Column
    private String email;

    @Length(min = 0, max = 15, message = "Telefono numeris turi būti neilgesnis už 15 simbolių")
    @Column
    private String phone;

    @NotNull(message = "Laukelis neturi būti tuščias")
    @Column
    private Integer personal_number;

    @Column(nullable = true)
    private String agreement=null;

    @OneToMany(mappedBy = "Clients")
    private List<Registrations> Registrations;

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

    public List<com.example.namu_darbas_nr_5_benas_luomanas.entities.Registrations> getRegistrations() {
        return Registrations;
    }

    public void setRegistrations(List<com.example.namu_darbas_nr_5_benas_luomanas.entities.Registrations> registrations) {
        this.Registrations = registrations;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname=" + surname + '\'' +
                ", email=" + email + '\'' +
                ", phone=" + phone + '\'' +
                ", personal_number=" + personal_number +
                '}';
    }
}

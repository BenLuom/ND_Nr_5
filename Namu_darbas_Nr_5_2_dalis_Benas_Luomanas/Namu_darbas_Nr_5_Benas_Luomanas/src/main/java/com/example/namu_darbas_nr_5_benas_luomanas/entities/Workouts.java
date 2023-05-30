 package com.example.namu_darbas_nr_5_benas_luomanas.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="workouts")
public class Workouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String date;

    @Column
    private Integer places;

    @Column
    private String location;

    @OneToMany(mappedBy = "Workouts")
    private List<Registrations> Registrations;

    public Workouts() {
    }

    public Workouts(String name, String date, Integer places, String location) {
        this.name = name;
        this.date = date;
        this.places = places;
        this.location = location;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<com.example.namu_darbas_nr_5_benas_luomanas.entities.Registrations> getRegistrations() {
        return Registrations;
    }

    public void setRegistrations(List<com.example.namu_darbas_nr_5_benas_luomanas.entities.Registrations> registrations) {
        this.Registrations = registrations;
    }

    @Override
    public String toString() {
        return "Workouts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", places='" + places + '\'' +
                ", location=" + location +
                '}';
    }
}

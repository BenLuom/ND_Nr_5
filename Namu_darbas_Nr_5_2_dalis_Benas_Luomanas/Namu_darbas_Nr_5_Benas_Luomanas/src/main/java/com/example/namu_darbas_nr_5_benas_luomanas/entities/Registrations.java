package com.example.namu_darbas_nr_5_benas_luomanas.entities;


import jakarta.persistence.*;

@Entity
@Table(name="Registrations")
public class Registrations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String registration_date;

    @ManyToOne
    @JoinColumn(name="Clients_id")
    private Clients Clients;

    @ManyToOne
    @JoinColumn(name="Workouts_id")
    private Workouts Workouts;

    public Registrations() {
    }

    public Registrations(String registration_date, com.example.namu_darbas_nr_5_benas_luomanas.entities.Clients clients) {
        this.registration_date = registration_date;
        this.Clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public com.example.namu_darbas_nr_5_benas_luomanas.entities.Clients getClients() {
        return Clients;
    }

    public void setClients(com.example.namu_darbas_nr_5_benas_luomanas.entities.Clients clients) {
        this.Clients = clients;
    }
        public com.example.namu_darbas_nr_5_benas_luomanas.entities.Workouts getWorkouts() { return Workouts; }

        public void setWorkouts(com.example.namu_darbas_nr_5_benas_luomanas.entities.Workouts workouts) {
            this.Workouts = workouts;
    }

    @Override
    public String toString() {
        return "Registrations{" +
                "id=" + id +
                ", Clients=" + Clients +
                ", Workouts=" + Workouts +
                ", registration_date='" + registration_date +
                '}';
    }
}

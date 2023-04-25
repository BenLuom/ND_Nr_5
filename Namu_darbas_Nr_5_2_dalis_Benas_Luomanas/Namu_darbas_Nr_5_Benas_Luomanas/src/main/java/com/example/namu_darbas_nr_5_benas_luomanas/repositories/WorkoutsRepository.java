package com.example.namu_darbas_nr_5_benas_luomanas.repositories;

import com.example.namu_darbas_nr_5_benas_luomanas.entities.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutsRepository extends JpaRepository<Workouts, Integer> {
}
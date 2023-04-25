package com.example.namu_darbas_nr_5_benas_luomanas.controllers;

import com.example.namu_darbas_nr_5_benas_luomanas.entities.Workouts;
import com.example.namu_darbas_nr_5_benas_luomanas.repositories.WorkoutsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class WorkoutsController {
    @Autowired
    public WorkoutsRepository workoutsRepository;

    @GetMapping("/Workouts")
    public String registrations(Model model){
        List<Workouts> workouts=workoutsRepository.findAll();
        model.addAttribute("Workouts", workouts);
        return "workouts_list";
    }
}
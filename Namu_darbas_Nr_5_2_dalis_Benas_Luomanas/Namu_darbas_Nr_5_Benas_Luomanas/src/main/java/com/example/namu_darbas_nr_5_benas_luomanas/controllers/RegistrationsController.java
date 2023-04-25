package com.example.namu_darbas_nr_5_benas_luomanas.controllers;

import com.example.namu_darbas_nr_5_benas_luomanas.entities.Registrations;
import com.example.namu_darbas_nr_5_benas_luomanas.repositories.RegistrationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegistrationsController {
    @Autowired
    public RegistrationsRepository registrationsRepository;

    @GetMapping("/Registrations")
    public String registrations(Model model){
        List<Registrations> registrations=registrationsRepository.findAll();
        model.addAttribute("Registrations", registrations);
        return "registrations_list";
    }
}

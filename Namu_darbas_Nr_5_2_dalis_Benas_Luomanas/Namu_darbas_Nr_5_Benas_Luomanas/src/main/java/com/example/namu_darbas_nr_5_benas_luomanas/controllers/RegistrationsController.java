package com.example.namu_darbas_nr_5_benas_luomanas.controllers;

import com.example.namu_darbas_nr_5_benas_luomanas.entities.Clients;
import com.example.namu_darbas_nr_5_benas_luomanas.entities.Registrations;
import com.example.namu_darbas_nr_5_benas_luomanas.entities.Workouts;
import com.example.namu_darbas_nr_5_benas_luomanas.repositories.RegistrationsRepository;
import com.example.namu_darbas_nr_5_benas_luomanas.repositories.ClientsRepository;
import com.example.namu_darbas_nr_5_benas_luomanas.repositories.WorkoutsRepository;
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
    @Autowired
    public ClientsRepository clientsRepository;
    @Autowired
    public WorkoutsRepository workoutsRepository;
    @GetMapping("/Registrations")
    public String registrations(Model model){
        List<Registrations> registrations=registrationsRepository.findAll();
        model.addAttribute("Registrations", registrations);
        return "registrations_list";
    }

    @GetMapping("/RegistrationsController/new")
    public String newRegistrations(Model model){
        List<Clients> clients=clientsRepository.findAll();
        model.addAttribute("clients",clients);
        List<Workouts> workouts=workoutsRepository.findAll();
        model.addAttribute("workouts",workouts);
        return "registrations_new";
    }

    @PostMapping("/RegistrationsController/new")
    public String storeStudent(
            @RequestParam("registration_date") String registration_date,
            @RequestParam("clients_id") Integer clientsId,
            @RequestParam("workouts_id") Integer workoutsId
    ){
        Clients g=clientsRepository.getReferenceById(clientsId);
        Workouts w=workoutsRepository.getReferenceById(workoutsId);
        Registrations s=new Registrations(registration_date, g, w);
        registrationsRepository.save(s);
        return "redirect:/Registrations";
    }

    @GetMapping("RegistrationsController/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        registrationsRepository.deleteById(id);
        return "redirect:/Registrations";
    }
}

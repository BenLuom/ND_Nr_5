package com.example.namu_darbas_nr_5_benas_luomanas.controllers;

import com.example.namu_darbas_nr_5_benas_luomanas.entities.Clients;
import com.example.namu_darbas_nr_5_benas_luomanas.repositories.ClientsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientsController {
    @Autowired
    public ClientsRepository clientsRepository;

    @GetMapping("/")
    public String clients(Model model){
        List<Clients> clients= clientsRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients_list";
    }

    @GetMapping("/new")
    public String newClients(Model model){
        model.addAttribute("clients", new Clients());
        return "clients_new";
    }

    @PostMapping("/new")
    public String storeClients(
            @Valid
            @ModelAttribute
            Clients clients,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "clients_new";
        }
        clientsRepository.save(clients);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(
        @PathVariable("id") Integer id,
        Model model
    ){
        Clients g=clientsRepository.getReferenceById(id);
        model.addAttribute("clients", g);
        return "clients_update";
    }

    @PostMapping("/update/{id}")
    public String save(
            @Valid
            @ModelAttribute
            Clients clients,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "clients_update";
        }
        clientsRepository.save(clients);


        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        clientsRepository.deleteById(id);
        return "redirect:/";
    }

}

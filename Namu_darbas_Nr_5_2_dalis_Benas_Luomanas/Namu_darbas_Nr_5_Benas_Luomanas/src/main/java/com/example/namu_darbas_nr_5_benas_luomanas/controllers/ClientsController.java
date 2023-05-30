package com.example.namu_darbas_nr_5_benas_luomanas.controllers;
import com.example.namu_darbas_nr_5_benas_luomanas.entities.Clients;
import com.example.namu_darbas_nr_5_benas_luomanas.repositories.ClientsRepository;
import com.example.namu_darbas_nr_5_benas_luomanas.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class ClientsController {
    @Autowired
    public ClientsRepository clientsRepository;

    @Autowired
    public FileStorageService fileStorageService;


    @GetMapping("/")
    public String clients(Model model){
        List<Clients> clients= clientsRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients_list";
    }

    @GetMapping("/new")
    public String newClients(){
        return "clients_new";
    }
    @PostMapping("/new")
    public String storeClients(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("personal_number") Integer personal_number,
            @RequestParam("agreement") MultipartFile agreement
    ){
        Clients g=new Clients(name, surname, email, phone, personal_number);
        g.setAgreement(agreement.getOriginalFilename());
        clientsRepository.save(g);
        fileStorageService.store(agreement, g.getId().toString() );
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
            @PathVariable("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("personal_number") Integer personal_number,
            @RequestParam("agreement") MultipartFile agreement
    ){
        Clients g=clientsRepository.getReferenceById(id);
        g.setName(name);
        g.setSurname(surname);
        g.setEmail(email);
        g.setPhone(phone);
        g.setPersonal_number(personal_number);
        clientsRepository.save(g);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        clientsRepository.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/agreement")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable Integer id){
        Clients g=clientsRepository.getReferenceById(id);

        Resource r=fileStorageService.loadFile( g.getId().toString() );
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ g.getAgreement() +"\"")
                .body(r);
    }
}
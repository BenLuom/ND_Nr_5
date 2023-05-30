package com.example.namu_darbas_nr_5_benas_luomanas.controllers;

import com.example.namu_darbas_nr_5_benas_luomanas.entities.Workouts;
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
public class WorkoutsController {
    @Autowired
    public WorkoutsRepository workoutsRepository;

    @GetMapping("/Workouts")
    public String workouts(Model model){
        List<Workouts> workouts= workoutsRepository.findAll();
        model.addAttribute("workouts", workouts);
        return "workouts_list";
    }

    @GetMapping("WorkoutsController/new")
    public String newWorkouts(){
        return "workouts_new";
    }

    @PostMapping("WorkoutsController/new")
    public String storeWorkouts(
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("places") Integer places,
            @RequestParam("location") String location
    ){
        Workouts w=new Workouts(name, date, places, location);
        workoutsRepository.save(w);
        return "redirect:/Workouts";
    }

    @GetMapping("WorkoutsController/update/{id}")
    public String update(
            @PathVariable("id") Integer id,
            Model model
    ){
        Workouts w=workoutsRepository.getReferenceById(id);
        model.addAttribute("workouts", w);
        return "workouts_update";
    }

    @PostMapping("WorkoutsController/update/{id}")
    public String save(
            @PathVariable("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("places") Integer places,
            @RequestParam("location") String location
    ){
        Workouts w=workoutsRepository.getReferenceById(id);
        w.setName(name);
        w.setDate(date);
        w.setPlaces(places);
        w.setLocation(location);
        workoutsRepository.save(w);

        return "redirect:/Workouts";
    }

    @GetMapping("WorkoutsController/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        workoutsRepository.deleteById(id);
        return "redirect:/Workouts";
    }

}

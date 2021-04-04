package com.example.universetask.controller;

import com.example.universetask.entity.Master;
import com.example.universetask.entity.Planet;
import com.example.universetask.serivce.api.MasterService;
import com.example.universetask.serivce.api.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/masters")
@RequiredArgsConstructor

public class MasterController {
    private final MasterService masterService;
    private final PlanetService planetService;

    @GetMapping()
    public String getAll(Model model){
        model.addAttribute("planets",planetService.getAvailable());
        model.addAttribute("masters",masterService.getAllMasters());
        model.addAttribute("planetTo",new Planet());
        return "master";
    }
    @GetMapping("/planets/{id}")
    public String getPlanets(@PathVariable int id, Model model){
        model.addAttribute("planets",masterService.getAllPlanetsByMasterId(id));
        return "masterPlanetsPage";
    }
    @PostMapping("/planets/add/{id}")
    public String addPlanet(@PathVariable int id,
            @ModelAttribute(name ="planetTo")Planet planet){
        if (planetService.getAvailable().isEmpty()){
            return "redirect:/masters";
        }
        else masterService.addPlanetToMaster(id,planet);
        return "redirect:/masters";
    }


    @PostMapping("/add")
    public String addMaster(@ModelAttribute(name = "newMaster") Master master,
                            RedirectAttributes ra){

        boolean exist = masterService.getMasterByName(master.getName())!=null;

        if (exist){
            ra.addFlashAttribute("masterExists", true);
        }
        else {
            Master insert = masterService.insert(master);
            if (insert!=null) {
                ra.addFlashAttribute("masterSuccess", true);
            } else {
                ra.addFlashAttribute("error", true);
            }

        }
        return "redirect:/start";
    }
    @GetMapping("/top10")
    public String get10youngest(Model model){
        model.addAttribute("top10",masterService.get10youngest());
        return "youngestPage";
    }
    @GetMapping("/idlers")
    public String getIdlers(Model model){
        model.addAttribute("idleMasters",masterService.getIdlers());
        return "idlersPage";
    }
}

package com.example.universetask.controller;

import com.example.universetask.serivce.api.PlanetService;
import com.example.universetask.entity.Planet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetController {
    private final PlanetService planetService;

    @GetMapping("/destroy/{id}")
    public String destroyPlanet(@PathVariable int id){
        planetService.destroy(id);
        return "redirect:/masters";
    }
    @PostMapping("/add")
    public String addPlanet(@ModelAttribute(name = "newPlanet") Planet planet,
                            RedirectAttributes ra){
        boolean exist = planetService.getPlanetByName(planet.getName())!=null;
        if (exist){
            ra.addFlashAttribute("planetExists", true);
        }
        else {

           Planet insert= planetService.insert(planet);
           if (insert!=null)  ra.addFlashAttribute("planetSuccess",true);
           else ra.addFlashAttribute("emptyName",true);

        }
        return "redirect:/start";
    }
}

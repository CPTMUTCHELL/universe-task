package com.example.universetask.controller;

import com.example.universetask.entity.Master;
import com.example.universetask.entity.Planet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class StartController {
    @GetMapping("/start")
    public String start(Model model){
        model.addAttribute("newPlanet",new Planet());
        model.addAttribute("newMaster",new Master());
        return "startPage";
    }

}

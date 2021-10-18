package com.tts.mapsapp.controller;

import com.tts.mapsapp.model.Location;
import com.tts.mapsapp.service.MapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {

    @Autowired
    MapsService mapsService;

    @GetMapping("/home")
    public String getDefaultMap(Model model) {
        model.addAttribute(new Location());
//        Location location = new Location();
//        location.setCity("Dallas");
//        location.setState("Texas");
//        mapsService.addCoordinates(location);
//        System.out.println(location);
        return "index";
    }

    @PostMapping("/home")
    public String getMapForLocation(Location location, Model model) {
        mapsService.addCoordinates(location);
        model.addAttribute(location);
        return "index";
    }

    @PostMapping("/random")
    public String getRandomLocation(Location location, Model model) {
        mapsService.setRandomCoordinates(location);
        System.out.println(location);
        model.addAttribute(location);
        return "index";
    }

}

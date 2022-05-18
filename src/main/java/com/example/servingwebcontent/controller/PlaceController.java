package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.*;
import com.example.servingwebcontent.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PlaceController {
    @Autowired
    private PlaceRepo placeRepo;

    @GetMapping("/place")
    public String place( Map<String, Object> model){
        Iterable<Place> places = placeRepo.findAll();

        model.put("places", places);

        return "place";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/place")
    public String addplace(
            @RequestParam String address,
            Map<String, Object> model) {
        Place place = new Place(address);

        placeRepo.save(place);

        Iterable<Place> places = placeRepo.findAll();

        model.put("places", places);

        return "place";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/placeEdit/{place}")
    public String placeEdit(Model model, @PathVariable Place place) {

        model.addAttribute("place", place.getAddress());

        return "placeEdit";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/placeEdit/{place}")
    public String updatePlace(
            @PathVariable Place place,
            @RequestParam String address) {

        String placeAddress = place.getAddress();

        boolean isAddressChanged = (address != null && !address.equals(placeAddress)) ||
                (placeAddress != null && !placeAddress.equals(address));

        if (isAddressChanged) {
            place.setAddress(address);
        }

        placeRepo.save(place);

        return "redirect:/place";
    }
}

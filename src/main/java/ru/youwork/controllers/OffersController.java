package ru.youwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.youwork.models.Offer;
import ru.youwork.services.OfferService;

import java.io.IOException;

@Controller
public class OffersController {
    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/")
    public String offersList(Model model){
        model.addAttribute("offers", offerService.offerList());
        return "offer/offers";
    }

    @GetMapping("/offer/{id}")
    public String showOffer(@PathVariable Long id, Model model){
        Offer offer = offerService.getFromId(id);
        model.addAttribute("offer", offer);
        return "/offer/show";
    }

    @PostMapping("/offer/create")
    public String createOffer(Offer offer) throws IOException {
        offerService.save(offer);
        return "redirect:/";
    }

    @DeleteMapping("/offer/{id}")
    public String deleteOffer(@PathVariable Long id){
        offerService.deleteFromId(id);
        return "redirect:/";
    }
}

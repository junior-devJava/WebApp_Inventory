package com.invent.invetntarization.controller;


import com.invent.invetntarization.entity.InventoryEntity;
import com.invent.invetntarization.service.InventoryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.stereotype.Controller
public class Controller {
    private final InventoryService inventoryService;

    public Controller(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }


    @RequestMapping(value = "/addArticle", method = RequestMethod.GET)
    public String addArticle(Model model) {
        model.addAttribute("addArticle", new InventoryEntity());
        return "addArticle";
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String homeSubmit(@ModelAttribute InventoryEntity inventoryEntity, Model model) {
        model.addAttribute("addArticle", inventoryEntity);
        inventoryService.addInventoryObject(inventoryEntity);
        return "result";
    }
}

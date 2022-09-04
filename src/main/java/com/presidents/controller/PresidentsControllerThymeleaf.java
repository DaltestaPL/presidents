package com.presidents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@Controller
public class PresidentsControllerThymeleaf {

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("name", "Tomek");
        model.addAttribute("imiona", Arrays.asList("Karol", "Magda"));
        return "index";
    }
}

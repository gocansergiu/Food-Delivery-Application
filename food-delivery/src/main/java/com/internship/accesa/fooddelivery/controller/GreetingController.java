package com.internship.accesa.fooddelivery.controller;

import com.internship.accesa.fooddelivery.dto.UserDTO;
import com.internship.accesa.fooddelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class GreetingController {
    @Autowired
    private UserService userService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
      Optional<UserDTO> user =  userService.findByEmail("marius_blue_95@yahoo.com");
        model.addAttribute("user", user.get());
        return "greeting";
    }

}

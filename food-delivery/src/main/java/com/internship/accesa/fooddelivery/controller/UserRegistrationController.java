package com.internship.accesa.fooddelivery.controller;

import com.internship.accesa.fooddelivery.dto.UserDTO;
import com.internship.accesa.fooddelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDTO userRegistrationDto() {
        return new UserDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(UserDTO user, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

                userService.save(user);
                RedirectView redirectView = new RedirectView("/");
                modelAndView.setView(redirectView);

        return modelAndView;
    }

}

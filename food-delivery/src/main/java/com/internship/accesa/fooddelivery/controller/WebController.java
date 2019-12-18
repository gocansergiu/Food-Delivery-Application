package com.internship.accesa.fooddelivery.controller;

import com.internship.accesa.fooddelivery.dto.UserDTO;
import com.internship.accesa.fooddelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @GetMapping("/greeting")
    public String greeting(Model model, Principal principal) {
        Optional<UserDTO> user =  userService.findByEmail(principal.getName());
        model.addAttribute("user", user.get());
        return "greeting";
    }

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        return "index";
    }

    @RequestMapping(value="/perform_logout", method = RequestMethod.GET)
    public String performLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

}

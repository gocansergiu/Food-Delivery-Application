package com.internship.accesa.fooddelivery.controller;

import com.internship.accesa.fooddelivery.dto.UserDTO;
import com.internship.accesa.fooddelivery.model.AuthProvider;
import com.internship.accesa.fooddelivery.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Principal getUser(Principal user) {
        //DUMMY code - just to inserts a dummy user
        String email = "blabla@gmail.com";

        Optional<UserDTO> userDTO = userService.findByEmail(email);
        if (!userDTO.isPresent()) {
            UserDTO newUserDTO = new UserDTO()
                    .email("blabla@gmail.com")
                    .firstName("bla")
                    .lastName("bla")
                    .provider(AuthProvider.local);

            userService.save(newUserDTO);
        }
        return user;
    }
}

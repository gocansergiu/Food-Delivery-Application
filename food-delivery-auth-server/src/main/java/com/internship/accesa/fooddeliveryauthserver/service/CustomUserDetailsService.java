package com.internship.accesa.fooddeliveryauthserver.service;


import com.internship.accesa.fooddeliveryauthserver.model.AuthProvider;
import com.internship.accesa.fooddeliveryauthserver.model.User;
import com.internship.accesa.fooddeliveryauthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmailAndProviderAndEmailVerified(email, AuthProvider.local, true)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
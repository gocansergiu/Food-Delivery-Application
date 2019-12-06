package com.internship.accesa.fooddeliveryauthserver.service;

import com.internship.accesa.fooddeliveryauthserver.dto.UserDTO;
import com.internship.accesa.fooddeliveryauthserver.mapper.UserMapper;
import com.internship.accesa.fooddeliveryauthserver.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO save(UserDTO userDTO){
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Transactional
    public Optional<UserDTO> findByEmail(String email){
        return userRepository.findOneByEmail(email).map(userMapper::toDto);

    }

    @Transactional
    public Optional<UserDTO> findByConfirmationToken(String confirmationToken){
        return userRepository.findOneByConfirmationToken(confirmationToken).map(userMapper::toDto);

    }

}

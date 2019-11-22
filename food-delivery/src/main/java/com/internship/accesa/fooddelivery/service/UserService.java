package com.internship.accesa.fooddelivery.service;

import com.internship.accesa.fooddelivery.dto.UserDTO;
import com.internship.accesa.fooddelivery.mapper.UserMapper;
import com.internship.accesa.fooddelivery.repository.UserRepository;
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

}

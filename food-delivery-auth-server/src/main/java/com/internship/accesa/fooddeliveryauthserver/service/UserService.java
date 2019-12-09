package com.internship.accesa.fooddeliveryauthserver.service;

import com.internship.accesa.fooddeliveryauthserver.dto.UserDTO;
import com.internship.accesa.fooddeliveryauthserver.mapper.UserMapper;
import com.internship.accesa.fooddeliveryauthserver.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

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
    public Optional<UserDTO> findByIdWithEmailNotVerified(String id){
        if(StringUtils.isEmpty(id)){
            return Optional.empty();
        }else{
            return userRepository.findOneByIdAndEmailVerified(Long.valueOf(id), false).map(userMapper::toDto);
        }
    }

}

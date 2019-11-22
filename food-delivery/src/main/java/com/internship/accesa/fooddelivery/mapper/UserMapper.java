package com.internship.accesa.fooddelivery.mapper;

import com.internship.accesa.fooddelivery.dto.UserDTO;
import com.internship.accesa.fooddelivery.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toEntity(UserDTO user);

}

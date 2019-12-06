package com.internship.accesa.fooddeliveryauthserver.mapper;

import com.internship.accesa.fooddeliveryauthserver.dto.UserDTO;
import com.internship.accesa.fooddeliveryauthserver.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toEntity(UserDTO user);

}

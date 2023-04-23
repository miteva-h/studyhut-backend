package com.project.studyhut_backend.mapper;

import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
}

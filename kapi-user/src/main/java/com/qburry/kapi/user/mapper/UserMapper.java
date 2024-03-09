package com.qburry.kapi.user.mapper;

import com.qburry.kapi.user.dto.User;
import com.qburry.kapi.user.model.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AccountMapper.class)
public interface UserMapper {

    User toUser(UserEntity entity);
    List<User> toUsers (List<UserEntity> entities);

    UserEntity toEntity(User user);
    List<UserEntity> toEntities(List<User> users);
}

package com.qburry.kubesspring.springapi.user.mapper;

import com.qburry.kubesspring.springapi.user.dto.User;
import com.qburry.kubesspring.springapi.user.model.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AccountMapper.class)
public interface UserMapper {

    User toUser(UserEntity entity);
    List<User> toUsers (List<UserEntity> entities);

    UserEntity toEntity(User user);
    List<UserEntity> toEntities(List<User> users);
}

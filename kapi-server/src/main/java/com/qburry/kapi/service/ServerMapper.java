package com.qburry.kapi.service;

import com.qburry.kapi.annotations.EncodeMapping;
import com.qburry.kapi.commons.MapperConfiguration;
import com.qburry.kapi.model.RegistrationRequest;
import com.qburry.kapi.user.dto.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = MapperConfiguration.class, uses = PasswordEncoderMapper.class)
public interface ServerMapper {

    @Mapping(source = "username", target = "account.username")
    @Mapping(source = "password", target = "account.password", qualifiedBy = EncodeMapping.class)
    User toUser(RegistrationRequest request);
}

package com.qburry.kapi.ecom.mapper;

import com.qburry.kapi.commons.MapperConfiguration;
import com.qburry.kapi.ecom.dto.Cart;
import com.qburry.kapi.ecom.model.CartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = MapperConfiguration.class, uses = CartItemMapper.class)
public interface CartMapper {
    @Mapping(target = "user.id", source = "userId")
    CartEntity toEntity(Cart cart);

    @Mapping(target = "userId", source = "user.id")
    Cart toCart(CartEntity entity);
}

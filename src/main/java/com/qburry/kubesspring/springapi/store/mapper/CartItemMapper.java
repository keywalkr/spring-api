package com.qburry.kubesspring.springapi.store.mapper;

import com.qburry.kubesspring.springapi.store.dto.CartItem;
import com.qburry.kubesspring.springapi.store.model.CartItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "cart.id", source = "cartId")
    CartItemEntity toEntity(CartItem cartItem);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "cartId", source = "cart.id")
    CartItem toCartItem(CartItemEntity entity);
    Set<CartItem> toCartItems(List<CartItemEntity> entities);
}

package com.qburry.kapi.ecom.mapper;

import com.qburry.kapi.ecom.dto.Order;
import com.qburry.kapi.ecom.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "user.id", source = "userId")
    OrderEntity toEntity(Order order);

    @Mapping(target = "userId", source = "user.id")
    Order toOrder(OrderEntity entity);
}

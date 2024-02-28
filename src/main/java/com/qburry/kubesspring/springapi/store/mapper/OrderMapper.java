package com.qburry.kubesspring.springapi.store.mapper;

import com.qburry.kubesspring.springapi.store.dto.Order;
import com.qburry.kubesspring.springapi.store.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "user.id", source = "userId")
    OrderEntity toEntity(Order order);

    @Mapping(target = "userId", source = "user.id")
    Order toOrder(OrderEntity entity);
}

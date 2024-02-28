package com.qburry.kubesspring.springapi.store.service;

import com.qburry.kubesspring.springapi.store.dto.Order;
import com.qburry.kubesspring.springapi.store.mapper.OrderMapper;
import com.qburry.kubesspring.springapi.store.model.OrderEntity;
import com.qburry.kubesspring.springapi.store.repository.OrderRepository;
import com.qburry.kubesspring.springapi.user.mapper.UserMapper;
import com.qburry.kubesspring.springapi.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final UserMapper userMapper;

    private final OrderMapper orderMapper;

    public UUID save(Order order) {
        OrderEntity entity = orderMapper.toEntity(order);
        userService.findById(order.getUserId()).ifPresentOrElse(
                user -> {
                    entity.setUser(userMapper.toEntity(user));
                    orderRepository.save(entity);
                },
                () -> {
                    log.error("Error while saving order. User not found");
                }
        );
        return entity.getId();
    }

}

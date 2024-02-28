package com.qburry.kubesspring.springapi.store.service;

import com.qburry.kubesspring.springapi.store.dto.CartItem;
import com.qburry.kubesspring.springapi.store.mapper.CartItemMapper;
import com.qburry.kubesspring.springapi.store.model.CartItemEntity;
import com.qburry.kubesspring.springapi.store.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;
    public UUID saveItem(CartItem cartItem) {
        CartItemEntity entity = cartItemMapper.toEntity(cartItem);
        return cartItemRepository.save(entity).getId();
    }
}

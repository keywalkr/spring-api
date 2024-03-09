package com.qburry.kapi.ecom.service;

import com.qburry.kapi.ecom.dto.CartItem;
import com.qburry.kapi.ecom.mapper.CartItemMapper;
import com.qburry.kapi.ecom.model.CartItemEntity;
import com.qburry.kapi.ecom.repository.CartItemRepository;
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

package com.qburry.kapi.ecom.service;

import com.qburry.kapi.ecom.dto.Cart;
import com.qburry.kapi.ecom.mapper.CartMapper;
import com.qburry.kapi.ecom.model.CartEntity;
import com.qburry.kapi.ecom.repository.CartRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public UUID saveNewCart(Cart cart) {
        CartEntity entity = cartMapper.toEntity(cart);
        return cartRepository.save(entity).getId();
    }

    public Cart findByUserId(Long userId) {
        CartEntity entity = cartRepository.findCartEntityByUser(userId);
        return cartMapper.toCart(entity);
    }

    public Cart findById(UUID uuid) {
        CartEntity entity = cartRepository.findById(uuid).orElse(null);
        return cartMapper.toCart(entity);
    }
}

package com.qburry.kubesspring.springapi.store.controller;

import com.qburry.kubesspring.springapi.core.constants.Role;
import com.qburry.kubesspring.springapi.store.dto.Cart;
import com.qburry.kubesspring.springapi.store.dto.CartItem;
import com.qburry.kubesspring.springapi.store.service.CartItemService;
import com.qburry.kubesspring.springapi.store.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/store/cart")
public class CartController {

    private final CartService cartService;
    private final CartItemService itemService;

    @PostMapping("/add")
    public UUID createCart(@RequestBody Cart cart) {
        return cartService.saveNewCart(cart);
    }

    @GetMapping("/user/{id}")
    public Cart getUserCart(@PathVariable("id") Long userId) {
        return cartService.findByUserId(userId);
    }

    @PostMapping("/user/{id}/addItem")
    public UUID addItemToCart(
            @PathVariable("id") Long userId,
            @RequestBody CartItem cartItem) {
        return itemService.saveItem(cartItem);
    }
}

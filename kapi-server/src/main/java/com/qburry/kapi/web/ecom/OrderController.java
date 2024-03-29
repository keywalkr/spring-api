package com.qburry.kapi.web.ecom;

import com.qburry.kapi.ecom.dto.Order;
import com.qburry.kapi.ecom.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/store/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public UUID createNewOrder(@RequestBody Order order){
        return orderService.save(order);
    }
}

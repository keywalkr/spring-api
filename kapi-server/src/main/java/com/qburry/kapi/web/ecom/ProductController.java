package com.qburry.kapi.web.ecom;

import com.qburry.kapi.ecom.dto.Product;
import com.qburry.kapi.ecom.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/store/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public List<Product> getAllProducts() {
        return productService.findAllProduct();
    }
}

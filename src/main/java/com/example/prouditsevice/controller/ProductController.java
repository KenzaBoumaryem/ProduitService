package com.example.prouditsevice.controller;

import com.example.prouditsevice.dto.ProductRequest;
import com.example.prouditsevice.dto.ProductResponse;
import com.example.prouditsevice.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProduitService productService;

    public ProductController(ProduitService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest ){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return  productService.getAllProducts();
    }

}
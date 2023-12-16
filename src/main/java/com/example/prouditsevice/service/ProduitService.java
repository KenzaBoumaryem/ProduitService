package com.example.prouditsevice.service;

import com.example.prouditsevice.domain.model.Product;
import com.example.prouditsevice.dto.ProductRequest;
import com.example.prouditsevice.dto.ProductResponse;
import com.example.prouditsevice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProduitService {
    // @RequiredArgsConstructor va creer un constructeur et initialiser cette variable lors de la compilation
    private final ProductRepository productRepository;

    public  void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved",product.getId());
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return  products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product){
        return  ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}

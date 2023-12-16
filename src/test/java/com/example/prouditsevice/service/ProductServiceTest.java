package com.example.prouditsevice.service;

import com.example.prouditsevice.domain.model.Product;
import com.example.prouditsevice.dto.ProductResponse;
import com.example.prouditsevice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProduitService productService;

    @Test
    public void shouldReturnAllProducts() {
        // given
        List<Product> productList = new ArrayList<>();

        // when
        when(productRepository.findAll()).thenReturn(productList);

        // action
        List<ProductResponse> result = productService.getAllProducts(); // assuming productService calls productRepository.findAll()

        // assert
        assertEquals(productList.size(), result.size());
    }


}

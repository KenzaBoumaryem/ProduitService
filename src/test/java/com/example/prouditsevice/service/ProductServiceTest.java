package com.example.prouditsevice.service;

import com.example.prouditsevice.domain.model.Product;
import com.example.prouditsevice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Test
    public void ShouldreturnAllPouduct(){
        List<Product> productLis=new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productLis);
        assertEquals(productLis.size(),0);

    }
}

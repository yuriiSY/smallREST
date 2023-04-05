package com.rest.demo.service;

import com.rest.demo.dto.ProductDTO;
import com.rest.demo.entity.Product;
import com.rest.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    public Product create(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .amount(productDTO.getAmount())
                .category(categoryService.readById(productDTO.getCategoryID()))
                .build();
        return productRepository.save(product);
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public List<Product> readByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}

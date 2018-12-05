package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.Product;
import io.logostory.orderbook.backend.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "api")
public class ProductController {

    private final ProductRepository productRepository;
    private final ModelMapper modelmapper;

    public ProductController(ProductRepository productRepository, ModelMapper modelmapper) {
        this.productRepository = productRepository;
        this.modelmapper = modelmapper;
    }



    @PostMapping(path = "/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product) {

        return this.productRepository.save(product);
    }
}

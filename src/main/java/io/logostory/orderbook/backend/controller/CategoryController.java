package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.category.CategoryDto;
import io.logostory.orderbook.backend.domain.entity.category.Category;
import io.logostory.orderbook.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/category")
public class CategoryController {

    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody @Valid CategoryDto categoryDto, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Category category = modelMapper.map(categoryDto, Category.class);
        categoryService.create(category);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}

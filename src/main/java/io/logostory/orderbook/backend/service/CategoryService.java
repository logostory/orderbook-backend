package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.entity.category.Category;
import io.logostory.orderbook.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void create(Category category) {
        categoryRepository.save(category);
    }

}

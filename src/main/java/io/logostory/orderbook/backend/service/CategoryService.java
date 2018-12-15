package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.dto.category.CategoryDto.*;
import io.logostory.orderbook.backend.domain.entity.category.Category;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import io.logostory.orderbook.backend.repository.CategoryRepository;
import io.logostory.orderbook.backend.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService {

    @Autowired CategoryRepository   categoryRepository;
    @Autowired ShopRepository       shopRepository;

    public void create(Category category) {
        categoryRepository.save(category);
    }

    public Category addCategory(Long shopId, CategoryAddDto cadto) {

        Shop shop = shopRepository.findById(shopId).orElse(Shop.builder().build());
        return categoryRepository.save(cadto.toCategory().setShop(shop));
    }

    public List<Category> addCategoryList(Long shopId, List<CategoryAddDto> catedtos) {

        Shop shop = shopRepository.findById(shopId).orElse(Shop.builder().build());

        List<Category> categories = catedtos.stream().map(cadto -> cadto.toCategory().setShop(shop)).collect(Collectors.toList());
        categories = categoryRepository.saveAll(categories);

        log.debug("Saved category count is {}", categories.size());
        return categories;
    }
}

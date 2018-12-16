package io.logostory.orderbook.backend.domain.dto.category;

import io.logostory.orderbook.backend.domain.entity.category.Category;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    String categoryName;

    public static class CategoryAddDto extends  CategoryDto{

        public Category toCategory() {
            return Category.builder().categoryName(categoryName).build();
        }
    }

    @Data
    public  static class CategorySearchResultDto extends  CategoryDto {

        Long categoryId;

        public CategorySearchResultDto(Category category) {
            categoryId = category.getCategoryId();
            categoryName = category.getCategoryName();
        }
    }
}
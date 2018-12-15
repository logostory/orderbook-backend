package io.logostory.orderbook.backend.domain.dto.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.logostory.orderbook.backend.domain.entity.category.Category;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.domain.entity.menu.Option;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    @NotEmpty
    Long categoryId;
    @NotEmpty
    String name;
    @NotEmpty
    Long price;
    String comment;
    String imagePath;

    @Data
    public static  class MenuAddDto extends  MenuDto{

        private List<OptionDto.OptionAddDto> options;

        public Menu toMenu() {

            Menu menu = new Menu();
            menu.setCategory(Category.builder().categoryId(categoryId).build());
            menu.setMenuName(name);
            menu.setPrice(price);
            menu.setComment(comment);
            menu.setImagePath(imagePath);
            menu.setOptions(options.stream().map(o -> o.toOption().builder().menu(menu).build()).collect(Collectors.toList()));
            return menu;
        }

    }

    @Data
    public static class MenuSearchResultDto extends MenuDto {

        Long menuId;

        public MenuSearchResultDto(Menu m) {

            menuId = m.getMenuId();
//            categoryId = m.getCategory().getCategoryId();
            name = m.getMenuName();
            price = m.getPrice();
            comment = m.getComment();
            imagePath = m.getImagePath();

        }
    }
}

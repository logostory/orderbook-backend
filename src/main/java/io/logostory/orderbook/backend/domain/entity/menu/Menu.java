package io.logostory.orderbook.backend.domain.entity.menu;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.category.Category;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "menuId")
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long menuId;
	private String menuName;
	private Long price;
	private String imagePath;
	private String comment;

	@ManyToOne
	@JoinColumn(name = "shopId")
	@Setter(AccessLevel.NONE)
	Shop shop;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	Category category;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="menu")
	List<Option> options;

	public Menu setShop(Shop shop) {
		this.shop = shop;
		return this;
	}
}

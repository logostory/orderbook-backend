package io.logostory.orderbook.backend.domain.entity.menu;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends AuditEntity {
	@Id
	@GeneratedValue
	private Long id;
	private Long categoryId;
	private String name;
	private Long price;
	private String imagePath;
	private String comment;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="menu")
	List<Option> options;
}

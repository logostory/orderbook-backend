package io.logostory.orderbook.backend.domain.entity.menu;


import javax.persistence.*;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import lombok.*;


@Entity
@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "optionId")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`option`")
public class Option extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;
	private String optionName;
	private Long price;

	@ManyToOne(optional=false)
	@JoinColumn(name="menu")
	@Setter(AccessLevel.NONE)
	private Menu menu;

	public Option setMenu(Menu menu) {
		this.menu = menu;
		return this;
	}
}

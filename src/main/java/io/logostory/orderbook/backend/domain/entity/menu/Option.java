package io.logostory.orderbook.backend.domain.entity.menu;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "option")
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long price;

	@ManyToOne(optional=false)
	@JoinColumn(name="menu")
	private Menu menu;
}

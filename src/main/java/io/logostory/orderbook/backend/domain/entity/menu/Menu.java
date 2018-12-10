package io.logostory.orderbook.backend.domain.entity.menu;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String name;
	String comment;
 
	@OneToMany(cascade=CascadeType.ALL, mappedBy="menu")
	List<Option> options;
}

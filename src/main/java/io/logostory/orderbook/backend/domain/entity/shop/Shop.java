package io.logostory.orderbook.backend.domain.entity.shop;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shop extends AuditEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}

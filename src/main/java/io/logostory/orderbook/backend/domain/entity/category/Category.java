package io.logostory.orderbook.backend.domain.entity.category;

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
public class Category extends AuditEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String shopId;

    private String name;
}

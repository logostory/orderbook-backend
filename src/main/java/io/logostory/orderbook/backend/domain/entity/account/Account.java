package io.logostory.orderbook.backend.domain.entity.account;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account extends AuditEntity {

    @Id
    @GeneratedValue
    private Integer accountId;

    private String username;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<AccountRoles> roles;

}

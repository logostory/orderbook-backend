package io.logostory.orderbook.backend.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.domain.entity.menu.QMenu;
import io.logostory.orderbook.backend.repository.criteria.MenuCriteria;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Menu> findByMenu(MenuCriteria criteria) {
        Predicate predicate = getDefaultPredicate(criteria.getShopId());

        if (!Objects.isNull(criteria.getMenuId())) {
            predicate = ((BooleanExpression) predicate).and(QMenu.menu.menuId.eq(criteria.getMenuId()));
        }

        return queryFactory.selectFrom(QMenu.menu)
                .where(predicate)
                .fetch();
    }

    private Predicate getDefaultPredicate(Long shopId) {
        return QMenu.menu.shop.shopId.eq(shopId);
    }
}

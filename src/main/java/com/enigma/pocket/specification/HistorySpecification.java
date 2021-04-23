package com.enigma.pocket.specification;

import com.enigma.pocket.dto.HistorySearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;

public class HistorySpecification {
    public static Specification<HistoryProduct> findHistory(HistorySearchDto historySearchDto){
        return new Specification<HistoryProduct>() {
            @Override
            public Predicate toPredicate(Root<HistoryProduct> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<Predicate>();
                if (!(historySearchDto.getPriceBuy()==null || (historySearchDto.getPriceBuy().equals("")))){
                    final Predicate priceBuyPredicate = criteriaBuilder.equal(root.get("priceBuy"), historySearchDto.getPriceBuy());
                    predicates.add(priceBuyPredicate);
                }
                if (!(historySearchDto.getPriceSell()==null || (historySearchDto.getPriceSell().equals("")))){
                    final Predicate priceSellPredicate = criteriaBuilder.equal(root.get("priceSell"),historySearchDto.getPriceSell());
                    predicates.add(priceSellPredicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}

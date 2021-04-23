package com.enigma.pocket.repository;

import com.enigma.pocket.entity.HistoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryProduct, String>, JpaSpecificationExecutor<HistoryProduct> {

}

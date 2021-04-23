package com.enigma.pocket.service;

import com.enigma.pocket.dto.HistorySearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HistoryService {
    public HistoryProduct findHistoryById(String id);
    public Page<HistoryProduct> findHistories(HistorySearchDto history, Pageable pageable);
    public HistoryProduct createHistory(HistoryProduct historyProduct);
    public void updateHistory(HistoryProduct historyProduct);
    public void removeHistory(String id);
    public List<HistoryProduct> findAllByProduct(String productId);
}

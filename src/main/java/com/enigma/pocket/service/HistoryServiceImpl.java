package com.enigma.pocket.service;

import com.enigma.pocket.dto.HistorySearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.exception.ProductNotFoundException;
import com.enigma.pocket.repository.HistoryRepository;
import com.enigma.pocket.specification.HistorySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService{
    private final String notFoundMessage = "History with id: %s Not Found";

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    ProductService productService;

    @Override
    public HistoryProduct findHistoryById(String id) {
        return historyRepository.findById(id).get();

    }

    @Override
    public Page<HistoryProduct> findHistories(HistorySearchDto history, Pageable pageable) {
        Page<HistoryProduct> historyProducts = historyRepository.findAll(HistorySpecification.findHistory(history), pageable);
        return historyProducts;
    }

    @Override
    public HistoryProduct createHistory(HistoryProduct historyProduct) {
        return historyRepository.save(historyProduct);
    }

    @Override
    public void updateHistory(HistoryProduct historyProduct) {
        validatePresent(historyProduct.getId());
        historyRepository.save(historyProduct);
    }
    private void validatePresent(String id){
        if (!historyRepository.findById(id).isPresent()){
            throw new ProductNotFoundException(String.format(notFoundMessage, id));
        }
    }

    @Override
    public void removeHistory(String id) {
        historyRepository.deleteById(id);
    }

    @Override
    public List<HistoryProduct> findAllByProduct(String productId) {
        Product product = productService.findProductById(productId);
        return product.getHistoryProducts();
    }
}

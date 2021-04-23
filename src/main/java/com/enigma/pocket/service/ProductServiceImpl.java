package com.enigma.pocket.service;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.exception.ProductNotFoundException;
import com.enigma.pocket.repository.ProductRepository;
import com.enigma.pocket.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final String notFoundMessage = "Product with id: %s Not Found";

    @Autowired
    ProductRepository productRepository;

    @Autowired
    HistoryService historyService;

    @Override
    public Product findProductById(String id) {
        return productRepository.findById(id).get();
    }

//    @Override
//    public Page<Product> findProducts(ProductSearchDto product, Pageable pageable) {
//        Page<Product> products = productRepository.findAll(ProductSpecification.findProduct(product), pageable);
//        return products;
//    }
    @Override
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return persistProduct(product);
    }



    @Override
    public Product updateProduct(Product product) {
        validatePresent(product.getId());
        return persistProduct(product);
    }

    private void validatePresent(String id){
        if (!productRepository.findById(id).isPresent()){
            throw new ProductNotFoundException(String.format(notFoundMessage, id));
        }
    }

    private Product persistProduct(Product product) {
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        Product createdProduct = productRepository.save(product);
        HistoryProduct historyProduct = new HistoryProduct(createdProduct);
        historyService.createHistory(historyProduct);
        return createdProduct;
    }

    @Override
    public void removeProduct(String id) {
        productRepository.deleteById(id);
    }
}

package com.enigma.pocket.controller;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.service.HistoryService;
import com.enigma.pocket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    ProductService productService;

    @Autowired
    HistoryService historyService;


    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(name = "id") String id){
        return productService.findProductById(id);
    }
    @GetMapping("/product/{id}/history")
    public List<HistoryProduct> getHistoryByProduct(@PathVariable(name = "id") String id){
        return historyService.findAllByProduct(id);
    }

//    @GetMapping("/products")
//    public Page<Product> getAllProducts(@RequestBody ProductSearchDto product,
//                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
//                                        @RequestParam(name = "size", defaultValue = "5") Integer size
//    ){
//        Pageable pageable = PageRequest.of(page, size);
//        return productService.findProducts(product, pageable);
//    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.findProducts();
    }

    @PostMapping("/product/create")
    public Product createNewProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable String id){
        productService.removeProduct(id);
    }

}

package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseRestController {
    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/purchases")
    public List<Purchase> getAllPurchases(){
        return purchaseService.findPurchases();
    }

    @PostMapping("/purchase")
    public Purchase purchase(@RequestParam(name = "customerId") String customerId,
                             @RequestBody Purchase purchase){
        return purchaseService.purchase(purchase, customerId);
    }
//    @PostMapping("/purchase")
//    public Purchase purchase(Purchase purchase){
//        return purchaseService.purchase(purchase);
//    }
}

package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseRestController {
    @Autowired
    PurchaseService purchaseService;
    @PostMapping("/purchase")
    public Purchase purchase(@RequestParam(name = "customerId") String customerId,
                             @RequestBody Purchase purchase){
        return purchaseService.purchase(purchase, customerId);
    }
//    @PostMapping("/purchase")
//    public Purchase purchase(Purchase purchase){
//        return purchaseService.purchase(purchase);
//    }
//    @PostMapping("/purchase")
//    public Purchase purchase(Purchase purchase){
//        return purchaseService.purchase(purchase);
//    }
}

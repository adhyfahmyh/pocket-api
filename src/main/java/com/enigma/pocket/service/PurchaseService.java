package com.enigma.pocket.service;

import com.enigma.pocket.entity.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface PurchaseService {
    public Purchase purchase(Purchase purchase, String customerId);
    public Purchase findPurchaseById(String id);
    public List<Purchase> findPurchases();

}

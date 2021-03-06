package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PocketServiceImpl implements PocketService {
    @Autowired
    PocketRepository pocketRepository;
    @Autowired
    CustomerService customerService;

    @Override
    public Pocket findPocketById(String id) {
        Pocket pocket = pocketRepository.findById(id).get();
        return pocket;
    }

    @Override
    public List<Pocket> findPockets() {
        return pocketRepository.findAll();
    }

    @Override
    public Pocket createPocket(Pocket pocket) {
        pocket.setPocketQty(0.0);
        return pocketRepository.save(pocket);
    }

    @Override
    public Pocket updatePocket(Pocket pocket) {
        return pocketRepository.save(pocket);
    }

    @Override
    public void removePocket(String id) {
        pocketRepository.deleteById(id);
    }

    @Override
    public void topUp(Pocket pocket, Double qty, Integer purchaseType) {
        if (purchaseType == 0) {
            pocket.setPocketQty(pocket.getPocketQty() + qty);
        } else {
            pocket.setPocketQty(pocket.getPocketQty() - qty);
        }
        pocketRepository.save(pocket);
    }

    @Override
    public List<Pocket> findAllByCustomer(String customerId) {
        Customer customer = customerService.findCustomerId(customerId);
        return customer.getPockets();
    }
}

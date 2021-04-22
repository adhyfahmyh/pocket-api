package com.enigma.pocket.service;

import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PocketService {
    public Pocket findPocketById(String id);
    public List<Pocket> findPockets();
    public void createPocket(Pocket pocket);
    public void updatePocket(Pocket pocket);
    public void removeCustomer(String id);
}

package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

//@Repository
//public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//}

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    @Query(value = "SELECT * FROM m_customers WHERE username=:username and password=:password", nativeQuery = true)
    Customer findCustomerLogin(String username, String password);
}

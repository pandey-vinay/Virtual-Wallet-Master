package com.Wallet.Task.virtualwallet.repository;

import com.Wallet.Task.virtualwallet.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.email=:email")
    Iterable<Customer> findCustomerByEmail(@Param("email") String email);


}

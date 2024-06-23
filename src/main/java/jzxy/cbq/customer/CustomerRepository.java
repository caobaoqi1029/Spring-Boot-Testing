package jzxy.cbq.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author: cbq1024
 * @description: CreateCustomerRequest
 * @since 2024/6/23 14:57
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findByEmail(String email);
}

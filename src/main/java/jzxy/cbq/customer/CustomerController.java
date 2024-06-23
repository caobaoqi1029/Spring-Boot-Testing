package jzxy.cbq.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: cbq1024
 * @description: CreateCustomerRequest
 * @since 2024/6/23 14:57
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        log.info("Received get all customers request");
        return customerService.getCustomers();
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id) {
        log.info("Received the get customer with id {}", id);
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        log.info("Received create new customer {}", createCustomerRequest);
        customerService.createCustomer(createCustomerRequest);
    }


    @PutMapping(path = "/{id}")
    public void updateCustomer(@PathVariable("id") Integer id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String address) {
        log.info("Received the update request of id: {} with name: {}, email: {}, address: {}",
                id, name, email, address);
        customerService.updateCustomer(id, name, email, address);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        log.info("Received the delete customer with id: {}", id);
        customerService.deleteCustomer(id);
    }
}

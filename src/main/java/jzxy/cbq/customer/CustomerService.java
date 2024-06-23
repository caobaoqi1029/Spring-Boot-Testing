package jzxy.cbq.customer;

import jzxy.cbq.exception.CustomerEmailUnavailableException;
import jzxy.cbq.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author: cbq1024
 * @description: CreateCustomerRequest
 * @since 2024/6/23 14:57
 */
@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    /**
     * getCustomers
     *
     * @return List<Customer>
     */
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     * getCustomerById
     *
     * @param id id
     * @return Customer
     */
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("Customer with id " + id + " doesn't found"));
    }

    /**
     * createCustomer
     *
     * @param createCustomerRequest createCustomerRequest
     */
    public void createCustomer(CreateCustomerRequest createCustomerRequest) {
        validateCustomerByEmail(createCustomerRequest.email());
        Customer customer = Customer.builder()
                .name(createCustomerRequest.name())
                .email(createCustomerRequest.email())
                .address(createCustomerRequest.address()).build();
        customerRepository.save(customer);
    }


    /**
     * updateCustomer
     *
     * @param id      id
     * @param name    name
     * @param email   email
     * @param address address
     */
    public void updateCustomer(Integer id, String name, String email, String address) {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("Customer with id " + id + " doesn't found"));
        if (Objects.nonNull(name) && !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }
        if (Objects.nonNull(email) && !Objects.equals(customer.getEmail(), email)) {
            validateCustomerByEmail(email);
            customer.setEmail(email);
        }
        if (Objects.nonNull(address) && !Objects.equals(customer.getAddress(), address)) {
            customer.setAddress(address);
        }
        customerRepository.save(customer);
    }

    /**
     * deleteCustomer
     *
     * @param id id
     */
    public void deleteCustomer(Integer id) {
        boolean isExist = customerRepository.existsById(id);
        if (!isExist) {
            throw new CustomerNotFoundException("Customer with id " + id + " doesn't exist.");
        }
        customerRepository.deleteById(id);
    }

    /**
     * validateCustomerByEmail
     * @param email email
     */
    private void validateCustomerByEmail(String email) {
        Optional<Customer> customerByEmail = customerRepository.findByEmail(email);
        if (customerByEmail.isPresent()) {
            throw new CustomerEmailUnavailableException("The email \"" + email + "\" unavailable to update");
        }
    }

}

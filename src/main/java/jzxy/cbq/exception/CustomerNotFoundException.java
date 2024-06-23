package jzxy.cbq.exception;

/**
 * @author: cbq1024
 * @description: CreateCustomerRequest
 * @since 2024/6/23 14:57
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

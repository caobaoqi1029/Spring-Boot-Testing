package jzxy.cbq.customer;

/**
 * @author: cbq1024
 * @description: CreateCustomerRequest
 * @since 2024/6/23 14:57
 */
public record CreateCustomerRequest(String name,
                                    String email,
                                    String address) {
}

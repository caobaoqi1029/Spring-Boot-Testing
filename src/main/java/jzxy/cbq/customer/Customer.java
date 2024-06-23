package jzxy.cbq.customer;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author: cbq1024
 * @description: CreateCustomerRequest
 * @since 2024/6/23 14:57
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private String email;
    private String address;

}

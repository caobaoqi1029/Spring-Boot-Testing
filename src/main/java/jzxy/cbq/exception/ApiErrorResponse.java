package jzxy.cbq.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author: cbq1024
 * @description: CreateCustomerRequest
 * @since 2024/6/23 14:57
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {

    private HttpStatus httpStatus;
    private String message;
    private String path;
    private String api;
    private ZonedDateTime timestamp;

}

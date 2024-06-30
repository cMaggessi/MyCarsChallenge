package com.cars.mycarsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private HttpStatus httpStatus;
    private Integer statusCode;
}

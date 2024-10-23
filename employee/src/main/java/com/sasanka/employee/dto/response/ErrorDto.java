package com.sasanka.employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDto {
    private int statusCode;
    private String errorMessage;
    private LocalDateTime timeStamp;
}

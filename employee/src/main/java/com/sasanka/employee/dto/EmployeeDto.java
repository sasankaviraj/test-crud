package com.sasanka.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class EmployeeDto {

    @NotBlank(message = "Employee number cannot be empty")
    @Size(max = 10, message = "Employee number must be at most 10 characters")
    private String empNo;

    @NotBlank(message = "Employee name cannot be empty")
    @Size(max = 100, message = "Employee name must be at most 100 characters")
    private String empName;

    @NotBlank(message = "Address line 1 cannot be empty")
    @Size(max = 100, message = "Address line 1 must be at most 100 characters")
    private String empAddressLine1;

    @Size(max = 100, message = "Address line 2 must be at most 100 characters")
    private String empAddressLine2;

    @Size(max = 100, message = "Address line 3 must be at most 100 characters")
    private String empAddressLine3;

    @NotNull(message = "Date of joining cannot be null")
    private LocalDateTime empDateOfJoin;

    @NotNull(message = "Employee status cannot be null")
    private Boolean empStatus;

    private String empImage;
}

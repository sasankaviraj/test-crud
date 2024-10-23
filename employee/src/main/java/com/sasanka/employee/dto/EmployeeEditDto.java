package com.sasanka.employee.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class EmployeeEditDto {
    private String empNo;
    private String empName;
    private String empAddressLine1;
    private String empAddressLine2;
    private String empAddressLine3;
    private LocalDateTime empDateOfJoin;
    private Boolean empStatus;
    private String empImage;
}

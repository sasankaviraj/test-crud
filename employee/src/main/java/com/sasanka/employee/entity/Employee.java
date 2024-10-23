package com.sasanka.employee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "empNo",nullable = false)
    private String empNo;
    @Column(name = "empName", nullable = false)
    private String empName;
    @Column(name = "empAddressLine1",nullable = false)
    private String empAddressLine1;
    @Column(name = "empAddressLine2")
    private String empAddressLine2;
    @Column(name = "empAddressLine3")
    private String empAddressLine3;
    @Column(nullable = false, name = "empDateOfJoin")
    private LocalDateTime empDateOfJoin;
    @Column(nullable = false, name = "empStatus")
    private Boolean empStatus;
    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT", name = "empImage")
    private String empImage;

}

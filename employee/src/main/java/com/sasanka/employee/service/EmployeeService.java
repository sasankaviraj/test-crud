package com.sasanka.employee.service;

import com.sasanka.employee.dto.EmployeeDto;
import com.sasanka.employee.dto.EmployeeEditDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmployeeService {

    ResponseEntity<?> create(EmployeeDto employeeDto, MultipartFile file) throws IOException;
    ResponseEntity<?> update(EmployeeDto employeeDto, MultipartFile file, Long id) throws IOException;
    ResponseEntity<?> edit(EmployeeEditDto employeeEditDto, MultipartFile file, Long id) throws IOException;
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> getAll();
}

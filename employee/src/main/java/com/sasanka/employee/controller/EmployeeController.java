package com.sasanka.employee.controller;

import com.sasanka.employee.dto.EmployeeDto;
import com.sasanka.employee.dto.EmployeeEditDto;
import com.sasanka.employee.exception.NotFoundException;
import com.sasanka.employee.service.EmployeeService;
import com.sasanka.employee.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(Constants.BASE_URL)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> create(@RequestParam("file") MultipartFile file,@Valid EmployeeDto employeeDto) throws IOException {
        return employeeService.create(employeeDto, file);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> update(@RequestParam("file") MultipartFile file,@Valid EmployeeDto employeeDto,@PathVariable("id") Long id) throws IOException {
        return employeeService.update(employeeDto, file, id);
    }

    @PatchMapping(value = "/edit/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> edit(@RequestParam("file") MultipartFile file, @Valid EmployeeEditDto employeeEditDto, @PathVariable("id") Long id) throws IOException, IllegalAccessException {
        return employeeService.edit(employeeEditDto, file, id);
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws IOException {
        return employeeService.delete(id);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("id") Long id) throws NotFoundException {
        return employeeService.getById(id);
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        return employeeService.getAll();
    }
}

package com.sasanka.employee.service.impl;

import com.sasanka.employee.dto.EmployeeDto;
import com.sasanka.employee.entity.Employee;
import com.sasanka.employee.exception.NotFoundException;
import com.sasanka.employee.repository.EmployeeRepository;
import com.sasanka.employee.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sasanka.employee.dto.EmployeeEditDto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public ResponseEntity<?> create(EmployeeDto employeeDto, MultipartFile file) throws IOException {
        if(file.isEmpty())
            throw new FileNotFoundException("File not found");
        String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setEmpImage(base64Image);
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee record saved successfully with image.");
    }

    @Override
    public ResponseEntity<?> update(EmployeeDto employeeDto, MultipartFile file, Long id) throws IOException {
        Employee employee = findEmployeeById(id);
        BeanUtils.copyProperties(employeeDto, employee);
        if(!file.isEmpty()){
            String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
            employee.setEmpImage(base64Image);
        }
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee record updated successfully");
    }

    @Override
    public ResponseEntity<?> edit(EmployeeEditDto employeeEditDto, MultipartFile file, Long id) throws IOException {
        Employee employee = findEmployeeById(id);
        if(!file.isEmpty()){
            String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
            employee.setEmpImage(base64Image);
        }
        if (Objects.nonNull(employeeEditDto.getEmpNo()) && !employeeEditDto.getEmpNo().isBlank()) {
            employee.setEmpNo(employeeEditDto.getEmpNo());
        }
        if (Objects.nonNull(employeeEditDto.getEmpName()) && !employeeEditDto.getEmpName().isBlank()) {
            employee.setEmpName(employeeEditDto.getEmpName());
        }
        if (Objects.nonNull(employeeEditDto.getEmpAddressLine1()) && !employeeEditDto.getEmpAddressLine1().isBlank()) {
            employee.setEmpAddressLine1(employeeEditDto.getEmpAddressLine1());
        }
        if (Objects.nonNull(employeeEditDto.getEmpAddressLine2()) && !employeeEditDto.getEmpAddressLine2().isBlank()) {
            employee.setEmpAddressLine2(employeeEditDto.getEmpAddressLine2());
        }
        if (Objects.nonNull(employeeEditDto.getEmpAddressLine3()) && !employeeEditDto.getEmpAddressLine3().isBlank()) {
            employee.setEmpAddressLine3(employeeEditDto.getEmpAddressLine3());
        }
        if (Objects.nonNull(employeeEditDto.getEmpDateOfJoin())) {
            employee.setEmpDateOfJoin(employeeEditDto.getEmpDateOfJoin());
        }
        if (Objects.nonNull(employeeEditDto.getEmpStatus())) {
            employee.setEmpStatus(employeeEditDto.getEmpStatus());
        }
        if (Objects.nonNull(employeeEditDto.getEmpImage()) && !employeeEditDto.getEmpImage().isBlank()) {
            employee.setEmpImage(employeeEditDto.getEmpImage());
        }
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee record updated successfully");
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found by the id"));
        employeeRepository.delete(employee);
        return ResponseEntity.ok("Employee record deleted successfully");
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        return new ResponseEntity<>(findEmployeeById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    private Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found by the id"));
    }
}

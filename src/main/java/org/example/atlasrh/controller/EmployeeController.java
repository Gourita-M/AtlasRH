package org.example.atlasrh.controller;

import org.example.atlasrh.dto.EmployeeResponseDTO;
import org.example.atlasrh.model.Employee;
import org.example.atlasrh.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAll(){
        return ResponseEntity.ok(employeeService.viewAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee employee){
        try {
            Employee created = employeeService.create(employee);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(created);

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
}

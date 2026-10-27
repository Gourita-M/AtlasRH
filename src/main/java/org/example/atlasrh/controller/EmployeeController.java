package org.example.atlasrh.controller;

import org.example.atlasrh.dto.EmployeeResponseDTO;
import org.example.atlasrh.model.Employee;
import org.example.atlasrh.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}")
    public ResponseEntity<?> create(@RequestBody Employee employee, @PathVariable Long id){
        try {
            Employee created = employeeService.create(employee, id);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(created);

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewEmployee(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(employeeService.viewEmployee(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

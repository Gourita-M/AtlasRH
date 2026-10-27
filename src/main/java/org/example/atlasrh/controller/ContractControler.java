package org.example.atlasrh.controller;


import org.example.atlasrh.model.Contract;
import org.example.atlasrh.model.Employee;
import org.example.atlasrh.repository.EmployeeRepository;
import org.example.atlasrh.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
public class ContractControler {
    private final ContractService contractService;
    private final EmployeeRepository employeeRepository;

    public ContractControler(ContractService contractService, EmployeeRepository employeeRepository){
        this.contractService = contractService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok(contractService.viewAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> save(@RequestBody Contract contract, @PathVariable("id") Long id){
        try{
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(contractService.create(contract, id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}

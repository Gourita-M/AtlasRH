package org.example.atlasrh.controller;


import org.example.atlasrh.model.Contract;
import org.example.atlasrh.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contract")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService){
        this.contractService = contractService;
    }

    //PostMan done
    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok(contractService.viewAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //PostMan done
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

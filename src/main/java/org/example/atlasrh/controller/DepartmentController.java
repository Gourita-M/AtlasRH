package org.example.atlasrh.controller;

import org.example.atlasrh.dto.DepartmentResponseDTO;
import org.example.atlasrh.model.Department;
import org.example.atlasrh.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //PostMan done
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(departmentService.viewAll());
    }

    //PostMan done
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Department department) {
        try{
            DepartmentResponseDTO dto = departmentService.create(department);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}

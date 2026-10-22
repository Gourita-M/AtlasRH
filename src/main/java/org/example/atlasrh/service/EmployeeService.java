package org.example.atlasrh.service;

import org.example.atlasrh.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    //EmployeeResponseDTO create(EmployeeRequestDTO dto);

    //EmployeeResponseDTO update(Long id, Employee employee);

    //EmployeeResponseDTO viewEmployee(Long id);

    List<EmployeeResponseDTO> viewAll();

    //List<EmployeeResponseDTO> viewAllByManager(Long managerId);
}
package org.example.atlasrh.service;

import org.example.atlasrh.dto.ContractResponseDTO;
import org.example.atlasrh.dto.DepartmentResponseDTO;
import org.example.atlasrh.model.Contract;
import org.example.atlasrh.model.Department;
import org.example.atlasrh.model.Employee;

import java.util.List;

public interface ContractService {

    ContractResponseDTO create(Contract contract);

    ContractResponseDTO update(Long id, Contract contract);

    Department viewDepartment(Long id);

    List<ContractResponseDTO> viewAll();
}

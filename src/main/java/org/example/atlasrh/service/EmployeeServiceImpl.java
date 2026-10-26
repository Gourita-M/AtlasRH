package org.example.atlasrh.service;

import org.example.atlasrh.dto.DepartmentResponseDTO;
import org.example.atlasrh.dto.EmployeeResponseDTO;
import org.example.atlasrh.mapper.EmployeeMapper;
import org.example.atlasrh.model.Department;
import org.example.atlasrh.model.Employee;
import org.example.atlasrh.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentService departmentService;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            EmployeeMapper employeeMapper, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentService = departmentService;
    }

    @Override
    public Employee create(Employee employee, Long departmentId) {

        DepartmentResponseDTO department = departmentService.viewDepartment(departmentId);
        //employee.setDepartment();

        Employee savedEmployee = employeeRepository.save(employee);

        return savedEmployee;
    }

//     @Override
//     public EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto) {
//         Employee existingEmployee = employeeRepository.findById(id)
//                 .orElseThrow(() ->
//                         new RuntimeException("Employee not found: " + id));
//
//         //employeeMapper.updateEntity(dto, existingEmployee);
//
//         Employee updatedEmployee = employeeRepository.save(existingEmployee);
//
//         return employeeMapper.toResponseDTO(updatedEmployee);
//     }

     @Override
     public EmployeeResponseDTO viewEmployee(Long id) {
         Employee employee = employeeRepository.findById(id)
                 .orElseThrow(() ->
                         new RuntimeException("Employee not found: " + id));

         return employeeMapper.toResponseDTO(employee);
     }

    @Override
    public List<EmployeeResponseDTO> viewAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();
    }

     @Override
     public List<EmployeeResponseDTO> viewAllByManager(Long managerId) {
         throw new UnsupportedOperationException(
                 "Manager relationship has not been implemented yet");
     }
}

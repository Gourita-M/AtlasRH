package org.example.atlasrh.mapper;

import org.example.atlasrh.dto.EmployeeRequestDTO;
import org.example.atlasrh.dto.EmployeeResponseDTO;
import org.example.atlasrh.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeResponseDTO toResponseDTO(Employee employee);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeRequestDTO dto);

    //Employee updateEntity(EmployeeRequestDTO dto,Employee existingEmployee);
}
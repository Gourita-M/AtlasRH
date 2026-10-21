package org.example.atlasrh.dto;

import java.util.Date;

public record EmployeeResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String jobTitle,
        Date hireDate,
        String role
) {}
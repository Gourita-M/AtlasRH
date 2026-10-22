package org.example.atlasrh.dto;

import java.time.LocalDate;
import java.util.Date;

public record EmployeeResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String jobTitle,
        LocalDate hireDate,
        String role
) {}
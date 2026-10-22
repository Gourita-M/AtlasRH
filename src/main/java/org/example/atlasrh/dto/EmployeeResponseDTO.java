package org.example.atlasrh.dto;

import java.time.LocalDate;
import java.util.Date;

public record EmployeeResponseDTO(
        Long matricule,
        String firstName,
        String lastName,
        String email,
        String jobTitle,
        LocalDate hireDate,
        String role
) {}
package org.example.atlasrh.dto;

import java.util.Date;

public record EmployeeRequestDTO(
        String firstName,
        String lastName,
        String email,
        String jobTitle,
        Date hireDate,
        String role
) {}
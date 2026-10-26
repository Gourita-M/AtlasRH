package org.example.atlasrh.dto;

import jakarta.persistence.Column;
import org.example.atlasrh.model.Contract;

import java.time.LocalDate;

public record ContractResponseDTO(
        Long id,
        String contractType,
        LocalDate startDate,
        LocalDate endDate,
        Long salary
) {

}

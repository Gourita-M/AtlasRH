package org.example.atlasrh.repository;

import org.example.atlasrh.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    LeaveRequest findByIdAndEmployee_Matricule(Long requestId, long employeeId);
}

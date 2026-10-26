package org.example.atlasrh.service;

import org.example.atlasrh.dto.DepartmentResponseDTO;
import org.example.atlasrh.dto.LeaveRequestResponseDTO;
import org.example.atlasrh.model.Department;
import org.example.atlasrh.model.Employee;
import org.example.atlasrh.model.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {
    LeaveRequestResponseDTO create(LeaveRequest leaveRequest);

    LeaveRequestResponseDTO update(Long id, LeaveRequest leaveRequest);

    LeaveRequest viewLeaveRequest(Long id);

    List<LeaveRequestResponseDTO> viewAll();
}

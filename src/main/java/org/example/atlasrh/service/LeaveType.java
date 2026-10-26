package org.example.atlasrh.service;

import org.example.atlasrh.dto.LeaveRequestResponseDTO;
import org.example.atlasrh.dto.LeaveTypeResponseDTO;
import org.example.atlasrh.model.LeaveRequest;

import java.util.List;

public interface LeaveType {
    LeaveTypeResponseDTO create(LeaveType leaveType);

    LeaveTypeResponseDTO update(Long id, LeaveType leaveType);

    LeaveType viewLeaveType(Long id);

    List<LeaveTypeResponseDTO> viewAll();
}

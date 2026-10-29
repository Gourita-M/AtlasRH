package org.example.atlasrh.controller;

import org.example.atlasrh.Enum.LeaveStatus;
import org.example.atlasrh.dto.LeaveRequestResponseDTO;
import org.example.atlasrh.model.LeaveRequest;
import org.example.atlasrh.service.LeaveRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/leaverequest")
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody LeaveRequest leaveRequest,
                                    @RequestParam Long employeeId,
                                    @RequestParam Long leaveTypeId){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(leaveRequestService.create(leaveRequest, employeeId, leaveTypeId));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> update(Long id,@RequestBody LeaveRequest leaveRequest){
        try{
            return ResponseEntity.ok(leaveRequestService.update(id,leaveRequest));
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewLeaveRequest(@PathVariable Long id){
        try{
            return ResponseEntity.ok(leaveRequestService.viewLeaveRequest(id));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
//
//    List<LeaveRequestResponseDTO> viewAll();
//
//    List<LeaveRequestResponseDTO> getRequests(Long employeeId, Pageable pageable);
//
//    List<LeaveRequestResponseDTO> getMyRequestsByStatus(Long employeeId, LeaveStatus status, Pageable pageable);
//
//    boolean cancelRequest(Long employeeId, Long requestId);
//
//    boolean approveRequest(Long managerId, Long requestId, String comment);
//
//    boolean rejectRequest(Long managerId, Long requestId, String comment);
}

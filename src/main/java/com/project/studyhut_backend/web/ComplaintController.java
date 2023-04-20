package com.project.studyhut_backend.web;

import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.ComplaintDto;
import com.project.studyhut_backend.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complaints")
public class ComplaintController {


    private ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping
    public ResponseEntity<List<ComplaintDto>> getAllComplaints() {
        List<Complaint> complaints = complaintService.listAllComplaints();
        List<ComplaintDto> complaintDtos = complaints.stream()
                .map(complaint -> convertToDto(complaint))
                .collect(Collectors.toList());
        return ResponseEntity.ok(complaintDtos);
    }

    @PostMapping("/createComplaint")
    public ResponseEntity<ComplaintDto> createComplaint(@RequestBody ComplaintDto complaintDto) {
        User username = complaintDto.getUsername();
        LocalDateTime dateTimeCreated = LocalDateTime.now();
        Complaint complaint = complaintService.createComplaint(dateTimeCreated, complaintDto.getContent(), username);
        ComplaintDto createdComplaintDto = convertToDto(complaint);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComplaintDto);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> closeComplaint(@PathVariable Integer complaintID) {
        complaintService.closeComplaint(complaintID);
        return ResponseEntity.noContent().build();
    }

    private ComplaintDto convertToDto(Complaint complaint) {
        ComplaintDto complaintDto = new ComplaintDto();
        complaintDto.setDateTimeCreated(complaint.getDateTimeCreated());
        complaintDto.setContent(complaint.getContent());
        complaintDto.setSolved(complaint.isSolved());
        complaintDto.setUsername(complaint.getUser());
        return complaintDto;
    }
}

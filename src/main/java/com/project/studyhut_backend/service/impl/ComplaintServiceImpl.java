package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.exception.ComplaintNotFoundException;
import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.repository.ComplaintRepository;
import com.project.studyhut_backend.service.ComplaintService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    private final ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public List<Complaint> listAllComplaints() {
        return this.complaintRepository.findAll();
    }

    @Override
    public Complaint createComplaint(LocalDateTime dateTimeCreated, String content, User user) {
        Complaint complaint = new Complaint(dateTimeCreated, content, false, user);
        return this.complaintRepository.save(complaint);
    }

    @Override
    public void closeComplaint(Integer complaintID) {
        Complaint complaint = complaintRepository.findById(complaintID).orElseThrow(() -> new ComplaintNotFoundException(complaintID));
        complaint.setSolved(true);
        complaintRepository.save(complaint);
    }
}

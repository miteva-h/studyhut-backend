package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ComplaintService {
    List<Complaint> listAllComplaints();
    Complaint createComplaint(LocalDateTime dateTimeCreated, String content, User user);
    void closeComplaint(Integer complaintID);
}

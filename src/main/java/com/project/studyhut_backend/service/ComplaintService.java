package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.User;

import java.util.List;

public interface ComplaintService {
    List<Complaint> listAllComplaints();
    Complaint createComplaint(String content, User user);
    void closeComplaint(Integer complaintID);
}

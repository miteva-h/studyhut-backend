package com.project.studyhut_backend.exception;

public class ComplaintNotFoundException extends RuntimeException{
    public ComplaintNotFoundException(Integer complaintID) {
        super(String.format("Complaint with id: %d is not found", complaintID));
    }
}

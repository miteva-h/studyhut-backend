package com.project.studyhut_backend.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException() {
        super("Post not found.");
    }
}
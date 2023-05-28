package com.project.studyhut_backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void saveFile(MultipartFile file);
}

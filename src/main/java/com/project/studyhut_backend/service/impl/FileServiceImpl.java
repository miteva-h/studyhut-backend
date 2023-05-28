package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileServiceImpl  implements FileService {
    @Override
    public void saveFile(MultipartFile file) {
        try {

            String unique = String.valueOf(UUID.randomUUID());
            int index = file.getOriginalFilename().lastIndexOf('.');
            String fileName = unique + "." + file.getOriginalFilename().substring(index + 1);
            // Specify the absolute file path where you want to save the file
            String absoluteFilePath = "/path/to/save/file/" + file.getOriginalFilename();

            // Create the file object
            File destinationFile = new File(absoluteFilePath);

            // Save the file
            file.transferTo(destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Some error occurred!");
        }
    }
}

package com.spring.file_operations.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploaderService {

    void uploadFile(MultipartFile file);
}

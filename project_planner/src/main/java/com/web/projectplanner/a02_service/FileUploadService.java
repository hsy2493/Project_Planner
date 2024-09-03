package com.web.projectplanner.a02_service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	@Value("${user.upload}")
    private String uploadDir;

	    public String uploadFile(MultipartFile file) {
	        try {
	            if (file.isEmpty()) {
	                throw new IllegalArgumentException("파일이 비어 있습니다.");
	            }

	            Path uploadPath = Paths.get(uploadDir);
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	            }

	            String fileName = file.getOriginalFilename();
	            Path filePath = uploadPath.resolve(fileName);
	            file.transferTo(filePath.toFile());

	            return filePath.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("파일 저장 중 오류 발생", e);
	        }
	    }
	    
	    public void deleteFile(String filepath) {
	        try {
	            Path fileToDeletePath = Paths.get(filepath);
	            Files.deleteIfExists(fileToDeletePath);
	        } catch (IOException e) {
	            throw new RuntimeException("파일 삭제 중 오류 발생", e);
	        }
	    }
}

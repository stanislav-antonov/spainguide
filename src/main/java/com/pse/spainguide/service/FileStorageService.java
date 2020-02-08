package com.pse.spainguide.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pse.spainguide.FileStorageProperties;
import com.pse.spainguide.exception.FileStorageException;

@Service
public class FileStorageService implements IFileStorageService {

    final private Path fileBasePath;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileBasePath = fileStorageProperties.getNormalizedBasePath();
        ensureBaseDirectory();
    }

    private void ensureBaseDirectory() {
        try {
            Files.createDirectories(this.fileBasePath);
        } catch (IOException ex) {
            throw new FileStorageException("Failed to create base directory: " + this.fileBasePath, ex);
        }
    }

    @Override
    public String store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Path targetFilePath = this.fileBasePath.resolve(fileName);
            Files.copy(file.getInputStream(), targetFilePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Failed to store file: " + fileName, ex);
        }
    }

    @Override
    public Resource loadAsResource(String fileName) {
        try {
            Path filePath = this.fileBasePath.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File is not found: " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File is not found: " + fileName, ex);
        }
    }
}

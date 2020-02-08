package com.pse.spainguide.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFileStorageService {
    String store(MultipartFile file);
    Resource loadAsResource(String fileName);
}

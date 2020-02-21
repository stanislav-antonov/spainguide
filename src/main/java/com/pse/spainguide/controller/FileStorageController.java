package com.pse.spainguide.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pse.spainguide.response.FileStoreResponse;
import com.pse.spainguide.service.IFileStorageService;

@RestController
@RequestMapping("/api/file-storage")
public class FileStorageController {

    private static final Logger logger = LoggerFactory.getLogger(FileStorageController.class);

    @Autowired
    private IFileStorageService fileStorageService;

    public FileStorageController(IFileStorageService storageService) {
        this.fileStorageService = storageService;
    }

    @PostMapping("/store-file")
    public FileStoreResponse store(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.store(file);
        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/file-storage/load-file/").path(fileName).build().toUriString();

        return new FileStoreResponse(fileName, fileUri, file.getContentType(), file.getSize());
    }

    @GetMapping("/load-file/{fileName:.+}")
    public ResponseEntity<Resource> load(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileStorageService.loadAsResource(fileName);
        MediaType mediaType = guessContentType(request, resource);

        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    private MediaType guessContentType(HttpServletRequest request, Resource resource) {
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return MediaType.parseMediaType(contentType);
    }
}

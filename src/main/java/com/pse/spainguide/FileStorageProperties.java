package com.pse.spainguide;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file-storage")
public class FileStorageProperties {

    final private static Path defaultBasePath = Paths.get("resources","static", "file-storage");

    private String basePath;

    public String getBasePath() {
        return this.basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public Path getNormalizedBasePath() {
        String basePath = getBasePath();
        if (basePath == null || basePath.isEmpty()) {
            basePath = defaultBasePath.toString();
        }

        return Paths.get(basePath).toAbsolutePath().normalize();
    }
}

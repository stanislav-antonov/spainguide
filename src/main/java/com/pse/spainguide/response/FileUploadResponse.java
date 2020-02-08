package com.pse.spainguide.response;

public class FileUploadResponse {
    final private String name;
    final private String uri;
    final private String type;
    final private long size;

    public FileUploadResponse(String name, String uri, String type, long size) {
        this.name = name;
        this.uri = uri;
        this.type = type;
        this.size = size;
    }
}

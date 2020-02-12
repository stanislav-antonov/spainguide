package com.pse.spainguide.response;

public class FileStoreResponse {
    private String name;
    private String uri;
    private String type;
    private long size;

    public FileStoreResponse(String name, String uri, String type, long size) {
        this.name = name;
        this.uri = uri;
        this.type = type;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public String getUri(String uri) {
        return this.uri;
    }

    public String getType() {
        return this.type;
    }

    public long getSize() {
        return this.size;
    }
}

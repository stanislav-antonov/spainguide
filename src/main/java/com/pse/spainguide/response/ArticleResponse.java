package com.pse.spainguide.response;

import java.sql.Date;

public class ArticleResponse {
    private long id;
    private String headline;
    private String alias;
    private String title;
    private String description;
    private String preview;
    private String content;
    private boolean active;
    private String imageUri;
    private Date created;
    private Date updated;

    public void setId(long id) {
        this.id = id;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public long getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getAlias() {
        return alias;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPreview() {
        return preview;
    }

    public String getContent() {
        return content;
    }

    public boolean getActive() {
        return active;
    }

    public String getImageUri() {
        return imageUri;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }
}




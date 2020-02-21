package com.pse.spainguide.request;

public class ArticleRequest {
    private long id;
    private String headline;
    private String alias;
    private String title;
    private String description;
    private String preview;
    private String content;
    private boolean active;
    private String image;

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

    public void setImage(String image) {
        this.image = image;
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

    public String getImage() {
        return image;
    }
}




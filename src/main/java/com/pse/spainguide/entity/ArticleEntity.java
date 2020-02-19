package com.pse.spainguide.entity;

import java.sql.Date;

public class ArticleEntity {

    public static final String Table = "article";

    public static class Columns {
        public final static String Id = "id";
        public final static String Headline = "headline";
        public final static String Alias = "alias";
        public final static String Title = "title";
        public final static String Description = "description";
        public final static String Preview = "preview";
        public final static String Content = "content";
        public final static String Active = "active";
        public final static String ImageUri = "imageUri";
        public final static String Created = "created";
        public final static String Updated = "updated";
    }

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

    // For auto-mapper
    public ArticleEntity() {}

    public ArticleEntity(long id, String headline, String alias, String title, String description,
            String preview, String content, boolean active, String imageUri, Date created, Date updated) {
        this.id = id;
        this.headline = headline;
        this.alias = alias;
        this.title = title;
        this.description = description;
        this.preview = preview;
        this.content = content;
        this.active = active;
        this.imageUri = imageUri;
        this.created = created;
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


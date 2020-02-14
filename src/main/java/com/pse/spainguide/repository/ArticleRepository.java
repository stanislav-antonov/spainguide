package com.pse.spainguide.repository;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pse.spainguide.entity.ArticleEntity;

public class ArticleRepository {

    private static final Logger log = LoggerFactory.getLogger(ArticleRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Collection<ArticleEntity> getList() {
        return jdbcTemplate.query("SELECT " +
                        ArticleEntity.Columns.Id + ", " +
                        ArticleEntity.Columns.Headline + ", " +
                        ArticleEntity.Columns.Alias + ", " +
                        ArticleEntity.Columns.Title + ", " +
                        ArticleEntity.Columns.Description + ", " +
                        ArticleEntity.Columns.Preview + ", " +
                        ArticleEntity.Columns.Content + ", " +
                        ArticleEntity.Columns.Active + ", " +
                        ArticleEntity.Columns.ImageUri + ", " +
                        ArticleEntity.Columns.Created + ", " +
                        ArticleEntity.Columns.Updated +
                        " FROM " + ArticleEntity.Table,
                (rs, rowNum) -> ArticleEntity.create(rs)
        );
    }
}

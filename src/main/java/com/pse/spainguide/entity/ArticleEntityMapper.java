package com.pse.spainguide.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArticleEntityMapper implements RowMapper<ArticleEntity> {
    public ArticleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ArticleEntity(
                rs.getLong(ArticleEntity.Columns.Id),
                rs.getString(ArticleEntity.Columns.Headline),
                rs.getString(ArticleEntity.Columns.Alias),
                rs.getString(ArticleEntity.Columns.Title),
                rs.getString(ArticleEntity.Columns.Description),
                rs.getString(ArticleEntity.Columns.Preview),
                rs.getString(ArticleEntity.Columns.Content),
                rs.getBoolean(ArticleEntity.Columns.Active),
                rs.getString(ArticleEntity.Columns.Image),
                rs.getDate(ArticleEntity.Columns.Created),
                rs.getDate(ArticleEntity.Columns.Updated)
        );
    }
}

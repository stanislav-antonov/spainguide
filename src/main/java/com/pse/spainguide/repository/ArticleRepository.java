package com.pse.spainguide.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.pse.spainguide.entity.ArticleEntity;
import com.pse.spainguide.entity.ArticleEntityMapper;

@Component
public class ArticleRepository {

    private static final Logger log = LoggerFactory.getLogger(ArticleRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int create(ArticleEntity article) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO " +
                    ArticleEntity.Table + "(" +
                    ArticleEntity.Columns.Headline + ", " +
                    ArticleEntity.Columns.Alias + ", " +
                    ArticleEntity.Columns.Title + ", " +
                    ArticleEntity.Columns.Description + ", " +
                    ArticleEntity.Columns.Preview + ", " +
                    ArticleEntity.Columns.Content + ", " +
                    ArticleEntity.Columns.Active + ", " +
                    ArticleEntity.Columns.Image +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, article.getHeadline());
            preparedStatement.setString(2, article.getAlias());
            preparedStatement.setString(3, article.getTitle());
            preparedStatement.setString(4, article.getDescription());
            preparedStatement.setString(5, article.getPreview());
            preparedStatement.setString(6, article.getContent());
            preparedStatement.setBoolean(7, article.getActive());
            preparedStatement.setString(8, article.getImage());

            return preparedStatement;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    public void update(ArticleEntity article) {
        jdbcTemplate.update("UPDATE " + ArticleEntity.Table + " SET " +
                ArticleEntity.Columns.Headline + " = ?, " +
                ArticleEntity.Columns.Alias + " = ?, " +
                ArticleEntity.Columns.Title + " = ?, " +
                ArticleEntity.Columns.Description + " = ?, " +
                ArticleEntity.Columns.Preview + " = ?, " +
                ArticleEntity.Columns.Content + " = ?, " +
                ArticleEntity.Columns.Active + " = ?, " +
                ArticleEntity.Columns.Image + " = ? " +
            " WHERE id = ? ",
                article.getHeadline(),
                article.getAlias(),
                article.getTitle(),
                article.getDescription(),
                article.getPreview(),
                article.getContent(),
                article.getActive(),
                article.getImage(),
                article.getId());
    }

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
                        ArticleEntity.Columns.Image + ", " +
                        ArticleEntity.Columns.Created + ", " +
                        ArticleEntity.Columns.Updated +
                        " FROM " + ArticleEntity.Table,
                new ArticleEntityMapper()
        );
    }

    public Optional<ArticleEntity> getOne(int id) {
        return jdbcTemplate.query("SELECT " +
                        ArticleEntity.Columns.Id + ", " +
                        ArticleEntity.Columns.Headline + ", " +
                        ArticleEntity.Columns.Alias + ", " +
                        ArticleEntity.Columns.Title + ", " +
                        ArticleEntity.Columns.Description + ", " +
                        ArticleEntity.Columns.Preview + ", " +
                        ArticleEntity.Columns.Content + ", " +
                        ArticleEntity.Columns.Active + ", " +
                        ArticleEntity.Columns.Image + ", " +
                        ArticleEntity.Columns.Created + ", " +
                        ArticleEntity.Columns.Updated +
                        " FROM " + ArticleEntity.Table + " WHERE id = ?",
                new Object[] { id },
                new ArticleEntityMapper()
        ).stream().findFirst();
    }
}

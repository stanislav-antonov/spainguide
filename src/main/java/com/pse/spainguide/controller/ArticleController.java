package com.pse.spainguide.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pse.spainguide.repository.ArticleRepository;
import com.pse.spainguide.response.ArticleResponse;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/list")
    public Collection<ArticleResponse> list() {
        ObjectMapper objectMapper = new ObjectMapper();
        return articleRepository.getList()
                .stream()
                .map(articleEntity -> objectMapper.convertValue(articleEntity, ArticleResponse.class))
                .collect(Collectors.toList());
    }
}
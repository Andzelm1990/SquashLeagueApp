package com.example.logowanie.service;


import com.example.logowanie.entity.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.net.URL;
import java.util.List;


public class ApiArticleConector {


    public static List<Article> downloadArticles() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<List<Article>> work = new Callable<List<Article>>() {
            @Override
            public List<Article> call() throws Exception {
                ObjectMapper objectMapper = new ObjectMapper();
                List<Article> articles = objectMapper.readValue(new URL("https://squashleague.alwaysdata.net/articles"), new TypeReference<List<Article>>() {});
                return articles;
            }
        };
        try {
            Future<List<Article>> wynik = executor.submit(work);
            List<Article> endlist = wynik.get();
            return endlist;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            executor.shutdown();
        }
    }


   /* public static String test (){
        List<Article> articles = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            articles = objectMapper.readValue(new URL("https://squashleague.alwaysdata.net/articles"), new TypeReference<List<Article>>() {});
            return articles.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }*/

    /*public static List<Article> downloadArticle (){
        List<Article> articles = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            articles = objectMapper.readValue(new URL("https://squashleague.alwaysdata.net/articles"), new TypeReference<List<Article>>() {});
            return articles;
        } catch (Exception e) {
            e.printStackTrace();
            return articles;
        }

    }*/
}

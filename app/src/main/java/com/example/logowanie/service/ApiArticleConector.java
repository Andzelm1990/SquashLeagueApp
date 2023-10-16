package com.example.logowanie.service;

import com.example.logowanie.entity.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This class provides methods to download articles from a remote API.
 */
public class ApiArticleConector {

    /**
     * Downloads a list of articles from a remote API.
     *
     * @return A list of articles or null if an error occurs during the download.
     */
    public static List<Article> downloadArticles() {
        // Create a single-threaded executor service to perform the download task.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Define a Callable task to perform the article download.
        Callable<List<Article>> work = new Callable<List<Article>>() {
            @Override
            public List<Article> call() throws Exception {
                // Initialize the ObjectMapper for JSON deserialization.
                ObjectMapper objectMapper = new ObjectMapper();

                // Make an HTTP request to the remote API and deserialize the JSON response.
                List<Article> articles = objectMapper.readValue(
                        new URL("https://squashleague.alwaysdata.net/articles"),
                        new TypeReference<List<Article>>() {}
                );

                return articles;
            }
        };

        try {
            // Submit the Callable task to the executor.
            Future<List<Article>> result = executor.submit(work);

            // Get the result of the download operation.
            List<Article> articleList = result.get();

            return articleList;
        } catch (Exception e) {
            // Handle exceptions and print the stack trace for debugging.
            e.printStackTrace();
            return null;
        } finally {
            // Shutdown the executor service to release resources.
            executor.shutdown();
        }
    }
}
package org.tugasakhir.abram_pbi_mobile.ui.models;

import java.util.List;

public class NewsApiResponse {
    String status ;
    int totalResults;
    List<NewHeadLines> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewHeadLines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewHeadLines> articles) {
        this.articles = articles;
    }
}

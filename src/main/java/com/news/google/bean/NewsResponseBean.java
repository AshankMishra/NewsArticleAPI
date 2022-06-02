package com.news.google.bean;

import java.util.ArrayList;

public class NewsResponseBean {

	private String status;
	private Integer totalResults;
	private ArrayList<Article> articles;

	public String getStatus() {
		return status;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	@Override
	public String toString() {
		return "NewsResponseBean [status=" + status + ", totalResults=" + totalResults + ", articles=" + articles + "]";
	}

}

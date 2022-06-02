package com.news.google.bean;

import java.util.Date;

public class Article {
	private Source source;
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private Date publishedAt;
	private String content;

	public Source getSource() {
		return source;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Article [source=" + source + ", author=" + author + ", title=" + title + ", description=" + description
				+ ", url=" + url + ", urlToImage=" + urlToImage + ", publishedAt=" + publishedAt + ", content="
				+ content + "]";
	}

}

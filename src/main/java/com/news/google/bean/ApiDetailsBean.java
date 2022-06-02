package com.news.google.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiDetailsBean {
	@Value("${news.sources.url}")
	private String baseUrl;

	@Value("${news.sources.google}")
	private String source;

	@Value("${news.sources.apikey}")
	private String apiKey;

	public String getBaseUrl() {
		return baseUrl;
	}

	public String getSource() {
		return source;
	}

	public String getApiKey() {
		return apiKey;
	}

}

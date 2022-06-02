package com.news.google.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.news.google.bean.ApiDetailsBean;
import com.news.google.bean.Article;
import com.news.google.bean.NewsResponseBean;

@Service
public class NewsService implements NewsServiceImpl {

	@Autowired
	public ApiDetailsBean apiDetailsBean;

	@Override
	public List<Map<String, Object>> getGoogleNews(String keyWords) {
		List<Map<String, Object>> listOfResponse = new ArrayList<>();
		try {

			String keywordArray[] = keyWords.trim().split("\\s*,\\s*");

			String urlForResponse = apiDetailsBean.getBaseUrl() + "?sources=" + apiDetailsBean.getSource() + "&q="
					+ URLEncoder.encode(String.join(" AND ", keywordArray), StandardCharsets.UTF_8.toString())
					+ "&apiKey=" + apiDetailsBean.getApiKey();

			WebClient webClient = WebClient.create();
			WebClient.ResponseSpec responseSpec = webClient.get().uri(urlForResponse).retrieve();
			NewsResponseBean responsebody = responseSpec.bodyToMono(NewsResponseBean.class).block();
			System.out.println("responseSpec " + responsebody);

			// Response to be sent
			if (responsebody != null && responsebody.getArticles().size() > 0) {
				for (Article article : responsebody.getArticles()) {
					Map<String, Object> responseMap = new HashMap<>();
					responseMap.put("Author", article.getAuthor() == null ? "" : article.getAuthor());
					responseMap.put("Title", article.getTitle() == null ? "" : article.getTitle());
					responseMap.put("Description", article.getDescription() == null ? "" : article.getDescription());
					responseMap.put("News URL", article.getUrl() == null ? "" : article.getUrl());
					responseMap.put("Publish Date", article.getPublishedAt() == null ? "" : article.getPublishedAt());
					responseMap.put("News Content", article.getContent() == null ? "" : article.getContent());
					listOfResponse.add(responseMap);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfResponse;
	}

}
